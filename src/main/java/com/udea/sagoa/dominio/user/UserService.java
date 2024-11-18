package com.udea.sagoa.dominio.user;

import com.udea.sagoa.dominio.user.dto.UserData;
import com.udea.sagoa.dominio.user.model.User;
import com.udea.sagoa.dominio.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserData> findAll() {
        return userRepository.findAll().stream().map(user -> new UserData(user.getUsername())).toList();
    }

    public UserData findById(Long id) {
        return userRepository.findById(id).map(user -> new UserData(user.getUsername())).orElse(null);
    }
}
