/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EventX;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author kundu
 */
public class Event implements Serializable,Comparable<Event> {
    
    private String name;
    private Date startDate;
    private Date endDate;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate =startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate =endDate;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    
    public String getPath()
    {
        return "";
    }
   
    @Override
    public String toString()
    {
        return this.email+", "+this.name + ", " + this.startDate + ", " + this.endDate ;
    }

    @Override
    public int compareTo(Event o) {
        
        return this.startDate.compareTo(o.startDate);
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean equals(final Object other) {
    
        if(other instanceof Event)
        {
            final Event comp=(Event)other;
            
            SimpleDateFormat df=new SimpleDateFormat("dd MM yyyy  hh:mm");
            if(this.getName().equals(comp.getName()) && df.format(this.getStartDate()).equals(df.format(comp.getStartDate()))
                    && df.format(this.getEndDate()).equals(df.format(comp.getEndDate())))
                return true;
        }
        return false;
    }
    
}
