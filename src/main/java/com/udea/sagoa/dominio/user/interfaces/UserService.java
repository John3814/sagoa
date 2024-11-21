package com.udea.sagoa.dominio.user.interfaces;

import com.udea.sagoa.dominio.user.dto.UserData;
import com.udea.sagoa.dominio.user.dto.UserResgistrationData;
import com.udea.sagoa.dominio.user.model.Role;

import java.util.List;

public interface UserService {
    public List<UserData> findAll();
    public UserData findById(Long id);
    public UserData addUser(UserResgistrationData user);
    public String deleteUserByUsername(String username);
    public String updatePassword(String userName, String password);
    public Role getRoleByUsername(String userName);
}
