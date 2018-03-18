package com.savper.controller;

import com.savper.dto.LastRevisionDto;
import com.savper.dto.RevisionCreateDto;
import com.savper.model.RevisionFolder;
import com.savper.model.RevisionFile;
import com.savper.service.UploadService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by eriel.marimon on 1/15/18.
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

  @Autowired
  private UploadService uploadService;

  @CrossOrigin
  @RequestMapping(method = RequestMethod.POST)
  public RevisionFolder create(@RequestParam(required = false) String notes,
      @RequestBody MultipartFile fileIn) throws Exception {

    return uploadService.create(fileIn, notes);
  }

  @CrossOrigin
  @RequestMapping(method = RequestMethod.PATCH)
  public LastRevisionDto reviseDocument(@RequestParam(required = false) String notes,
      @RequestBody MultipartFile fileIn) throws Exception {
    return uploadService.reviseDocument(fileIn, notes);
  }

  @CrossOrigin
  @RequestMapping(method = RequestMethod.GET)
  public List<LastRevisionDto> getLatestRevisions(){
    return uploadService.findLatestRevisions();
  }

}
