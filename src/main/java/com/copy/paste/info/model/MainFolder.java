package com.copy.paste.info.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MainFolder")
public class MainFolder {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  private String folderName;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "main_folder_id", referencedColumnName = "id")
  private Set<FieldValue> fieldValue = new HashSet<FieldValue>();;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFolderName() {
    return folderName;
  }

  public void setFolderName(String folderName) {
    this.folderName = folderName;
  }

  public Set<FieldValue> getFieldValue() {
    return fieldValue;
  }

  public void setFieldValue(Set<FieldValue> fieldValue) {
    this.fieldValue = fieldValue;
  }

}
