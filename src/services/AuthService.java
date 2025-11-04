package services;
import java.util.Map;
import util.HashUtil;
import exceptions.NotFoundException;
import models.Role;
import models.User;
import repository.Implementation.RoleRepo;
import repository.Implementation.UserRepo;

public class AuthService {
        private final UserRepo userRepo;
    private final RoleRepo roleRepo ;

    private static AuthService instance;

    private AuthService(){ 
        userRepo = UserRepo.getInstance();
        roleRepo = RoleRepo.getInstance();
    }

    public static AuthService getInstance(){

        if(instance == null){
            instance = new AuthService();
        }

        return instance;
    }

   
    public User getCheckValidUser(String email , String password){

        String hashedPassword = HashUtil.makeHashedPassword(password);

        for(User user : userRepo.getAll()){

            if(user.getEmail().equals(email) && user.getPassword().equals(hashedPassword)){
                return user;
            }
        }

        return null;
    }

    
}
