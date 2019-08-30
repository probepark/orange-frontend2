package com.pollra.web.user.tool;

import com.pollra.web.user.domain.en.Range;
import com.pollra.web.user.domain.en.TargetUser;
import com.pollra.web.user.domain.UserAccount;
import com.pollra.web.user.domain.UserInfo;
import com.pollra.web.user.exception.SelectionNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserDataPretreatmentTool {
    private HttpServletRequest request;

    public UserDataPretreatmentTool(HttpServletRequest request) {
        this.request = request;
    }

    // user account
    private final String USER_ID = "";
    private final String USER_PW = "";
    private final String USER_PW_MATCH = "";

    // user info
    private final String INFO_EMAIL = "";
    private final String INFO_AUTH = "";

    public UserAccount getUserAccount(Range range) {
        UserAccount userAccount = new UserAccount();
        switch (range){
            case ID:
                userAccount.setId(request.getParameter(USER_ID));
                return userAccount;
            case PWS:
                userAccount.setPassword(request.getParameter(USER_PW));
                userAccount.setPasswordMatch(request.getParameter(USER_PW_MATCH));
                return userAccount;
            case ALL:
                userAccount.setId(request.getParameter(USER_ID));
                userAccount.setPassword(request.getParameter(USER_PW));
                userAccount.setPasswordMatch(request.getParameter(USER_PW_MATCH));
                return userAccount;
            default:
                throw new SelectionNotFoundException("선택지가 올바르지 않습니다.");
        }
    }

    public UserInfo getUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(request.getParameter(INFO_EMAIL));
        userInfo.setAuth(request.getParameter(INFO_AUTH));
        return userInfo;
    }

    public boolean isNull(TargetUser targetUser, Object o) throws NullPointerException{
        switch (targetUser){
            case ACCOUNT:
                return isNull_account((UserAccount)o);
            case INFO:
                return isNull_info((UserInfo)o);
            case ACCOUNT_ID:
                return isNull_account_id((UserAccount)o);
            default:
                throw new SelectionNotFoundException("미구현 서비스입니다.");
        }
    }

    private boolean isNull_account(UserAccount userAccount){
        if(userAccount.getId() == "") return true;
        if(userAccount.getPassword() == "") return true;
        if(userAccount.getPasswordMatch() == "") return true;
        return false;
    }

    private boolean isNull_account_id(UserAccount userAccount){
        if(userAccount.getId() == "") return true;
        return false;
    }

    private boolean isNull_info(UserInfo userInfo){
        // 필수항목이 존재하지 않는 데이터
        return false;
    }
}
