package com.udea.sagoa.dominio.user;

import com.udea.sagoa.dominio.user.dto.UserData;
import com.udea.sagoa.dominio.user.dto.UserResgistrationData;
import com.udea.sagoa.dominio.user.interfaces.UserService;
import com.udea.sagoa.dominio.user.model.Role;
import com.udea.sagoa.dominio.user.model.User;
import com.udea.sagoa.dominio.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserData addUser(UserResgistrationData user) {
        return new UserData(this.userRepository.save(new User(user.userName(), passwordEncoder.encode(user.password()), user.role())).getUsername());
    }

    @Override
    @Transactional
    public String deleteUserByUsername(String username) {
        this.userRepository.deleteByUsername(username);
        return "User with username " + username + " was deleted";
    }

    @Override
    public String updatePassword(String userName, String password) {
        User user = this.userRepository.getUserByUsername(userName);
        user.setPassword(passwordEncoder.encode(password));
        return "Password for user with username " + this.userRepository.save(user).getUsername() + " has been updated";
    }

    @Override
    public Role getRoleByUsername(String userName) {
        return this.userRepository.getUserByUsername(userName).getRole();
    }

    @Override
    public List<UserData> findAll() {
        return userRepository.findAll().stream().map(user -> new UserData(user.getUsername())).toList();
    }

    @Override
    public UserData findById(Long id) {
        return userRepository.findById(id).map(user -> new UserData(user.getUsername())).orElse(null);
    }
}
