package com.mycompany.mysocialapp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class SocialController {

    @GetMapping("/greet")
    public RedirectView greet(){
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:9000/home.html");
        return redirectView;
    }

    @GetMapping("/current-user-principal")
    public Principal currentUser(Principal principal){
        return principal;
    }
    @GetMapping("/current-user-details")
    public Map<String, Object> authUsere(@AuthenticationPrincipal OAuth2User user){
        return user.getAttributes();
    }



}
