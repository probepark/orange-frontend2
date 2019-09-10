package com.pollra.web.user.controller;

import com.pollra.config.security.SecurityConstants;
import com.pollra.web.user.domain.UserAccount;
import com.pollra.web.user.domain.en.AccessClassification;
import com.pollra.web.user.exception.SelectionNotFoundException;
import com.pollra.web.user.exception.UserIdNotFoundException;
import com.pollra.web.user.exception.UserServiceException;
import com.pollra.web.user.service.UserService;
import com.pollra.web.user.tool.data.UserDataPretreatmentTool;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin
@Slf4j
@RequestMapping("/api")
public class UserRestController {
    private UserDataPretreatmentTool tool;
    private UserService userService;
    private HttpServletRequest request;

    public UserRestController(UserDataPretreatmentTool tool, UserService userService, HttpServletRequest request) {
        this.tool = tool;
        this.userService = userService;
        this.request = request;
    }

    /**
     * 아이디 조회
     * @return
     */
    @PostMapping("public/users/id")
    public ResponseEntity<String> getUserData(){
        UserAccount userAccount = null;
        try {
            userAccount = (UserAccount) userService.readOne(AccessClassification.ID);
        }catch (UserIdNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (SelectionNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.LENGTH_REQUIRED);
        }catch (UserServiceException e){
            return new ResponseEntity<>("server error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(userAccount.getId(),HttpStatus.OK);
    }

    /**
     * 로그인
     * @return
     */
    /*@PostMapping("authenticate")
    public ResponseEntity<?> loginAction(HttpServletResponse response){
        // 해당 토큰의 데이터가 권한을 가지고있는지 판단.
        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal()==null){
            return new ResponseEntity<Error>(new Error("토큰 발급 실패"),HttpStatus.NOT_FOUND);
        }

        // 권한을 가지고있다면 로그인 불가.
        // 권한을 가지고있지 않다면 로그인 가능.
        Map<String, String> token = new HashMap<>();
        token.put(SecurityConstants.TOKEN_HEADER,response.getHeader(SecurityConstants.TOKEN_HEADER));
        return new ResponseEntity<Map>(token,HttpStatus.OK);
    }*/

    /**
     * 회원 정보 수정
     * @return
     */
    @PutMapping("protected/users")
    public ResponseEntity<?> updateUserAccount(){

        return null;
    }

    /**
     * 회원 정보 삭제
     * @return
     */
    @DeleteMapping("private/users")
    public ResponseEntity<?> deleteUserAccount(){
        return null;
    }
}
