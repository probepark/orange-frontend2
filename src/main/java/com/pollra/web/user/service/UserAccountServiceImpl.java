package com.pollra.web.user.service;

import com.pollra.web.repository.UserAccountRepository;
import com.pollra.web.repository.UserInfoRepository;
import com.pollra.web.user.domain.en.AccessClassification;
import com.pollra.web.user.domain.en.Range;
import com.pollra.web.user.domain.en.TargetUser;
import com.pollra.web.user.domain.UserAccount;
import com.pollra.web.user.exception.*;
import com.pollra.web.user.tool.UserDataPretreatmentTool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserService{

    private UserAccountRepository accountRepository;
    private UserInfoRepository infoRepository;
    private UserDataPretreatmentTool tool;

    public UserAccountServiceImpl(UserAccountRepository accountRepository, UserInfoRepository infoRepository, UserDataPretreatmentTool tool) {
        this.accountRepository = accountRepository;
        this.infoRepository = infoRepository;
        this.tool = tool;
    }

    /**
     * create
     */
    @Override
    public void createOne()
            throws UserServiceException, NullPointerException {
        // 회원가입 폼을 통해 전달된 정보를 UserAccount 객체에 담는다
        UserAccount userAccount = tool.getUserAccount(Range.ALL);

        // 담아진 객체 정보를 확인한다
        if(tool.isNull(TargetUser.ACCOUNT, userAccount)){
            throw new IncorrectUserDataException("입력된 객체의 정보가 올바르지 않습니다.");
        }

        // DB에 중복되는 객체가 있는지 확인한다
        if(!idDuplicateCheck()){
            throw new UserDuplicateException("해당 유저가 이미 존재합니다.");
        }

        // 패스워드가 일치하는지 확인한다.
        passwordMatchCheck();

        // DB에 입력한다
        UserAccount dbInsertionResult = accountRepository.save(userAccount);
        if(tool.isNull(TargetUser.ACCOUNT, dbInsertionResult)){
            throw new UserDataInsertionException("데이터 입력 과정에서 문제가 발생했습니다.");
        }
        // userInfo 작성 작업과 연결 되어야함
    }

    /**
     * update
     */
    @Override
    public void updateOne() {

    }

    /**
     * read
     */
    @Override
    public Object readOne(AccessClassification accessClassification) {

        return null;
    }

    @Override
    public List<Object> readList(AccessClassification accessClassification) {
        return null;
    }

    /**
     * delete
     */
    @Override
    public void deleteOne(AccessClassification accessClassification) {

    }

    /**
     * other
     */

    /*
     * 패스워드가 일치하는지 확인하고
     * 사용해도 된다면 true 를 리턴
     */
    @Override
    public boolean passwordMatchCheck() {
        UserAccount userAccount = tool.getUserAccount(Range.PWS);
        if(userAccount.getPassword() == userAccount.getPasswordMatch()){
            return true;
        }
        return false;
    }

    /*
     * 아이디를 사용해도 되는지 체크
     * 사용해도 된다면 true 를 리턴
     */
    @Override
    public boolean idDuplicateCheck() throws UserServiceException{
        UserAccount userAccount = tool.getUserAccount(Range.ID);

        // null check
        if(!tool.isNull(TargetUser.ACCOUNT_ID, readOne(AccessClassification.ID))){
            return false;
        }
        // 해당 아이디를 사용해도 됨.
        return true;
    }
}
