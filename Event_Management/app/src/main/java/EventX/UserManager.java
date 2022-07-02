/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EventX;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author kundu
 */
public class UserManager {
    
    static HashMap<String,User> user_map;
    
    

    public UserManager() {
        
        user_map=loadUser();
       
    }
    
    public void addUser(User u)
    {
        System.out.println("Adding user in user_map");
        user_map.put(u.getEmail(), u);
    }
    
    public boolean isValidUser(String email)
    {
        for(String chck:user_map.keySet())
        {
            if(chck.equals(email))
                return true;
        }
        return false;
    }
    
    public static User getUser(String  email)
    {
        for (Map.Entry<String, User> set : user_map.entrySet()) {
 
            if(set.getKey().equals(email))
                return set.getValue();
            
        }
        
        return null;
    }
    
    public boolean isLogged(String email,char[] pwd)
    {
      
        Iterator user_itr = user_map.entrySet().iterator();
        String pssd=String.valueOf(pwd);
        
        while (user_itr.hasNext()) {
 
            
            Map.Entry mapElement  = (Map.Entry)user_itr.next();
            
            String et=(String)mapElement.getKey();
            User ut=(User)mapElement.getValue();
            
            System.out.println("User email :: "+et);
            System.out.println("Password :: "+ut.getPassword());
            
            System.out.println("Given User email :: "+email);
            System.out.println("Given Password :: "+pssd);
            
            if(et.equals(email) && ut.getPassword().equals(pssd))
                return true;
             
        }
        return false;
    }
    
    public boolean isPsswdSame(char[] pwd,char[] cnfrm_pwd)
    {
        if(pwd.length!=cnfrm_pwd.length)return false;
        for(int i=0;i<pwd.length;i++)
        {
            if(pwd[i]!=cnfrm_pwd[i])return false;
        }
        return true;
    }
    
     public boolean isValidPassword(char[] p)
    {
        String s=Arrays.toString(p);
        
        if(s.length()<8)return false; 
        
        int c_num=0,c_alphaCaps=0,c_spc=0,c_alphaSmall=0;
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch>='0' && ch<='9')
                c_num++;
            else if(ch=='@' || ch=='#' || ch=='*')
                c_spc++;
            else if((ch>='a' && ch<='z'))
                c_alphaSmall++;
            else if((ch>='A' && ch<='Z'))
               c_alphaCaps++;
        }
        
        return c_num>=1 && c_spc>=1 && c_alphaCaps>=1 && c_alphaSmall>=1;
    }
    
    
     
    public  void saveUser()
    {
       
        try {
 
            FileOutputStream fileOut = new FileOutputStream("user.ser");
            try (ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                objectOut.writeObject(user_map);
            }
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (IOException ex) {
            
            System.out.println("Exception in UserManager/saveUser :: "+ex.getClass().getSimpleName());
        }
        
    }
    
    public static HashMap<String,User> loadUser()
    {
        HashMap<String,User> temp=new HashMap<>();
        try {
            File ff=new File("user.ser");
            FileInputStream fileIn = new FileInputStream(ff);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            
                Object obj = objectIn.readObject();
                temp=(HashMap<String,User>)obj;
                
                //temp.forEach((f,s)->
               // System.out.println(f+" , "+s));
                
 
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("No record exists ");
            
        }
        
        return temp;
    }
    
    public static boolean checkCaptcha(String captcha, String user_captcha)
    {
        return captcha.equals(user_captcha);
    }
    
    public static String generateCaptcha()
    {
        
         int n=8;
   
        String chrs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
      
        String captcha = "";
        while (n-->0){
            int index = (int)(Math.random()*62);
            captcha+=chrs.charAt(index);
        }
           
        return captcha;
    }
    
}
