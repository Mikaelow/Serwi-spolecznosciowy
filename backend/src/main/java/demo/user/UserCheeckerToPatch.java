package demo.user;


public class UserCheeckerToPatch {

    private final UserRepository userRepository ;
    Long id;
    User user;

    String oldName;
    String oldPassword;
    public UserCheeckerToPatch(UserRepository userRepository, Long id, User user) {
        this.userRepository = userRepository;
        this.id = id;
        this.user = user;
    }
    public String patch(){
        if (sameUsername() && samePassword()) return "Name and Password is the same";
        else{
            userRepository.deleteById(oldUser().getId());
            userRepository.save(user);
            return "Changed to "+user;
        }
    }
    private User oldUser(){
        return userRepository.getReferenceById(id);
    }
    private boolean sameUsername(){
        String oldName= oldUser().getUsername();
    return oldName.equals(user.getUsername());
    }
    private boolean samePassword(){
        String oldPassword=oldUser().getPassword();
        return oldPassword.equals(user.getPassword());
    }
}
