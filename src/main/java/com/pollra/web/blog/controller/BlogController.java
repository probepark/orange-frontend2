package com.pollra.web.blog.controller;

import com.pollra.web.blog.domain.BlogInfo;
import com.pollra.web.blog.service.BlogInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/blog")
@Slf4j
@CrossOrigin
public class BlogController {
    private BlogInfoService blogService;

    public BlogController(BlogInfoService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/info")
    public ResponseEntity<?> getBlogInfo(HttpServletRequest request){
        BlogInfo blogInfo = new BlogInfo();
//        InfoPrint.headersPrint(request);
        blogInfo = blogService.getBlogInfoOfId("pollra");
        return new ResponseEntity<>(blogInfo, HttpStatus.OK);
    }
}
