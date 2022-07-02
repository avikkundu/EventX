/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EventX;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author kundu
 */
public class LogIn extends JFrame
{
     public static  int W=700;
     public static  int H=1300;
     
     private  JPanel content_pane;
     
     
     private  JTextField user_name;
     private  JPasswordField password;
     private  JLabel back_ground;
     private JLabel login_header;
     
     
     private final UserManager umanager;
     private final DisplayManager disp_manager;
     
     public LogIn(DisplayManager ob)
     {
         content_pane=new JPanel();
         login_header=new JLabel();
         user_name=new JTextField();
         password=new JPasswordField();
         back_ground=new JLabel();
         umanager=new UserManager();
         disp_manager=ob;
     }

    public UserManager getUmanager() {
        return umanager;
    }
   
     
     public void load_page()
     {
         
         this.setExtendedState(JFrame.MAXIMIZED_BOTH);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setTitle("EventX");
         this.setResizable(false);
         this.setLayout(null);
         
         add_labels();
         add_panel();
         this.setVisible(true);
     }
     
     private String getFileLocation()
    {
        File temp=new File("_");
        String path=temp.getAbsolutePath().replace("\\", "\\\\");
        return path.substring(0, path.length()-1);
    }
     
     private void add_panel()
     {
        content_pane.setLayout(null);
        content_pane.add(login_header);
        content_pane.add(user_name);
        content_pane.add(password);
        content_pane. setBackground(new Color(0.0f, 0.0f, 0.0f, 0.1f));
        content_pane.setBounds(800, 130, 400, 400);
        content_pane.setBorder(new LineBorder(Color.BLACK)); 
        content_pane.setOpaque(true);
        
     }
     
     private void add_labels()
     {
         
        JLabel logo=new JLabel("EventX");
        logo.setFont(new Font("Gabriola",Font.BOLD,55));
        logo.setBounds(950,20,200,100);
        logo.setForeground(Color.red);
        
        JLabel tagline=new JLabel("Planning Made Easy");
        tagline.setFont(new Font("Gabriola",Font.BOLD,20));
        tagline.setBounds(950,35,200,100);
        tagline.setForeground(Color.white);
         
        try 
        {
            String loc=getFileLocation();
            BufferedImage img = ImageIO.read(new File(loc+"\\\\src\\\\main\\\\resources\\\\busy.jpg"));
            Image button_img = img.getScaledInstance(H,W, Image.SCALE_SMOOTH);
            back_ground.setIcon(new ImageIcon(button_img));
        } 
        catch (IOException ex) 
        {
            System.err.println(ex);
        }
        back_ground.setOpaque(true);
        back_ground.setBounds(0, 0 , H, W);
       
        
        login_header.setText("SIGN-IN");
        login_header.setFont(new Font("Arial", Font.BOLD, 35));
        login_header.setForeground(Color.white);
        login_header.setHorizontalAlignment(SwingConstants.CENTER);
        login_header.setBounds(10, 10, 400, 30);
        
        JLabel user_text=new JLabel();
        
        user_text.setText("Email :");
        user_text.setFont(new Font("Arial",Font.PLAIN,20));
        user_text.setForeground(Color.white);
        user_text.setBounds(10, 40, 100, 40);
        user_text.setOpaque(false);
        content_pane.add(user_text);
        
        user_name.setBounds(10, 80, 380, 30);
        
        
        password.setBounds(10,150,380,30);
        password.setEchoChar('*');
        
        JLabel password_text=new JLabel();
        
        password_text.setText("Password :");
        password_text.setFont(new Font("Arial",Font.PLAIN,20));
        password_text.setForeground(Color.white);
        password_text.setBounds(10, 110, 100, 40);
        password_text.setOpaque(false);
        content_pane.add(password_text);
        
        JLabel forgot_password=new JLabel();
        
        forgot_password.setText("Forgot Password?Click here.");
        forgot_password.setFont(new Font("Arial",Font.BOLD,10));
        forgot_password.setForeground(Color.WHITE);
        forgot_password.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        forgot_password.setBounds(250,120, 200,40);
        content_pane.add(forgot_password);
        
        forgot_password.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                
                disp_manager.getForgotpwd().load_page();
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        JButton signIn=new JButton();
        
        signIn.setText("Sign-In");
        signIn.setBounds(10, 220, 380, 30);
        signIn.setBackground(new Color(0,0,0));
        signIn.setForeground(new Color(255,255,255));
        content_pane.add(signIn);
        
        JLabel signUp_text=new JLabel();
        
        signUp_text.setText(" -----New to EventX ? Sign-Up now! ----- ");
        signUp_text.setFont(new Font("Arial",Font.PLAIN,20));
        signUp_text.setForeground(Color.white);
        signUp_text.setBounds(10,290,380,30);
        signUp_text.setHorizontalAlignment(SwingConstants.CENTER);
        content_pane.add(signUp_text);
         
        JButton signUp=new JButton();
        signUp.setText("Sign-Up");
        signUp.setBounds(10, 350, 380, 30);
        signUp. setBackground(new Color(0, 0, 0));
        signUp.setForeground(new Color(255,255,255));       
        content_pane.add(signUp);
        
        signIn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
               
               if(user_name.getText().trim().equals(""))
               {
                   JOptionPane.showMessageDialog(new JFrame(), "Please enter a user-name !!",
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
                   return;
               }
               
               if(umanager.isValidUser(user_name.getText()))
               {
                   if(umanager.isLogged(user_name.getText(), password.getPassword()))
                   {
                       dispose();
                       disp_manager.getDashBoard().setUser(UserManager.getUser(user_name.getText().trim()));
                       disp_manager.getDashBoard().load_page();
                       
                       //ob.load_page();
                       System.out.println(" LogIn Successful ");
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(new JFrame(), "Username and Password do not match !!",
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
                       System.out.println("Username and Password do not match !!");
                   }
               }
               else
               {
                   JOptionPane.showMessageDialog(new JFrame(), "User not registered !!",
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
                   System.out.println("User not Registered !! ");
               }
            }

            @Override
            public void mousePressed(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseExited(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        signUp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                    disp_manager.getSignUp().load_page();                
                    System.out.println("System is running !!");
           
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
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseExited(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        JCheckBox show_psswd=new JCheckBox();
        
        show_psswd.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
               
               if(e.getStateChange()==1)
                   password.setEchoChar((char)0);
               else
                   password.setEchoChar('*');
               
            }
        });
        
        show_psswd.setBounds(10,195,15,12);
        show_psswd. setBackground(Color.BLACK);
        show_psswd.setOpaque(true);
        
        JLabel showpsswd_text=new JLabel("Show Password");
        showpsswd_text.setForeground(Color.white);
        showpsswd_text.setBounds(30,190,200,20);
        
        content_pane.add(showpsswd_text);
        content_pane.add(show_psswd);
        
        
        JLabel footer=new JLabel("Copyright ©™ 2022 @EventX. All rights reserved .");
        footer.setBounds(10,650,500,50);
        footer.setForeground(Color.WHITE);
        
        this.add(footer);
        this.add(logo);
        this.add(tagline);
        this.add(content_pane);
        this.add(back_ground);
        
        
     }
    
   
}
