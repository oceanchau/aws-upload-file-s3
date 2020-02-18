package com.example.demo_file_upload.controller;

import com.example.demo_file_upload.model.DBFile;
import com.example.demo_file_upload.payload.FormWrapper;
import com.example.demo_file_upload.payload.UploadFileResponse;
import com.example.demo_file_upload.service.DBFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);
//    https://stackoverflow.com/questions/49845355/spring-boot-controller-upload-multipart-and-json-to-dto
    @Autowired
    private DBFileService dbFileService;

    @PostMapping("/uploadFile")
    public DBFile uploadFile(@ModelAttribute FormWrapper formWrapper) {
        DBFile dbFile = dbFileService.storeFile(formWrapper);
//        List<DBFile> dbFiles =  Arrays.asList(dbFile, dbFile)
//                .stream()
//                .map(file -> {
//                    DBFile _db = file;
//                    String linkFile = ServletUriComponentsBuilder.fromHttpUrl("HTTPs://PRONHUB.COM")
////        fromCurrentContextPath()
//                            .path("/downloadFile/")
//                            .path(file.getFileName())
//                            .toUriString();
//                    _db.setFileName(linkFile);
//                    return _db;
//                }).collect(Collectors.toList());
//        String linkFile = ServletUriComponentsBuilder.fromHttpUrl("HTTPs://PRONHUB.COM")
////        fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(dbFile.getId())
//                .toUriString();

        return dbFile;
    }

//    @PostMapping("/uploadMultipleFiles")
//    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(file->uploadFile(file))
//                .collect(Collectors.toList());
//    }

//    @GetMapping("/downloadFile/{fileId}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws MalformedURLException {
////        DBFile dbFile = dbFileService.getFile(fileId);
//        InputStream in = servletContext.getResourceAsStream("/images/no_image.jpg");
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType("image/jpg"))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"100-hinh-anh-de-thuong-nhat_083634390\"")
//                .body(new FileUrlResource(new URL("")));
//    }
}
