package com.github.dinglevin.mybatis.example.dataobject;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDO implements Serializable {
    private static final long serialVersionUID = -362510271426474349L;

    private int id;
    private String name;
    private String email;

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
    }
}
