package com.pollra.web.user.tool.data;

import com.pollra.tool.http.InfoPrint;
import com.pollra.web.user.domain.en.Range;
import com.pollra.web.user.domain.en.TargetUser;
import com.pollra.web.user.domain.UserAccount;
import com.pollra.web.user.exception.SelectionNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;

@Service
@Slf4j
public class UserDataPretreatmentTool {
    private HttpServletRequest request;

    public UserDataPretreatmentTool(HttpServletRequest request) {
        this.request = request;
    }

    // user account
    private final String USER_ID = "username";
    private final String USER_PW = "password";
    private final String USER_PW_MATCH = "password-match";
    private final String INFO_EMAIL = "";

    public UserAccount getUserAccount(Range range) {
//        InfoPrint.headersPrint(request);
        UserAccount userAccount = new UserAccount();
        switch (range){
            case ID:
                userAccount.setId(get(USER_ID));
                log.info("insert id: "+userAccount.getId());
                return userAccount;
            case PWS:
                userAccount.setPassword(get(USER_PW));
                userAccount.setPasswordMatch(get(USER_PW_MATCH));
                log.warn("insert pw: {}, pwMatch: {}"
                        ,userAccount.getPassword()
                        ,userAccount.getPasswordMatch()
                );
                return userAccount;
            case ALL:
                userAccount.setId(get(USER_ID));
                userAccount.setPassword(get(USER_PW));
                userAccount.setPasswordMatch(get(USER_PW_MATCH));
                log.warn("insert id: {}, pw: {}, pwMatch: {}"
                        ,userAccount.getId()
                        ,userAccount.getPassword()
                        ,userAccount.getPasswordMatch()
                );
                return userAccount;
            default:
                throw new SelectionNotFoundException("선택지가 올바르지 않습니다.");
        }
    }

    public boolean isNull(TargetUser targetUser, Object o){
        try {
            switch (targetUser) {
                case ACCOUNT:
                    return isNull_account((UserAccount) o);
                case ACCOUNT_ID:
                    return isNull_account_id((UserAccount) o);
                default:
                    throw new SelectionNotFoundException("미구현 서비스입니다.");
            }
        }catch (NullPointerException e){
            return true;
        }
    }

    private boolean isNull_account(UserAccount userAccount){
        if(userAccount.getId().isEmpty()) return true;
        if(userAccount.getPassword().isEmpty()) return true;
        if(userAccount.getPasswordMatch().isEmpty()) return true;
        return false;
    }

    private boolean isNull_account_id(UserAccount userAccount){
        if(userAccount.getId().isEmpty()) return true;
        return false;
    }

    private String get(String name){
        return request.getParameter(name);
    }
}
