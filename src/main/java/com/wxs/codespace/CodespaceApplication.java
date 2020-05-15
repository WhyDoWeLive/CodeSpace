package com.wxs.codespace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ServletComponentScan
public class CodespaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodespaceApplication.class, args);
    }

}
