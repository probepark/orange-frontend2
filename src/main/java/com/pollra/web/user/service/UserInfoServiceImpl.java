package com.pollra.web.user.service;

import com.pollra.web.repository.UserInfoRepository;
import com.pollra.web.user.domain.UserInfo;
import com.pollra.web.user.domain.en.AccessClassification;
import com.pollra.web.user.domain.en.UserAuth;
import com.pollra.web.user.exception.UserIdNotFoundException;
import com.pollra.web.user.tool.UserDataPretreatmentTool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserService {
    private UserDataPretreatmentTool tool;
    private UserInfoRepository infoRepository;

    public UserInfoServiceImpl(UserDataPretreatmentTool tool, UserInfoRepository infoRepository) {
        this.tool = tool;
        this.infoRepository = infoRepository;
    }

    @Override
    public void createOne() {
        // user account 이미 만들어져있음.

        // 권한, 이메일 설정
        UserInfo insertUserInfo = tool.getUserInfo(); // 사용자로부터 받아온 정보

        // id 가 입력되었는지 확인
        if(insertUserInfo.getId() == ""){
            throw new UserIdNotFoundException("계정 정보를 확인할 수 없습니다.");
        }
        // 아이디가 존재하는지 확인 - userAccountService 에서 이미 처리됨.

        // 사용자가 이메일을 입력했는지 확인
        if(insertUserInfo.getEmail()!=""){
            // 이메일이 없음
            insertUserInfo.setAuth(UserAuth.USER.name());
        }else{
            insertUserInfo.setAuth(UserAuth.GUEST.name());
        }
        infoRepository.save(insertUserInfo);
    }

    // userInfo
    @Override
    public void updateOne() {
        // JPA 의 save 를 사용하면 되지만 아직 사용법이 미숙.
        // 그렇기에 복잡한 과정을 거침 ;ㅁ ;

        // 입력된 정보를 저장
        UserInfo inputUserInfo = tool.getUserInfo();

        // 사용자의 정보가 존재하는지 확인

    }

    @Override
    public Object readOne(AccessClassification ac) {
        if(ac.equals(AccessClassification.ID)){
            // 존재하는 엑세스 분류
            // 데이터 존재하는지 확인 후 존재하면 리턴
        }else{
            // 존재하지않는 엑세스 분류
        }

        return null;
    }

    @Override
    public List<Object> readList(AccessClassification ac) {
        return null;
    }

    @Override
    public void deleteOne(AccessClassification ac) {

    }

    @Override
    public boolean passwordMatchCheck() {
        return false;
    }

    @Override
    public boolean idDuplicateCheck() {
        return false;
    }
}
