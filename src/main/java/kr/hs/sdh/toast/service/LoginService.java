package kr.hs.sdh.toast.service;

import kr.hs.sdh.toast.entity.Customer;
import kr.hs.sdh.toast.entity.CustomerRole;
import kr.hs.sdh.toast.repository.LoginRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LoginService {
    private final LoginRepository loginRepository;


    public LoginService(LoginRepository loginRepository) {
    this.loginRepository = loginRepository;
    }

    public Customer getCustomer (String id) {
        return loginRepository.getCustomerRoleByCId(id);
    }

    public void SetCustomer (Customer customer) {
        loginRepository.insertCustomer(customer);
    }

}
