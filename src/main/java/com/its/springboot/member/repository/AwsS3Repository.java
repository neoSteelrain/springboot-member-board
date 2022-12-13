package com.its.springboot.member.repository;

import org.springframework.stereotype.Repository;
import java.io.File;

@Repository
public class AwsS3Repository implements IFileRepository {

    @Override
    public void save(File file) {

    }
}
