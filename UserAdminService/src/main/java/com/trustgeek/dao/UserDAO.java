package com.trustgeek.dao;

import com.trustgeek.util.IdGenerator;

public class UserDAO {
    public int create(User user){
        int id = IdGenerator.generateId();
        // save the db with this id for the user
        return id;
    }
}
