package com.github.dinglevin.mybatis.example.param;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserQueryParam implements Serializable {
    private static final long serialVersionUID = 4321875840353454273L;

    private List<Integer> idList;
    private List<String> nameList;
    private List<String> emailList;

    @Override
    public String toString() {
        return "UserQueryParam [idList=" + idList + ", nameList=" + nameList + ", emailList=" + emailList + "]";
    }
}
