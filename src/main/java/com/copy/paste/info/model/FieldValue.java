package com.copy.paste.info.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class FieldValue {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  private String fieldName;

  @Column
  private String fieldValue;

  @ManyToOne(fetch = FetchType.LAZY)
  private MainFolder mainFolder;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public String getFieldValue() {
    return fieldValue;
  }

  public void setFieldValue(String fieldValue) {
    this.fieldValue = fieldValue;
  }

  public MainFolder getMainFolder() {
    return mainFolder;
  }

  public void setMainFolder(MainFolder mainFolder) {
    this.mainFolder = mainFolder;
  }

  @Override
  public String toString() {
    return "FieldValue [id=" + id + ", fieldName=" + fieldName + ", fieldValue=" + fieldValue
        + ", mainFolder=" + mainFolder + "]";
  }

}
