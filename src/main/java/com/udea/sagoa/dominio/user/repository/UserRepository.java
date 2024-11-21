package com.udea.sagoa.dominio.user.repository;

import com.udea.sagoa.dominio.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByUsername(String userName);

    @Modifying
    @Query("DELETE FROM User u WHERE u.username = :username")
    void deleteByUsername(@Param("username") String username);

    User getUserByUsername(String username);
}
