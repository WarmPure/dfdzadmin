package com.app.entity.model;

import com.app.entity.User;

public class BaseResult {

   private User user;
//   private Message message;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public Message getMessage() {
//        return message;
//    }

//    public void setMessage(Message message) {
//        this.message = message;
//    }
}
