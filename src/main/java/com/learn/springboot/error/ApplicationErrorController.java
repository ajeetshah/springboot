package com.learn.springboot.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

public class ApplicationErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        return "error";
    }
}
