package com.pollra.web.repository;

import com.pollra.web.blog.domain.BlogInfoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<BlogInfoDAO, String> {
    @Override
    BlogInfoDAO getOne(String id);
    Optional<BlogInfoDAO> findById(String id);
}
