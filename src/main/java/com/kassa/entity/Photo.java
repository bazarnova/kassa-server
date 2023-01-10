package com.kassa.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    @Column(name = "file_id")
    String fileId;
    @Column(name = "message_date")
    LocalDate messageDate;
    @Column(name = "added_date")
    LocalDate addedDate;
    Boolean processed;
    String path;
}
