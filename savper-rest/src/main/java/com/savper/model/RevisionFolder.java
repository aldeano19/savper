package com.savper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import javax.management.Descriptor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by eriel.marimon on 1/15/18.
 */
@Document(collection="bundles")
public class RevisionFolder {
  @JsonIgnore
  @Id
  private ObjectId id;

  @Indexed(unique = true)
  private String fileName;
  private Date created;
  private Date updated;
  private String description;
  private int liveIndex;
  private List<RevisionFile> revisions;

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(Date updated) {
    this.updated = updated;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getLiveIndex() {
    return liveIndex;
  }

  public void setLiveIndex(int liveIndex) {
    this.liveIndex = liveIndex;
  }

  public List<RevisionFile> getRevisions() {
    return revisions;
  }

  public void setRevisions(List<RevisionFile> revisions) {
    this.revisions = revisions;
  }
}
