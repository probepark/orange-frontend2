package com.pollra.web.user.service;

import com.pollra.web.user.domain.TargetUser;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface UserService {
    // create
    void createOne(HttpServletRequest request);

    // update
    void updateOne(HttpServletRequest request);

    // read
    Object readOne(TargetUser targetUser, HttpServletRequest request);
    List<Object> readList(TargetUser targetUser, HttpServletRequest request);

    // delete
    void deleteOne(TargetUser targetUser, HttpServletRequest request);

}
