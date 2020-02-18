package com.example.demo_file_upload.repository;

import com.example.demo_file_upload.model.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBFileRepository extends JpaRepository<DBFile, Integer> {
}
