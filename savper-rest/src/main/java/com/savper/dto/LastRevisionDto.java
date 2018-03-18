package com.savper.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by eriel.marimon on 1/21/18.

@Indexed(unique = true)
private String fileName;
private Date created;
private Date updated;
private String description;
private int liveIndex;
private List<RevisionFile> revisions;
 */
public class LastRevisionDto {
  private String fileName;
  private String created;
  private String updated;
  private String description;
  private String lastChangeNote;
  private long revisionNumber;

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }


  public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLastChangeNote() {
    return lastChangeNote;
  }

  public void setLastChangeNote(String lastChangeNote) {
    this.lastChangeNote = lastChangeNote;
  }

  public long getRevisionNumber() {
    return revisionNumber;
  }

  public void setRevisionNumber(long revisionNumber) {
    this.revisionNumber = revisionNumber;
  }
}
