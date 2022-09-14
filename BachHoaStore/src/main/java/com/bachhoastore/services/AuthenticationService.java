package com.bachhoastore.services;

import ch.qos.logback.core.subst.Token;
import com.bachhoastore.controllers.LoginDto;

public interface AuthenticationService {
    public String login(LoginDto loginDto);
    public boolean checkExists(LoginDto loginDto);
}
