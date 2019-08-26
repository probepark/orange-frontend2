package com.pollra.web.blog.service;

import com.pollra.web.blog.domain.BlogInfoDAO;
import com.pollra.web.blog.exception.NoSuchBlogInfoException;
import com.pollra.web.repository.BlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BlogInfoService {
    private BlogRepository blogRepository;

    public BlogInfoService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public BlogInfoDAO getBlogInfoOfId(String target){
        log.info("BlogInfoService - getBlogInfoOfId : start");
        // 아이디를 받고 그걸로 블로그의 정보를 가져옴.
        Optional<BlogInfoDAO> blogInfo = Optional.of(new BlogInfoDAO());
        blogInfo = blogRepository.findById(target);
        BlogInfoDAO result = new BlogInfoDAO();
        try {
            result = blogInfo.get();
        }catch (NoSuchBlogInfoException e){
            log.info("BlogInfo 데이터가 존재하지 않습니다.");
            log.info(e.getMessage());
        }

        return result;
    }

}
