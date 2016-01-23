package com.alva.redis.entry;

import java.io.Serializable;

/**
 * Created by alva on 16/1/5.
 */
public class User implements Serializable {


    private String id;
    private String name;
    private String pwd;
    public User(){

    }

    public User(String id,String name,String pwd){
        this.id =  id;
        this.name = name;
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
