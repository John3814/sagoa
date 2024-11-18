package com.udea.sagoa.dominio.user.model;

import com.udea.sagoa.dominio.contract.model.Contract;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "user_name")
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "role")
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Contract> contracts;


    public User(String username, String password, Profile profile, Role role, Set<Contract> contracts) {
        this.username = username;
        this.password = password;
        this.profile = profile;
        this.role = role;
        this.contracts = contracts;
    }


    public User() {

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }
}
