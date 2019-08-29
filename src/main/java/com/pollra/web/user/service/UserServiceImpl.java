package com.pollra.web.user.service;

import com.pollra.web.repository.UserAccountRepository;
import com.pollra.web.repository.UserInfoRepository;
import com.pollra.web.user.domain.TargetUser;
import com.pollra.web.user.domain.UserAccount;
import com.pollra.web.user.tool.UserDataPretreatmentTool;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserAccountRepository accountRepository;
    private UserInfoRepository infoRepository;
    private UserDataPretreatmentTool tool;

    public UserServiceImpl(UserAccountRepository accountRepository, UserInfoRepository infoRepository) {
        this.accountRepository = accountRepository;
        this.infoRepository = infoRepository;
        this.tool = new UserDataPretreatmentTool();
    }

    /**
     * create
     */
    @Override
    public void createOne(HttpServletRequest request) {
        // 회원가입 폼을 통해 전달된 정보를 UserAccount 객체에 담는다
        UserAccount userAccount = tool.getUserAccount(request);

        // 담아진 객체 정보를 확인한다


        // 중복되는 객체가 있는지 확인한다

        // DB에 입력한다

        // UserAccount 에 대한 UserInfo 를 생성한다

        // 생성한 데이터를 DB에 저장

    }

    /**
     * update
     */
    @Override
    public void updateOne(HttpServletRequest request) {

    }

    /**
     * read
     */
    @Override
    public Object readOne(TargetUser targetUser, HttpServletRequest request) {
        return null;
    }

    @Override
    public List<Object> readList(TargetUser targetUser, HttpServletRequest request) {
        return null;
    }

    /**
     * delete
     */
    @Override
    public void deleteOne(TargetUser targetUser, HttpServletRequest request) {

    }

    /**
     * other
     */
}
