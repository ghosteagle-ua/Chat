
package com.mycompany.tutorial;

import java.util.LinkedHashSet;
import java.util.Set;

public class AcountService {
    
    
    private Set<UserProfile> users;
    private static AcountService acountService;
    
    private AcountService (){
        users = new LinkedHashSet<>();
        users.add(new UserProfile("admin","admin"));
        users.add(new UserProfile("test","test")); 
    }
    
    public static AcountService getInstance(){
        if(acountService==null){
           acountService = new AcountService();
        }
        return acountService; 
    }
    
    
    public void addUser(UserProfile user){
        users.add(user);
    }
    
    public void removeUser(String username){
        users.removeIf(u-> u.getUsername().equals(username));
    }
    
    public Boolean userExist(String username){
        for(UserProfile profile : users){
            if(profile.getUsername().equals(username)) return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    
    public UserProfile getUserProfile(String username){
        
        for(UserProfile profile : users){
            if(profile.getUsername().equals(username))
                return profile;
        }
        return null;
    }
    
    public Boolean checkProfileData(String username, String password){
        for(UserProfile profile: users){
            if(profile.getPassword().equals(password) 
                    && profile.getUsername().equals(username))
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Set<UserProfile> getUsers() {
        return users;
    }
    
    
}
