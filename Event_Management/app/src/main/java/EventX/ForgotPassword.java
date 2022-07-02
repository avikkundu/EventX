/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EventX;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author kundu
 */
public class ForgotPassword extends JFrame {
    
    private final JTextField email;
    private final JPasswordField pwd;
    private final JPasswordField cnfrm_pwd;
    private final UserManager umanager;
    
    public ForgotPassword(UserManager umanager)
    {
        this.umanager=umanager;
        this.pwd=new JPasswordField();
        this.cnfrm_pwd=new JPasswordField();
        this.email=new JTextField();
    }
    
    
    public void addLabels()
    {
        JLabel email_text=new JLabel("Enter registered email : ");
        email_text.setBounds(10, 20,250, 30);
        email.setBounds(10,50,270,30);
        email.setText("");
        
        this.add(email_text);
        this.add(email);
        
        JLabel pwd_mssg=new JLabel("Enter New Password : ");
        pwd_mssg.setBounds(10,80,250,30);
        
        pwd.setBounds(10, 110, 270,30);
        pwd.setText("");
        
        this.add(pwd_mssg);
        this.add(pwd);
        
        JLabel cnfrm_pwd_mssg=new JLabel("Confirm new Password : ");
        cnfrm_pwd_mssg.setBounds(10,140,250,30);
        
        cnfrm_pwd.setBounds(10,170,270,30);
        cnfrm_pwd.setText("");
        
        this.add(cnfrm_pwd_mssg);
        this.add(cnfrm_pwd);
        
        JButton reset=new JButton("Reset Password");
        reset.setBounds(10,210,270,30);
        reset.setBackground(new Color(0,77,153));
        reset.setForeground(Color.white);
        
        reset.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                
                User temp=UserManager.getUser(email.getText().trim());
                
                if(temp==null)
                {
                    System.out.println("Email-Id not registered !");
                    
                    JOptionPane.showMessageDialog(new JFrame(), "Email-ID not registered !",
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
                   
                    
                }
                else
                {
                    
                    char[] p=pwd.getPassword();
                    
                    if(!umanager.isValidPassword(p))
                    {
                          System.out.println("Password not valid !!");
                          JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid password. \n A vaild password must be of length greater than 8, \n *must contain a Special character,\n *must contain a small and a capital letter, \n *must have a number in it.",
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
                          return;
                    } 
                    
                     String location=getFileLocation();
                     try {
                            String captcha=UserManager.generateCaptcha();
                            
                            Process process = Runtime.getRuntime().exec("python " + location + "scratch.py "+email.getText()+" "+captcha+" "+"Password Reset Verification");
                    
                            CustomDialog ob=new CustomDialog(new JFrame(),"Password Reset Verification",captcha);
                    
                         if(ob.getIsVerified()==true)
                         {
                                 temp.setPassword(pwd.getPassword());
                                 umanager.saveUser();
                                 JOptionPane.showMessageDialog(new JFrame(), "Password Changed Successfully !",
                                    "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                                 dispose();
                                 System.out.println("Password change succesful !");
                         }
                         else
                         {
                                JOptionPane.showMessageDialog(new JFrame(), "Password not changed !",
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
                                dispose();
                                System.out.println("Password change unsuccesful !");
                         }
                    
                        } catch (IOException ex) {
                           System.out.println("Exception");
                        }
                }
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseEntered(MouseEvent e) {
              //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        this.add(reset);
        
    }
    
    public void load_page()
    {
        this.setResizable(false);
        this.setTitle("Reset Password");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(204,255,204));
        addLabels();
        
        this.setVisible(true);
        
    }
 
     private String getFileLocation()
    {
        File temp=new File("_");
        String path=temp.getAbsolutePath().replace("\\", "\\\\");
        return path.substring(0, path.length()-1);
    }
    
}
