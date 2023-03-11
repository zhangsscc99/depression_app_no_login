package com.nyu.controller;


import com.nyu.dto.AccessTokenDTO;
import com.nyu.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state
    ){

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("0f85b8326afc18e6ff62");
        accessTokenDTO.setClient_secret("f9ec70c095826467d195b5085f65c1e98ca9d869");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_url("http://localhost:8080/callback");
        accessTokenDTO.setState(state);

        githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }
}
