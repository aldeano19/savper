package com.savper.util;

import java.io.File;

/**
 * Created by eriel.marimon on 1/21/18.
 */
public class FilesystemHandler {
  public static void createDirectoryIfNotExists(String filesLocation) {
    File directory = new File(filesLocation);
    if(!directory.exists()){
      directory.mkdirs();
    }
  }
}
