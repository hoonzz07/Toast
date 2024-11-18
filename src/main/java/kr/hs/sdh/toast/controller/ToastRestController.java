package kr.hs.sdh.toast.controller;


import kr.hs.sdh.toast.entity.Customer;
import kr.hs.sdh.toast.entity.CustomerRole;
import kr.hs.sdh.toast.repository.LoginRepository;
import kr.hs.sdh.toast.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ToastRestController {
    private final LoginRepository loginRepository;
    private LoginService loginService;

    public ToastRestController(LoginService loginService, LoginRepository loginRepository) {
        this.loginService = loginService;
        this.loginRepository = loginRepository;
    }


    @PostMapping("/loginForm")
    private Customer login(@RequestBody Customer customer) {
        final String userId = customer.getId();
        Customer foundCustomer = this.loginService.getCustomer(userId);

        if (foundCustomer == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "사용자를 찾을 수 없습니다.");
        }

        // 비밀번호 확인 로직 추가 (예시)
        if (!foundCustomer.getC_password().equals(customer.getC_password())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        return foundCustomer;
    }

    @PostMapping("/SignUpForm")
    private void SignUp(@RequestBody Customer customer) {
        this.loginService.SetCustomer(customer);

    }


}
