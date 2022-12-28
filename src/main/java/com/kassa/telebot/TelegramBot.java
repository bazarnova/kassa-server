package com.kassa.telebot;

import com.kassa.entity.Photo;
import com.kassa.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    final BotConfig config;

    @Autowired
    private final IPhotoService photoService;

    public TelegramBot(BotConfig config, IPhotoService photoService) {
        this.config = config;
        this.photoService = photoService;
    }

    @Override
    public String getBotUsername() {
        return config.getName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasPhoto()) {

            List<PhotoSize> photos = update.getMessage().getPhoto();
            PhotoSize photo = photos.get(3);
            try {
                GetFile getFile = new GetFile();
                getFile.setFileId(photo.getFileId());
                String filePath = execute(getFile).getFilePath();
                Integer date = update.getMessage().getDate();
                LocalDate localDate = Instant.ofEpochSecond(date).atZone(ZoneId.systemDefault()).toLocalDate();
                String path = "D:\\telebot" + "/" + localDate + "/" + photo.getFileId() + ".jpg";
                downloadFile(filePath, new File(path));

                Photo newPhoto = new Photo.Builder()
                        .setFileId(photo.getFileId())
                        .setMessageDate(localDate)
                        .setAddedDate(LocalDate.now())
                        .setProcessed(false)
                        .setPath(path)
                        .build();
                photoService.addPhoto(newPhoto);

            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
