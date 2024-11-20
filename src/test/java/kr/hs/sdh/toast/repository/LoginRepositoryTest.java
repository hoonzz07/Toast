package kr.hs.sdh.toast.repository;

import kr.hs.sdh.toast.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginRepositoryTest {

    @Autowired
    private LoginRepository loginRepository;

    @Test
    void findById() {
        final Customer customer = this.loginRepository.findById("hoonzz");
        Assertions.assertNotNull(customer , "사용자 정보기 일치하지 않습니다.");
        Assertions.assertEquals("1234" , customer.getPassword() , "사용자 정보가 올바르지 않습니다.");

    }
}