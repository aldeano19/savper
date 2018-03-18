package com.savper.model;

import java.util.Date;

/**
 * Created by eriel.marimon on 1/15/18.
 */
public class RevisionFile {

  private Date date;
  private long index;
  private String changeNotes;

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public long getIndex() {
    return index;
  }

  public void setIndex(long index) {
    this.index = index;
  }

  public String getChangeNotes() {
    return changeNotes;
  }

  public void setChangeNotes(String changeNotes) {
    this.changeNotes = changeNotes;
  }
}
