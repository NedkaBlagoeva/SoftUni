package bg.softuni.coffeeshop.service;

import bg.softuni.coffeeshop.model.entity.User;
import bg.softuni.coffeeshop.model.service.UserServiceModel;
import bg.softuni.coffeeshop.repository.UserRepository;
import bg.softuni.coffeeshop.temp.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        userRepository.save(user);
    }

    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    public void loginUser(long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }
}
