package com.example.demo_file_upload.payload;

import com.example.demo_file_upload.model.DBFile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UploadFileResponse {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private Long size;
    List<DBFile> dbFiles;
}
