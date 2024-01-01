package com.tuling.jvm;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
      private int id;
    private String name;
    public void sout(){
        System.out.println("im user");
    }
}
