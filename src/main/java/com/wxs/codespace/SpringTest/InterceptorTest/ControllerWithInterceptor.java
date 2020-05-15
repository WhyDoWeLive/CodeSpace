package com.wxs.codespace.SpringTest.InterceptorTest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerWithInterceptor {
    @RequestMapping("home")
    public String home(){
        return "welcome!";
    }

    @RequestMapping("oldHome")
    public String oldHome(){
        return "welcome old home";
    }
}
