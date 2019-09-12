package com.safb.tdd.entity;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "username")
    private String username;

    @NotNull
    @Size(min = 2, max = 100)
    @Column(name = "password")
    private String password;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
