package unis.com.weunis.Service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import unis.com.weunis.Model.UserAuth;
import unis.com.weunis.Repository.UserAuthRepository;

@Service
public class CustomUserAuthDetailService implements UserDetailsService {

    private UserAuthRepository userAuthRepository;

    public CustomUserAuthDetailService(UserAuthRepository userAuthRepository){
        this.userAuthRepository = userAuthRepository;
    }

    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException{
        UserAuth userAuth = userAuthRepository.findByUsernameorEmail(usernameOrEmail, usernameOrEmail)
        .orElseThrow(() ->
            new UsernameNotFoundException("User not found with username or email" + usernameOrEmail));

    Set<GrantedAuthority> authorities = userAuth
        .getRoles()
        .stream()
        .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
            userAuth.getEmail(),
            userAuth.getPassword(),
            authorities
        );
    }

}
