package com.example.ankiit.firebaseauth;

public class userprofile {

    String userId;
    String userName;
    String userContact;
    String userEmail;

    public userprofile(){

    }

    public userprofile(String userId, String userName, String userContact, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userContact = userContact;
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserContact() {
        return userContact;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
