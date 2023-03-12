package com.nyu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nyu.dto.AccessTokenDTO;
import com.nyu.dto.GithubUser;
import com.nyu.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

import static com.nyu.provider.GithubProvider.getUser;


@Controller
public class AuthorizeController {
    private static final Logger logger = LoggerFactory.getLogger(AuthorizeController.class);


    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret")
    private String clientSecret;
    @Value("${github.redirect.url")
    private String redirectUrl;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state
    ) throws Exception {

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_url(redirectUrl);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = GithubProvider.getUser(accessToken);
        System.out.println(user.getName()+" 这是用户名");
        System.out.println(user.getId()+" 这是id");







        return "index";
    }
}
