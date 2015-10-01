
package com.mycompany.tutorial;

import java.util.LinkedHashSet;
import java.util.Set;


public class UserProfile {
    
    private String username;
    private String password;
    private Set<String> friends;

    public UserProfile() {
        
    }

    public UserProfile(String username, String password) {
        this.username = username;
        this.password = password;
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

    public Set<String> getFriends() {
        if(friends==null){
           friends = new LinkedHashSet<>();
        }
        return friends;
    }

    public void setFriends(Set<String> friends) {
        this.friends = friends;
    }
    
    
    public void addFriend(String username){
        if(!username.equals(this.username)){
           if(friends==null){
              friends = new LinkedHashSet<>();
           }
           friends.add(username);
        }
    }
    
}
