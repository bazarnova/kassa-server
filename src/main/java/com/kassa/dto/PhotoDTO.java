package com.kassa.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhotoDTO {
    String id;
    String fileId;
    LocalDate messageDate;
    LocalDate addedDate;
    Boolean processed;
    String path;
}
