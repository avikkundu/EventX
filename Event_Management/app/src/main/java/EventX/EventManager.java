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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kundu
 */
public class EventManager  implements Serializable{
    
    HashMap<String,List<Event>> event_map;
    
    public EventManager()
    {
        event_map=loadEvent();
    }
    
    public void mapEvent(String email,List<Event> ob)
    {
        event_map.put(email, ob);
    }
    
    public List<Event> addEvent(List<Event> list,Event e)
    {
        list.add(e);
        Collections.sort(list);
        return list;
    }
    
    public List<Event> getEventList(String email)
    {
        for (Map.Entry mapElement : event_map.entrySet()) {
            String key = (String)mapElement.getKey();
 
            
            List<Event> value = (List<Event>) mapElement.getValue();
            
            if(key.equals(email))
            {
                //System.out.println("Event list founds successfully !! ");
                return value;
            }
         
        }
        
        return new ArrayList<Event>();
    }
    
    public void saveEvent()
    {
       
        try {
 
            FileOutputStream fileOut = new FileOutputStream("event.ser");
            try (ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                objectOut.writeObject(event_map);
            }
            System.out.println("The event  was succesfully written to a file");
 
        } catch (IOException ex) {
            System.out.println("Exception in EventManager/saveUser");
        }
        
    }
    
    public void printEvents()
    {
        event_map.forEach((f,s)->
                    System.out.println(f+" , "+s));
    }
    
    public static HashMap<String,List<Event>> loadEvent()
    {
        HashMap<String,List<Event>> temp=new HashMap<>();
        try {
            File ff=new File("event.ser");
            FileInputStream fileIn = new FileInputStream(ff);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            
                Object obj = objectIn.readObject();
              
                temp=(HashMap<String,List<Event>>)obj;
         
 
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("No record exists ");
           
        }
        
        return temp;
    }
    
    public boolean del_event(String email)
    {
        if(event_map.containsKey(email))
        {
            event_map.remove(email);
            return true;
        }
        
        return false;
    }

    public boolean checkDuplicate(Event e,String email)
    {
        for (Map.Entry mapElement : event_map.entrySet()) {
            String key = (String)mapElement.getKey();
 
            
            List<Event> value = (List<Event>) mapElement.getValue();
            
            if(key.equals(email)==true)
            {
               // System.out.println("Event list found !");
                for(Event evnt: value)
                {
                    if(evnt.equals(e)==true)
                    {
                        //System.out.println("Duplicate Event !! ");
                        return true;
                    }
                }
                
            }
         
        }
        
       // System.out.println("event not Duplicate ! ");
        return false;
    }
   
    
    
}
