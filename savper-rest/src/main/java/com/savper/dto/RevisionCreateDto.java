package com.savper.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by eriel.marimon on 1/21/18.
 */
public class RevisionCreateDto {
  private MultipartFile multipartFile;
  private String notes;

  public MultipartFile getMultipartFile() {
    return multipartFile;
  }

  public void setMultipartFile(MultipartFile multipartFile) {
    this.multipartFile = multipartFile;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}
