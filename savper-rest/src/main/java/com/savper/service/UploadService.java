package com.savper.service;

import com.savper.dto.LastRevisionDto;
import com.savper.model.RevisionFile;
import com.savper.model.RevisionFolder;
import com.savper.repository.UploadRepository;
import com.savper.service.util.UploadServiceUtil;
import com.savper.util.FilesystemHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by eriel.marimon on 1/21/18.
 */
@Service
public class UploadService {

  private static final String FILES_LOCATION = "/opt/savper/files";

  @Autowired
  private UploadRepository uploadRepository;


  public RevisionFolder create(MultipartFile fileIn, String notes) throws Exception {

    UploadServiceUtil.validateRevisionFile(fileIn);
    String fileName = fileIn.getOriginalFilename();

    FilesystemHandler.createDirectoryIfNotExists(FILES_LOCATION);

    RevisionFolder revisionFolder = UploadServiceUtil.createNewRevisionFolder(fileName, notes);

    if (!UploadServiceUtil.saveNewRevision(fileIn, revisionFolder.getLiveIndex(), FILES_LOCATION)) {
      /*TODO: Throw my own Exception*/
      throw new Exception("Cant save file.");
    }

    return uploadRepository.save(revisionFolder);
  }


  public LastRevisionDto reviseDocument(MultipartFile fileIn, String notes) throws Exception {

    UploadServiceUtil.validateRevisionFile(fileIn);
    String fileName = fileIn.getOriginalFilename();

    RevisionFolder revisionFolder = uploadRepository.findByFileName(fileName);

    if (revisionFolder == null) {
      /* TODO: Create custom exception to throw. */
      throw new Exception("Doesnt exist.");
    }

    Date now = new Date();
    int newRevisionIndex = revisionFolder.getLiveIndex() + 1;

    RevisionFile revisionFile = new RevisionFile();
    revisionFile.setChangeNotes(notes);
    revisionFile.setDate(now);
    revisionFile.setIndex(newRevisionIndex);

    revisionFolder.setLiveIndex(newRevisionIndex);
    revisionFolder.getRevisions().add(revisionFile);
    revisionFolder.setUpdated(now);

    if (!UploadServiceUtil.saveNewRevision(fileIn, revisionFolder.getLiveIndex(), FILES_LOCATION)) {
      /* TODO: Create custom exception. */
      throw new Exception("Could not transfer new revision.");
    }

    RevisionFolder savedRevisionFolder = uploadRepository.save(revisionFolder);


    return UploadServiceUtil.getLastRevisionFromFolder(savedRevisionFolder);

  }


  public List<LastRevisionDto> findLatestRevisions() {
    List<RevisionFolder> allRervisionFolders = uploadRepository.findAll();

    List<LastRevisionDto> latestRevisions = new ArrayList<>();

    for(RevisionFolder revisionFolder : allRervisionFolders){
      latestRevisions.add(UploadServiceUtil.getLastRevisionFromFolder(revisionFolder));
    }

    return latestRevisions;
  }
}
