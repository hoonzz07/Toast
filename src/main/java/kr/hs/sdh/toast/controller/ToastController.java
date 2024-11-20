package kr.hs.sdh.toast.controller;

import kr.hs.sdh.toast.model.CustomerDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String home(@AuthenticationPrincipal CustomerDetails user, Model model) {
        model.addAttribute("user" , user);

        return "index";
    }

}
