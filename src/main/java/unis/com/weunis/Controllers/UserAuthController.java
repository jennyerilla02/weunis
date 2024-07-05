package unis.com.weunis.Controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unis.com.weunis.DTO.RegistrationRequest;
import unis.com.weunis.Model.Role;
import unis.com.weunis.Model.UserAuth;
import unis.com.weunis.Repository.RoleRepository;
import unis.com.weunis.Repository.UserAuthRepository;

@RestController
@RequestMapping("/api/v1/auth")
public class UserAuthController {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest){

        //check if username exists in DB
        if(userAuthRepository.existsByUsername(registrationRequest.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        if(userAuthRepository.existsByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<>("An account is already registered in this email!", HttpStatus.BAD_REQUEST);
        }

        UserAuth userAuth =  new UserAuth(
            registrationRequest.getUsername(),
            registrationRequest.getEmail(),
            passwordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = roleRepository.findByName("ROLE_ADMIN").get();
        userAuth.setRoles(Collections.singleton(role));

        userAuthRepository.save(userAuth);

        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);

    }
}
