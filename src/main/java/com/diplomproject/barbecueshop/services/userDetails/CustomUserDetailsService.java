package com.diplomproject.barbecueshop.services.userDetails;

import com.diplomproject.barbecueshop.model.User;
import com.diplomproject.barbecueshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Value("${spring.security.user.name}")   // import использовать не lombok, а:  import org.springframework.beans.factory.annotation.Value;
    private String adminUserName;
    @Value("${spring.security.user.password}")
    private String adminPassword;
    @Value("ROLE_ADMIN")
    private String adminRole;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals(adminUserName)) {
            return new CustomUserDetails(null, username, adminPassword, List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
        } else {
            User user = userRepository.findUserByLoginAndDeletedFalse(username);
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole().getId() == 1L ? "ROLE_USER" : "ROLE_MANAGER"));
            return new CustomUserDetails(user.getId().intValue(), username, user.getPassword(), authorities);
        }
    }
}
