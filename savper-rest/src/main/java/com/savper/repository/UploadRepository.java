package com.savper.repository;

import com.savper.dto.LastRevisionDto;
import com.savper.model.RevisionFile;
import com.savper.model.RevisionFolder;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by eriel.marimon on 1/21/18.
 */
public interface UploadRepository extends MongoRepository<RevisionFolder, String> {


  RevisionFolder findByFileName(String fileName);
}
