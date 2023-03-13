package com.pvt.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "User.getUserByEmail", query = "SELECT u FROM User u where u.userEmail = :userEmail"),
        @NamedQuery(name = "User.getUserByName", query = "SELECT u FROM User u where u.userName = :userName"),
        @NamedQuery(name = "User.getAllUsers", query = "SELECT u FROM User u")
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "userName", unique = true, nullable = false)
    private String userName;

    @Column(name = "userEmail", unique = true, nullable = false)
    private String userEmail;

    @Column(name = "userPassword",nullable = false)
    private String userPassword;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "userRole", nullable = false)
    private Role userRole;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.ALL})
    private Set<Post> posts = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserId() == user.getUserId() && getUserEmail() == user.getUserEmail() && getUserName() == user.getUserName() && getUserPassword() == user.getUserPassword() && getUserRole() == user.getUserRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getUserEmail(), getUserPassword(), getUserRole(), getUserId());

    }

    @Override
    public String toString() {
        return "Id: [" + userId + "], " + "Name: [" + userName + "], " + "Password: [" + userPassword + "], " + "Email: [" + userEmail + "], " + "Role [" + userRole + "]";
    }
}
