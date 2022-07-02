/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EventX;

import java.io.Serializable;

/**
 *
 * @author kundu
 */
public class User implements Serializable {
    
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String gender;
    private String dob;
    private boolean isLoggedOn;
    
    public User()
    {
        first_name=null;
        last_name=null;
        email=null;
        password=null;
        gender=null;
        dob=null;
        isLoggedOn=false;
        
    }     
     
    public void setFirstName(String first_name)
    {
        this.first_name=first_name;
    }
    
    public void setLastName(String last_name)
    {
        this.last_name=last_name;
    }
    
    public void setEmail(String email)
    {
        this.email=email;
    }
    
    public void setPassword(char[] password)
    {
        String temp="";
        for(char c:password)temp+=c;
        this.password=temp;
    }
    
    public void setGender(String gender)
    {
        this.gender=gender;
    }
    
    public void setDob(int dd,int mm,int yy)
    {
        this.dob=""+dd+"/"+mm+"/"+yy;
    }

    public void setIsLoggedOn(boolean isLoggedOn) {
        this.isLoggedOn = isLoggedOn;
    }
    
    
    public boolean isIsLoggedOn() {
        return isLoggedOn;
    }
    
    public String getFirstName()
    {
        return this.first_name;
    }
    
    public String getLastName()
    {
        return this.last_name;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public String getGender()
    {
        return this.gender;
    }
    
    public String getDob()
    {
        return this.dob;
    }
    
    @Override
    public String toString()
    {
        return this.first_name+","+this.last_name+","+this.email+","+this.password+","+gender+","+dob+","+this.isLoggedOn;
    }
    
    
}
