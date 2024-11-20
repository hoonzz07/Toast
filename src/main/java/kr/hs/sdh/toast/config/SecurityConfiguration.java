package kr.hs.sdh.toast.config;


import jakarta.servlet.http.HttpSession;
import kr.hs.sdh.toast.entity.BankAccount;
import kr.hs.sdh.toast.entity.Customer;
import kr.hs.sdh.toast.model.CustomerDetails;
import kr.hs.sdh.toast.repository.BankAccountRepository;
import kr.hs.sdh.toast.repository.BankRepository;
import kr.hs.sdh.toast.repository.LoginRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
class SecurityConfiguration {

    private final LoginRepository loginRepository;
    private final BankAccountRepository bankAccountRepository;

    SecurityConfiguration(
            LoginRepository loginRepository,
            BankAccountRepository bankAccountRepository
    ) {
        this.loginRepository = loginRepository;
        this.bankAccountRepository = bankAccountRepository;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, BankRepository bankRepository) throws Exception {
        httpSecurity.authorizeHttpRequests(registry -> {
            registry.requestMatchers("/Login").anonymous();
            registry.requestMatchers("/**.css").permitAll();
            registry.anyRequest().authenticated();
        });
        httpSecurity.formLogin(config -> {
            config.loginPage("/Login");
            config.loginProcessingUrl("/login-process");
            config.usernameParameter("username");
            config.passwordParameter("password");
            config.defaultSuccessUrl("/");
            config.failureUrl("/Login");
        })
        .userDetailsService(userid ->{
            final Customer customer = this.loginRepository.findById(userid);

            if (customer == null) {
                throw new UsernameNotFoundException("아이디 또는 비밀번호가 올바르지 않습니다");
            }
            final String identity = customer.getPeople().getIdentity();
            final List<BankAccount> bankAccount = this.bankAccountRepository.findAllByIdentity(identity);

            return new CustomerDetails(customer , bankAccount);
        });

        return httpSecurity.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString() ;
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.contains(rawPassword);
            }
        };
    }

}
