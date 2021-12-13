package com.vocera.rock_paper_scissor.service;

import com.vocera.rock_paper_scissor.models.AuthenticationToken;
import com.vocera.rock_paper_scissor.repository.AuthenticationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationTokenService {

    @Autowired
    private AuthenticationTokenRepository authenticationTokenRepository;

    public String createToken() {

        AuthenticationToken authenticationToken = new AuthenticationToken();

      //  this.authenticationTokenRepository.save(authenticationToken);

        return authenticationToken.getToken();
    }
}
