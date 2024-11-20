package kr.hs.sdh.toast.repository;

import kr.hs.sdh.toast.entity.BankAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BankCustomerRepositoryTest {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Test
    void findByIdentity() {
        final List<BankAccount> bankAccounts = this.bankAccountRepository.findAllByIdentity("010105-3055215");

        Assertions.assertEquals(3, bankAccounts.size(), "야스");

    }
}
