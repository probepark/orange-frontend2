package com.pollra.web.repository;

import com.pollra.web.user.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    UserInfo getById(String id);

    UserInfo getByEmail(String email);
}
