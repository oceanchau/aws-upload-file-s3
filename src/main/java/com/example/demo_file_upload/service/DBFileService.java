package com.example.demo_file_upload.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.example.demo_file_upload.exception.FileStorageException;
import com.example.demo_file_upload.exception.MyFileNotFoundException;
import com.example.demo_file_upload.model.DBFile;
import com.example.demo_file_upload.payload.FormWrapper;
import com.example.demo_file_upload.repository.DBFileRepository;
import org.hibernate.boot.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.security.pkcs11.Secmod;

import java.io.IOException;

@Service
public class DBFileService {

    @Autowired
    private AmazonS3 s3client;

    @Autowired
    private DBFileRepository dbFileRepository;

    public DBFile storeFile(FormWrapper formWrapper)  {
        DBFile dbFile = dbFileRepository.findById(formWrapper.getId()).orElse(null);
        if (formWrapper.getFile1() != null) {
            dbFile.setFile1(storageS3(formWrapper.getFile1(), formWrapper.getId(), formWrapper.getFileType()));
        }
        if (formWrapper.getFile2() != null) {
            dbFile.setFile2(storageS3(formWrapper.getFile2(), formWrapper.getId(), formWrapper.getFileType()));

        }
        if (formWrapper.getFile3() != null) {
            dbFile.setFile3(storageS3(formWrapper.getFile3(), formWrapper.getId(), formWrapper.getFileType()));

        }
        try {
            return dbFileRepository.save(dbFile);
        } catch (Exception e) {
            throw e;
        }
    }

    private String storageS3(MultipartFile file, Integer id, String fileType) {

        String dirUpload = "upload/" + id +"/"+ fileType
                + StringUtils.cleanPath(file.getOriginalFilename());
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        try {
            s3client.putObject("ge-skill-matrix-bucket", dirUpload, file.getInputStream(), metadata);
        } catch (IOException e) {
            throw new FileStorageException("storages3");
        }
        return dirUpload;
    }

//    public DBFile getFile(String fileId) {
//        return dbFileRepository.findById(fileId)
//                .orElseThrow(() -> new FileStorageException("File not found with id " + fileId));
//    }
}
