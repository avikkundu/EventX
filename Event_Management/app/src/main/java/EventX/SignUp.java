/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EventX;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author kundu
 */
public class SignUp extends JFrame {
    
    private final JTextField first_name;
    private final JTextField last_name;
    
    private final JTextField email;
    
    
    private final JPasswordField pwd;
    private final JPasswordField cnfrm_pwd;
    
    private final JRadioButton male;
    private final JRadioButton female;
    private final JRadioButton custom;
    
    private final UserManager manager;
    
    private JComboBox<String> dd;
    private JComboBox<String> mm;
    private JComboBox<String> yy;
    ButtonGroup grp;
   
    
    public SignUp()
    {
        
        first_name=new JTextField();
        last_name=new JTextField();
        pwd=new JPasswordField();
        cnfrm_pwd=new JPasswordField();
        male=new JRadioButton();
        female=new JRadioButton();
        custom=new JRadioButton();
        email=new JTextField();
        manager=new UserManager();
      
    }
    
    private String getFileLocation()
    {
        File temp=new File("_");
        String path=temp.getAbsolutePath().replace("\\", "\\\\");
        return path.substring(0, path.length()-1);
    }
    
    private void add_labels()
    {
        JLabel header=new JLabel();
        header.setText("Sign-Up");
        header.setFont(new Font("Arial",Font.BOLD,30));
        header.setBounds(130,5,200,40);
        
        this.add(header);
        
        JLabel user_name=new JLabel();
        user_name.setText("User-name : ");
        user_name.setFont(new Font("Arial",Font.BOLD,15));
        user_name.setBounds(10,45,100,50);
        
        this.add(user_name);
        
        first_name.setText("");
        first_name.setBounds(10, 88, 170, 30);
        
        this.add(first_name);
        
        last_name.setText("");
        last_name.setBounds(200,88,170, 30);
        
        this.add(last_name);
        
        JLabel email_mssg=new JLabel();
        
        email_mssg.setText("Email -ID :");
        email_mssg.setFont(new Font("Arial",Font.BOLD,15));
        email_mssg.setBounds(10,120,100,50);
        
        this.add(email_mssg);
        
        email.setBounds(10,170,350,30);
        email.setText("");
        
        this.add(email);
        
        JLabel pwd_mssg=new JLabel();

        pwd_mssg.setText("Password : ");
        pwd_mssg.setFont(new Font("Arial",Font.BOLD,15));
        pwd_mssg.setBounds(10,200,100,50);
        
        this.add(pwd_mssg);
        
        pwd.setBounds(10,240, 350,30);
        pwd.setText("");
        
        this.add(pwd);
        
        JLabel cnfrm_pwd_mssg=new JLabel();
            
        cnfrm_pwd_mssg.setText("Confirm Password :");
        cnfrm_pwd_mssg.setFont(new Font("Arial",Font.BOLD,15));
        cnfrm_pwd_mssg.setBounds(10,260,200,50);
        
        this.add(cnfrm_pwd_mssg);
        
        cnfrm_pwd.setBounds(10,300,350,30);
        cnfrm_pwd.setText("");
        
        this.add(cnfrm_pwd);
        
        JLabel dob=new JLabel();
        dob.setText("Date of Birth : ");
        dob.setFont(new Font("Arial",Font.BOLD,15));
        dob.setBounds(10,330,340,50);
        
        this.add(dob);
        
        String date[];
        String month[];
        String year[];
        
        date=new String[32];
        for(int days=1;days<=31;days++)
            date[days-1]=String.valueOf(days);
        
        month=new String[12];
        
        for(int m=1;m<=12;m++)
        {
            if(m<=9)month[m-1]="0"+String.valueOf(m);
            else month[m-1]=String.valueOf(m);
        }
        
        year=new String[100];
        int index=0;
        
        for(int y=2022-99;y<=2022;y++)
            year[index++]=String.valueOf(y);
        
        
        dd=new JComboBox<>(date);
        dd.setSelectedIndex(0);
        dd.setBounds(10,370,60,30);
        dd.setSelectedIndex(0);
        
        this.add(dd);
        
        mm=new JComboBox<>(month);
        mm.setSelectedIndex(0);
        mm.setBounds(150,370,60,30);
        mm.setSelectedIndex(0);
        
        this.add(mm);
        
        yy=new JComboBox<>(year);
        yy.setSelectedIndex(0);
        yy.setBounds(250,370,90,30);
        yy.setSelectedIndex(0);
                
        this.add(yy);
        
        JLabel gender=new JLabel();
        gender.setText("Gender : ");
        gender.setFont(new Font("Arial",Font.BOLD,15));
        gender.setBounds(10,400,200,50);
        
        this.add(gender);
        
        male.setBounds(10,440,70,30);
        male.setText("Male");
        male.setOpaque(false);
        
        this.add(male);
        
        female.setBounds(130,440,70,30);
        female.setText("Female");
        female.setOpaque(false);
        
        this.add(female);
        
        custom.setBounds(260,440,70,30);
        custom.setText("Custom");
        custom.setOpaque(false);
        
        this.add(custom);
        
        grp=new ButtonGroup();
        grp.add(male);
        grp.add(female);
        grp.add(custom);
        grp.clearSelection();
        
        JButton submit=new JButton();
        submit.setText("CREATE  ACCOUNT");
        submit.setBounds(10,480,360,30);
        
        submit.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
               
              
                if(first_name.getText().trim().equals("") || last_name.getText().trim().equals(""))
                {
                    System.out.println("Please enter a user-name");
                    JOptionPane.showMessageDialog(new JFrame(), "Please enter a user-name.",
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;  
                }
                
                if(email.getText().trim().equals(""))
                {
                     System.out.println("Please enter a email-ID");
                    JOptionPane.showMessageDialog(new JFrame(), "Please enter an email-Id .",
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;  
                }
                
                
                
                 char[] p=pwd.getPassword();
                 char[] cp=cnfrm_pwd.getPassword();
              
               
               if(manager.isValidUser(email.getText().trim()))
               {
                  System.out.println("User already registered !! Please try with a different email ID ! ");
                  JOptionPane.showMessageDialog(new JFrame(), "User Already Registered",
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
                  return ;
               }
               
               if(!manager.isValidPassword(p))
               {
                   System.out.println("Password not valid !!");
                   JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid password. \n A vaild password must be of length greater than 8, \n *must contain a Special character,\n *must contain a small and a capital letter, \n *must have a number in it.",
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
                   return;
               } 
               
               if(!Arrays.equals(p,cp))
               {
                   System.out.println("Passwords do not match !!");
                   JOptionPane.showMessageDialog(new JFrame(), "Passwords do not match !",
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
                   return;
               }
               
               if(male.isSelected()==false && female.isSelected()==false && custom.isSelected()==false  )
               {
                   System.out.println("Gender not selected !");
                   JOptionPane.showMessageDialog(new JFrame(), "Please select a gender !",
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
                   return;
               }
               
               String location=getFileLocation();
                try {
                    String captcha=UserManager.generateCaptcha();
                    String subject="EventX Account Verification";
                    Process process = Runtime.getRuntime().exec("python " + location + "scratch.py "+email.getText()+" "+captcha+" "+subject);
                   
                    
                    CustomDialog ob=new CustomDialog(new JFrame(),"Account Verification",captcha);
                    
                    if(ob.getIsVerified()==true)
                    {
                        add_user(); 
                        dispose();
                        System.out.println("User Verified succesfully ! ");
                    }
                    
                    
                } catch (IOException ex) {
                    System.out.println("Exception");
                }
               
               
                
               System.out.println("Submit Button pressed !!");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseExited(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
        });
        
        submit.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
               
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        submit.setBackground(new Color(0,204,0));
        submit.setForeground(new Color(255,255,255));
        this.add(submit);
        
        JLabel footer=new JLabel("<html>By Signing-Up, you agree to our Terms and Conditions,Privacy <br>and Cookie Policy.</html>");
        footer.setBounds(10,505,380,50);
        
        this.add(footer);
        
        
        
    }
    
    public void load_page()
    {
        this.setBounds(470, 50, 400, 600);
        this.setTitle("EventX");
        this.setResizable(false);
        this.setLayout(null);
      
        add_labels();
        
        getContentPane().setBackground(new Color(204,230,255));
        
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        this.setVisible(true);
        
    }
    
    public void add_user()
    {
               User ob=new User();
               ob.setFirstName(first_name.getText());
               ob.setLastName(last_name.getText());
               ob.setEmail(email.getText());
               
               int day=Integer.parseInt((String)dd.getSelectedItem());
               int mon=Integer.parseInt((String)mm.getSelectedItem());
               int yr=Integer.parseInt((String)yy.getSelectedItem());
               
               ob.setDob(day, mon, yr);
               
               ob.setPassword(pwd.getPassword());
               
               String gen;
               
               if(male.isSelected())gen="male";
               else if(female.isSelected())gen="female";
               else gen="custom";
               
               ob.setGender(gen);
               
               manager.addUser(ob);
               manager.saveUser();
               UserManager.loadUser();
               
               System.out.println("User details saved");
    }
    
    
}
