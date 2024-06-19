package unis.com.weunis.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import unis.com.weunis.Model.UserModel;

@RestController
public class UserController {

    @GetMapping("/user")
    public UserModel getUser(){
        return new UserModel(1, " Jenny","jennyerilla16@gmail.com","erillajenny02");
    }
}
