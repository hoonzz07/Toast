package kr.hs.sdh.toast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToastController {

    @GetMapping(value = "/Login")
    public String LoginPage() {
        return "Login";
    }

    @GetMapping(value = "/SignUp")
    public String SignUpPage() {
        return "SignUp";
    }

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

}
