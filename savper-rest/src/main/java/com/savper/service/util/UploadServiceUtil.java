package com.savper.service.util;

import com.savper.dto.LastRevisionDto;
import com.savper.model.RevisionFile;
import com.savper.model.RevisionFolder;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import org.modelmapper.ModelMapper;

/**
 * Created by eriel.marimon on 1/21/18.
 */
public class UploadServiceUtil {

  public static RevisionFolder createNewRevisionFolder(String fileName, String notes) {
    final int INITIAL_LIVE_INDEX = 0;

    Date now = new Date();

    RevisionFile revisionFile = new RevisionFile();
    revisionFile.setDate(now);
    revisionFile.setIndex(INITIAL_LIVE_INDEX);
    revisionFile.setChangeNotes(notes);

    List<RevisionFile> revisions = new ArrayList<>();
    revisions.add(revisionFile);

    RevisionFolder revisionFolder = new RevisionFolder();

    revisionFolder.setFileName(fileName);
    revisionFolder.setCreated(now);
    revisionFolder.setLiveIndex(INITIAL_LIVE_INDEX);
    revisionFolder.setDescription(notes);
    revisionFolder.setRevisions(revisions);

    return revisionFolder;
  }

  public static boolean saveNewRevision(MultipartFile inFile, long liveIndex, String filesLocation)
      throws IOException {
    String fileOutPathFormat = "%s/%s_%s";
    String outFilePathName = String
        .format(fileOutPathFormat, filesLocation, liveIndex, inFile.getOriginalFilename());
    File outFile = new File(outFilePathName);

    inFile.transferTo(outFile);

    /*TODO: If IOExc thrown, return false.*/
    return true;
  }

  public static void validateRevisionFile(MultipartFile multipartFile) {

  }

  public static LastRevisionDto getLastRevisionFromFolder(RevisionFolder savedRevisionFolder) {

    ModelMapper modelMapper = new ModelMapper();
    LastRevisionDto lastRevisionDto = modelMapper.map(savedRevisionFolder, LastRevisionDto.class);

    DateFormat targetFormat = new SimpleDateFormat("MMM dd, yyyy - hh:mma");

    if(savedRevisionFolder.getCreated() != null){
      lastRevisionDto.setCreated(targetFormat.format(savedRevisionFolder.getCreated()));
    }

    if(savedRevisionFolder.getUpdated() != null){
      lastRevisionDto.setUpdated(targetFormat.format(savedRevisionFolder.getUpdated()));
    }

    RevisionFile lastRevision = savedRevisionFolder.getRevisions()
        .get(savedRevisionFolder.getLiveIndex());

    lastRevisionDto.setLastChangeNote(lastRevision.getChangeNotes());
    lastRevisionDto.setRevisionNumber(savedRevisionFolder.getLiveIndex());

    return lastRevisionDto;
  }
}
