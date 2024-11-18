package kr.hs.sdh.toast.config;


import jakarta.servlet.http.HttpSession;
import kr.hs.sdh.toast.entity.Customer;
import kr.hs.sdh.toast.repository.LoginRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
class SecurityConfiguration {

    private final LoginRepository loginRepository;

    SecurityConfiguration(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
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
        });
        httpSecurity.userDetailsService(userid ->{
            Customer customer = this.loginRepository.getCustomerRoleByCId(userid);

            if (customer == null) {
                throw new UsernameNotFoundException("아이디 또는 비밀번호가 올바르지 않습니다");
            }
            return User.withUsername(userid).password(customer.getPassword())
                    .build();
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
