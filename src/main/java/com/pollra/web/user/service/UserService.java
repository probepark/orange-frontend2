package com.pollra.web.user.service;

import com.pollra.web.user.domain.en.TargetUser;
import com.pollra.web.user.domain.en.Type;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface UserService {
    // create
    void createOne();

    // update
    void updateOne();

    // read
    Object readOne(TargetUser targetUser, Type type);
    List<Object> readList(TargetUser targetUser);

    // delete
    void deleteOne(TargetUser targetUser);

    // other
    boolean passwordMatchCheck();
    boolean idDuplicateCheck();

}
