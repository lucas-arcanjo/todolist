package br.com.lucasarcanjo.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository repository;
    
    @PostMapping("/")
    public UserModel create(@RequestBody UserModel userModel) {

        var user = this.repository.findByName(userModel.getName());

        if(user != null) {
            System.out.println("Usuário já existe");
            return null;
        }

        
        var response = this.repository.save(userModel);
        return response;
    }
}
