package hoang.github.security;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic(); // Có thể thay bằng   http.formLogin();
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
        //return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        Collection<UserDetails> users = new ArrayList<>();
        UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);
        var tom = userBuilder.username("tom@gmail.com").password("123").roles("USER").build();
        var bob = userBuilder.username("bob@gmail.com").password("123").roles("USER").build();
        var alice = userBuilder.username("alice@gmail.com").password("123").roles("USER").build();

        System.out.println(alice.getPassword());

        users.add(tom);
        users.add(bob);
        users.add(alice);
        return new InMemoryUserDetailsManager(users);
    }
}
