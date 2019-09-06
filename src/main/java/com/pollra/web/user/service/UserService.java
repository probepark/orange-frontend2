package com.pollra.web.user.service;

import com.pollra.web.user.domain.en.AccessClassification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    // create
    void createOne();

    // update
    void updateOne();

    // read
    Object readOne(AccessClassification ac);
    List<Object> readList(AccessClassification ac);

    // delete
    void deleteOne(AccessClassification ac);

    // other
    boolean passwordMatchCheck();
    boolean idDuplicateCheck();

}
