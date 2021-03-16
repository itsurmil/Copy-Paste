package com.copy.paste.info.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.copy.paste.info.model.FieldValue;
import com.copy.paste.info.model.MainFolder;
import com.copy.paste.info.repository.FieldValueRepository;
import com.copy.paste.info.repository.MainFolderRepository;


@Controller
public class InfoPageController {
  static Log log = LogFactory.getLog(InfoPageController.class.getName());

  @Autowired
  MainFolderRepository mainFolderRepository;

  @Autowired
  FieldValueRepository fieldValueRepository;

  @RequestMapping(value = "/info")
  public String getInfo(Model model) {
    model.addAttribute("mainFolderList", mainFolderRepository.findAll());
    return "info";
  }

  @RequestMapping(value = "/info-details")
  public String getInfo(Model model, @RequestParam(name = "folderId") String folderId) {
    log.info("check here :: " + folderId);
    model.addAttribute("fieldValueList", fieldValueRepository
        .findByMainFolderId(mainFolderRepository.getOne(Long.parseLong(folderId)).getId()));
    model.addAttribute("folderId", folderId);
    return "infoDetails";
  }

  @RequestMapping(value = "/add-info-data")
  public String addFieldData(Model model, @RequestParam(name = "folderId") String folderId,
      @RequestParam(name = "fieldName") String fieldName,
      @RequestParam(name = "fieldValue") String fieldValue) {
    log.info("add field method called " + fieldName + fieldValue);

    FieldValue fv = new FieldValue();
    fv.setFieldName(fieldName);
    fv.setFieldValue(fieldValue);
    fv.setMainFolder(mainFolderRepository.findById(Long.parseLong(folderId)));
    fieldValueRepository.save(fv);

    model.addAttribute("fieldValueList", fieldValueRepository
        .findByMainFolderId(mainFolderRepository.getOne(Long.parseLong(folderId)).getId()));
    model.addAttribute("folderId", folderId);
    return "redirect:/info-details?folderId=" + folderId;
  }

  @RequestMapping(value = "/update-field")
  public String updateFieldData(Model model, @RequestParam(name = "fieldId") String fieldId,
      @RequestParam(name = "fieldName") String fieldName,
      @RequestParam(name = "fieldValue") String fieldValue) {
    log.info("add field method called " + fieldName + fieldValue);

    FieldValue fv = fieldValueRepository.findById(Long.parseLong(fieldId));
    fv.setFieldName(fieldName);
    fv.setFieldValue(fieldValue);
    fieldValueRepository.save(fv);
    long folderId = fv.getMainFolder().getId();
    model.addAttribute("fieldValueList",
        fieldValueRepository.findByMainFolderId(mainFolderRepository.getOne(folderId).getId()));
    model.addAttribute("folderId", folderId);
    return "redirect:/info-details?folderId=" + folderId;
  }

  @RequestMapping(value = "/add-new-folder")
  public String addInfoData(Model model, @RequestParam(name = "folderName") String folderName) {
    log.info("add folder method called : " + folderName);

    MainFolder mainFolder = new MainFolder();
    mainFolder.setFolderName(folderName);
    mainFolderRepository.save(mainFolder);

    model.addAttribute("mainFolderList", mainFolderRepository.findAll());
    return "redirect:/info";
  }

  @RequestMapping(value = "/update-folder")
  public String updateFolderData(Model model, @RequestParam(name = "folderId") String folderId,
      @RequestParam(name = "folderName") String folderName) {
    log.info("add folder method called : " + folderName);
    MainFolder mainFolder = mainFolderRepository.findById(Long.parseLong(folderId));
    mainFolder.setFolderName(folderName);
    mainFolderRepository.save(mainFolder);
    model.addAttribute("mainFolderList", mainFolderRepository.findAll());
    return "redirect:/info";
  }

  @RequestMapping(value = "/delete-info")
  public String deleteInfoData(@RequestParam(name = "fieldId") String fieldId,
      @RequestParam(name = "folderId") String folderId) {
    log.info("delete field method called :: " + fieldId);
    fieldValueRepository.deleteById(Long.parseLong(fieldId));
    return "redirect:/info-details?folderId=" + folderId;
  }

  @RequestMapping(value = "/delete-folder")
  public String deleteFolderData(@RequestParam(name = "folderId") String folderId) {
    log.info("delete folder method called :: " + folderId);
    mainFolderRepository.deleteById(Long.parseLong(folderId));
    return "redirect:/info";
  }
}
