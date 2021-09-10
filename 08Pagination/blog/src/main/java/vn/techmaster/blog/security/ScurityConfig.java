package vn.techmaster.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import vn.techmaster.blog.model.Role;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class ScurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/comment").hasAuthority(Authority.CREATE)
                .antMatchers(HttpMethod.POST, "/book/save").hasAuthority(Authority.CREATE)
                .antMatchers(HttpMethod.GET, "/post/{\\d+}").hasAuthority(Authority.READ)
                .antMatchers(HttpMethod.GET, "/post/edit/{\\d+}").hasAuthority(Authority.EDIT)
                .antMatchers(HttpMethod.GET, "/post/delete/{\\d+}").hasAuthority(Authority.DELETE)
                .antMatchers("/**").permitAll();
    }
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        Collection<UserDetails> users = new ArrayList<>();
        User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder()::encode);
        var tom = userBuilder.username("tom@gmail.com").password("123").roles("AUTHOR").build();
        var bob = userBuilder.username("bob@gmail.com").password("123").roles("EDITOR").build();
        var alice = userBuilder.username("alice@gmail.com").password("123").roles("ADMIN").build();

        System.out.println(alice.getPassword());  //Thử lấy ra password của một user

        users.add(tom);
        users.add(bob);
        users.add(alice);
        return new InMemoryUserDetailsManager(users);
    }
}
