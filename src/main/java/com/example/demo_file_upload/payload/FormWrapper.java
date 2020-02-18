package com.example.demo_file_upload.payload;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class FormWrapper {

    private Integer id;

    private MultipartFile file1;
    private MultipartFile file2;
    private MultipartFile file3;

    private String fileType;
}
