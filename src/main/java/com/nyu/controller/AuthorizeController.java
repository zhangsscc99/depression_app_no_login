package com.nyu.controller;


import com.nyu.mapper.UserMapper;
import com.nyu.model.User;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

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


    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) throws IOException {

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_url(redirectUrl);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = GithubProvider.getUser(accessToken);
        System.out.println(githubUser.getName()+" 这是用户名");
        System.out.println(githubUser.getId()+" 这是id");

        if (githubUser != null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            response.addCookie(new Cookie("token", token));
            request.getSession().setAttribute("user",githubUser);
            return "redirect:/";
        }else{
            return "redirect:/";
        }

    }
}
