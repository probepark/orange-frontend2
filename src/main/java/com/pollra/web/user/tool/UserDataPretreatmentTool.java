package com.pollra.web.user.tool;

import com.pollra.web.user.domain.UserAccount;

import javax.servlet.http.HttpServletRequest;

public class UserDataPretreatmentTool {
    // user account
    private final String USER_ID = "";
    private final String USER_PW = "";
    private final String USER_PW_MATCH = "";

    private final String USER_EMAIL = "";

    public UserAccount getUserAccount(HttpServletRequest request) {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(request.getParameter(USER_ID));
        userAccount.setPassword(request.getParameter(USER_PW));
        userAccount.setPasswordMatch(request.getParameter(USER_PW_MATCH));
        return userAccount;
    }
}
