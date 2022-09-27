
package demo.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Service
@RestController
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserFinder userFinder;


@CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/users")
    public List<User> GetUser(){
    return userRepository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/users_login")
    public String addUser(@RequestBody User user) {
        if (userFinder.isExist(user))  return "Taki uzytkownik juz istnieje";
        else if (!userFinder.isExist(user)){
             userRepository.save(user);
            return "Dodano urzytkownika" + user;
        }
        return null;
    }

   @DeleteMapping("/user/{id}")
    public String DeleteUser(@PathVariable Long id){
        if (userFinder.isExist(id)) {
            userRepository.deleteById(id);
            return "Uzytkownik i id " +id+" zostal usuniety";
        }
        else if (!userFinder.isExist(id))
            return "Nie ma uzytkownika z id="+id;
       return null;
   }
   @PatchMapping("/user_patch/{id}")
   public void PatchUser(@RequestBody @NotNull User user, @PathVariable Long id){
       UserCheeckerToPatch userCheecker=new UserCheeckerToPatch(userRepository, id, user);
       userCheecker.patch();
   }
}

