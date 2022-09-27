package demo.user;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserFinder {
    private final UserRepository userRepository ;
    private UserFinder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isExist(User user) {
        boolean isExist = false;
        for (int i=0;userRepository.findAll().size()>i;i++){
            String usernameIDB=userRepository.findAll().get(i).getUsername();
            String passwordIDB=userRepository.findAll().get(i).getPassword();
            if (usernameIDB.equals(user.getUsername()) && passwordIDB.equals(user.getPassword())) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }
    public boolean isExist(Long id){
        int sizeOfDataBase=userRepository.findAll().size();
        for (int i=0;i<sizeOfDataBase;i++){
            if (Objects.equals(userRepository.findAll().get(i).getId(), id))
                return true;
        }
        return false;
    }

}
