/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EventX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kundu
 */
public class DashBoard extends JFrame{

 
    private JPanel body;
    private DisplayManager dmanager;
    private User user;
 
    private JTabbedPane main_pane;
    private List<Event> evnt;
    
    private EventManager emanager;
    private DefaultTableModel model;
    private DefaultTableModel model2;
    private DefaultTableModel model3;
    
    private int row_curr=0;
    private int row_upcmng=0;
    private int row_pst=0;
    
    private JLabel bodyBck;
    
    JLabel month_mssg;
    JLabel elisted;
    JLabel plisted;
    JLabel clisted;
    
    public DashBoard()
    {
      
        this.body=new JPanel();
      
        this.main_pane=new JTabbedPane();
        this.emanager=new EventManager();
        this.evnt=new ArrayList<>();
        this.model=new DefaultTableModel();
        this.model2=new DefaultTableModel();
        this.model3=new DefaultTableModel();
        this.bodyBck=new JLabel();
        plisted=new JLabel();
        clisted=new JLabel();  
        
    }
    public DashBoard(DisplayManager dmanager) {
     
     this.body=new JPanel();
     this.main_pane=new JTabbedPane();
     this.emanager=new EventManager();
     this.evnt=new ArrayList<>();
     this.model=new DefaultTableModel();
     this.model2=new DefaultTableModel();
     this.model3=new DefaultTableModel();
     this.dmanager=dmanager;
     this.bodyBck=new JLabel();
     plisted=new JLabel();
     clisted=new JLabel();
     
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    private String getFileLocation()
    {
        File temp=new File("_");
        String path=temp.getAbsolutePath().replace("\\", "\\\\");
        return path.substring(0, path.length()-1);
    }
    
    public void load_page()
    {
        add_labels();
        this.add(body); 
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.setTitle("EventX");
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);  
        this.setVisible(true);
        
        JLabel footer=new JLabel("Copyright ©™ 2022 @EventX. All rights reserved .");
        footer.setBounds(10,665,500,30);
        footer.setForeground(Color.WHITE);
        
        body.add(footer);
        
    }
    
    public void add_labels()
    {
      
        JLabel logoName=new JLabel("EVENTX");
        logoName.setFont(new Font("Arial", Font.BOLD, 40));
        logoName.setForeground(Color.BLACK);
        logoName.setBounds(0,0,200,50);
        
        this.body=new JPanel(){
        
            @Override
            public void paintComponent(Graphics g) 
            {
               super.paintComponent(g);
                try 
               {
                   String loc=getFileLocation();
                  BufferedImage bimg = ImageIO.read(new File(loc+"\\\\src\\\\main\\\\resources\\\\dashBoardBck.jpg"));
                  Image logo_img = bimg.getScaledInstance(1280,750, Image.SCALE_SMOOTH);
                  ImageIcon img = new ImageIcon(logo_img);
                  g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
               } 
               catch (IOException ex) 
               {
                  System.err.println(ex);
               }            
            }
        };
       
        body.setBounds(0,0,1280, 750);
        body.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        body.setLayout(null);
       
        JButton logout=new JButton("Logout");
        logout.setBounds(1150, 20, 100, 30);
        
        logout.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
              
               System.out.println("Logout Key pressed !! ");
               
               JOptionPane.showMessageDialog(new JFrame(), "Logout successfull !",
                                   "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
               
               System.exit(0);
               
              //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        body.add(logout);
        
        main_pane.setBounds(340,80,750,500); 
       
        body.add(main_pane);
        JPanel schdl=new JPanel();
        
        schdl.setBackground(new Color(255,204,153));
        schdl.setLayout(null);
        JLabel heading=new JLabel("Schedule Events");
        heading.setBounds(330, 5, 100, 50);
        schdl.add(heading);
        
        ///first page
        
        JButton crt_evnt=new JButton("Create Event");
        JTextField evnt_name=new JTextField();
        JLabel evnt_mssg=new JLabel("Event Name :: ");
        JLabel strt_mssg=new JLabel("Start Date :: ");
        JLabel end_mssg=new JLabel("End Date :: ");
        JLabel strtTime_mssg=new JLabel("Start Time :: ");
        JLabel endTime_mssg=new JLabel("End Time :: ");
        
        evnt_name.setBounds(200,50,300,30);
        evnt_mssg.setBounds(50,45 , 100, 30);
        
        strt_mssg.setBounds(50, 95,100, 30);
        
        end_mssg.setBounds(50, 145, 100, 30);
        
        strtTime_mssg.setBounds(50, 195, 100, 30);
        
        endTime_mssg.setBounds(50, 245, 100, 30);
        
        JComboBox d,m,y,d2,m2,y2,hr,mn,hr2,mn2;
        
        String day[]=new String[31];
        String month[]=new String[12];
        String year[]=new String[100];
        String hour[]=new String[24];
        String min[]=new String[60];
        
        for(int i=0;i<31;i++)
        {
            if(i<9)
            day[i]="0"+(i+1);
            else
            day[i]=""+(i+1);    
        }
        
        for(int i=0;i<12;i++)
        {
            if(i<9)
            month[i]="0"+(i+1);
            else
                month[i]=""+(i+1);
        }
        
        for(int i=0;i<100;i++)year[i]=""+(2021+i);
        
        for(int i=0;i<24;i++){
            
            if(i<10)
            hour[i]="0"+(i);
            else
                hour[i]=""+i;
        }
        
        for(int i=0;i<60;i++)
        {
            if(i<10)
            min[i]="0"+(i);
            else
                min[i]=""+i;
        }
        
        d=new JComboBox(day);
        m=new JComboBox(month);
        y=new JComboBox(year);
        
        
        d2=new JComboBox(day);
        m2=new JComboBox(month);
        y2=new JComboBox(year);
        
        hr=new JComboBox(hour);
        mn=new JComboBox(min);
        
        hr2=new JComboBox(hour);
        mn2=new JComboBox(min);
        
        
        d.setBounds(200,100,100,30);
        m.setBounds(400, 100, 100 ,30);
        y.setBounds(600,100, 100, 30);
        
        
        d2.setBounds(200,150,100,30);
        m2.setBounds(400,150, 100 ,30);
        y2.setBounds(600,150, 100, 30);
        
        
        hr.setBounds(200,200,100,30);
        mn.setBounds(400,200, 100, 30);
        
        JLabel hlabel=new JLabel("  HR     : ");
        hlabel.setBounds(310, 190, 100, 50);
        
        JLabel mlabel=new JLabel("  MIN ");
        mlabel.setBounds(510, 190, 100, 50);
        
        hr2.setBounds(200,250,100,30);
        mn2.setBounds(400,250,100,30);
        
        JLabel hlabel2=new JLabel("  HR     : ");
        hlabel2.setBounds(310, 240, 100, 50);
        
        JLabel mlabel2=new JLabel("  MIN ");
        mlabel2.setBounds(510, 240, 100, 50);
        
        crt_evnt.setBounds(270, 400, 200, 30);
        
        crt_evnt.setBackground(new Color(102,51,0));
        crt_evnt.setForeground(new Color(255,255,255));
        
        crt_evnt.addMouseListener(new MouseListener() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                Event ob=new Event();
                
                if(evnt_name.getText().trim().equals("") || evnt_name.getText()==null)
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Please enter a event name !",
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
                    return ;
                }
                 
                Calendar myCalendar;
                 myCalendar = new GregorianCalendar();
                 
                myCalendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt((String) d.getSelectedItem()));
                myCalendar.set(Calendar.MONTH,Integer.parseInt((String) m.getSelectedItem())-1);
                myCalendar.set(Calendar.YEAR,Integer.parseInt((String)y.getSelectedItem())); 
                myCalendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt((String)hr.getSelectedItem()));
                myCalendar.set(Calendar.MINUTE,Integer.parseInt((String)mn.getSelectedItem()));
                myCalendar.set(Calendar.SECOND,0);
                Date strtdate=myCalendar.getTime();
                
                              
                Calendar myCalendar2;
                myCalendar2 = new GregorianCalendar();
                
                myCalendar2.set(Calendar.DAY_OF_MONTH,Integer.parseInt((String) d2.getSelectedItem()));
                myCalendar2.set(Calendar.MONTH,Integer.parseInt((String) m2.getSelectedItem())-1);
                myCalendar2.set(Calendar.YEAR,Integer.parseInt((String)y2.getSelectedItem()));
                myCalendar2.set(Calendar.HOUR_OF_DAY,Integer.parseInt((String)hr2.getSelectedItem()));
                myCalendar2.set(Calendar.MINUTE,Integer.parseInt((String)mn2.getSelectedItem()));
                myCalendar2.set(Calendar.SECOND,0);
                
                
                
                Date strtdate2=myCalendar2.getTime();
                
                              
                if(strtdate2.compareTo(strtdate)<0)
                {
                      JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid start date !",
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
                     return;
                }
               
                ob.setName(evnt_name.getText().trim());
                ob.setEmail(user.getEmail()); 
                ob.setStartDate(strtdate);
                ob.setEndDate(strtdate2);
                
                if(emanager.checkDuplicate(ob,user.getEmail())==true)
                {
                    System.out.println("Duplicate Event !! ");
                    JOptionPane.showMessageDialog(new JFrame(), "Duplicate Event !",
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                    
                }
                
                       
                evnt=emanager.addEvent(evnt, ob);
                
                               
                emanager.mapEvent(user.getEmail(), evnt);
                
                                
                emanager.saveEvent();
                
                System.out.println("Event saved in file");
                emanager.printEvents();
                
                 addToTable(ob);
                 
                 JOptionPane.showMessageDialog(new JFrame(), "Event created successfully !",
                                   "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                 
                 evnt_name.setText("");
                 d.setSelectedIndex(0);
                 m.setSelectedIndex(0);
                 y.setSelectedIndex(0);
                 
                 d2.setSelectedIndex(0);
                 m2.setSelectedIndex(0);
                 y2.setSelectedIndex(0);
                 
                 hr.setSelectedIndex(0);
                 mn.setSelectedIndex(0);
                 
                 hr2.setSelectedIndex(0);
                 mn2.setSelectedIndex(0);
                 
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
        
        
        schdl.add(d);
        schdl.add(m);
        schdl.add(y);
        schdl.add(hr);
        schdl.add(mn);
        schdl.add(hlabel);
        schdl.add(mlabel);
        schdl.add(d2);
        schdl.add(m2);
        schdl.add(y2);
        schdl.add(hr2);
        schdl.add(mn2);
        schdl.add(hlabel2);
        schdl.add(mlabel2);
        schdl.add(evnt_name);
        schdl.add(crt_evnt);
        schdl.add(evnt_mssg);
        schdl.add(strt_mssg);
        schdl.add(end_mssg);
        schdl.add(strtTime_mssg);
        schdl.add(endTime_mssg);
        
        model2.addColumn("Event Name");
        model2.addColumn("Start Time");
        model2.addColumn("End Time");
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        
        JTable jpl=new JTable(model2);
        
        jpl.setDefaultEditor(Object.class, null);
        jpl.setRowHeight(jpl.getRowHeight() * 2);
        
        for(int i=0;i<=2;i++)
        jpl.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        
        
        JPanel up=new JPanel();
        JScrollPane upcmng=new JScrollPane(jpl,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        up.setLayout(new BorderLayout());
        
        
        
        JPanel details=new JPanel();
        
        details.setLayout(null);
        details.setBackground(new Color(255,179,218));        
        
        JLabel chck=new JLabel("USER DETAILS");
        
        chck.setBounds(105,10, 250, 20);
        
        JLabel jj=new JLabel("Name : "+ user.getFirstName()+"  "+user.getLastName());
        jj.setBounds(20, 40, 200, 50);
        
        month_mssg=new JLabel();
        month_mssg.setText("Total no. of Upcoming Events   :: "+row_upcmng);
        month_mssg.setBounds(20, 100, 300, 50);
        
        elisted=new JLabel();
        elisted.setText("Total no. of events listed           :: "+(row_curr+row_pst+row_upcmng));
        elisted.setBounds(20,300,400,50);
        
        plisted.setText("Total no. of Past Events             :: "+row_pst);
        plisted.setBounds(20,190,400,30);
        
        clisted.setText("Total no. of Current Events        :: "+row_curr);
        clisted.setBounds(20,150,400,30);
        
        JLabel timeLabel = new JLabel();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy    HH:mm:ss");
        timeLabel.setBounds(20,420,250,50);
        
        Timer SimpleTimer = new Timer(1000, new ActionListener(){
         
         @Override
         public void actionPerformed(ActionEvent e) {
            timeLabel.setText("Today's Date :: "+df.format(new Date()));
        
         }
        });
        SimpleTimer.start();
        
        details.add(clisted);
        details.add(plisted);
        details.add(elisted);
        details.add(chck);
        details.add(timeLabel);
        details.add(jj);
        details.add(month_mssg);
        
        details.setBorder( BorderFactory.createLineBorder(Color.BLACK));
        
        up.add(details,BorderLayout.CENTER);
        up.add(upcmng,BorderLayout.EAST);
   
        jpl.setBackground(new Color(251,234,235));
        
        
        
        JPanel current=new JPanel();
        current.setLayout(new BorderLayout());
        
        
        model.addColumn("Event Name");
        model.addColumn("Start Time");
        model.addColumn("End Time");
 
        JTable descrp=new JTable(model);
        
        descrp.setBackground(new Color(251,234,235));
        descrp.setRowHeight(descrp.getRowHeight() * 2);
        descrp.setDefaultEditor(Object.class, null);
        
        for(int i=0;i<=2;i++)
        descrp.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        
        
        JPanel cu=new JPanel();
        cu.setBackground(new Color(252,231,125));
        
        JScrollPane curr=new JScrollPane(descrp,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
       
        
        cu.setLayout(null);
        JLabel check3 =new JLabel("EVENT DETAILS");
        check3.setFont(new Font("Arial",Font.BOLD,20));
        check3.setForeground(new Color(249,97,103));
        check3.setBounds(310,15 , 300, 20);
        
        cu.add(check3);
        
        cu.setBorder( BorderFactory.createLineBorder(Color.BLACK));
        
        current.add(cu,BorderLayout.CENTER);
        current.add(curr,BorderLayout.SOUTH);
        
        
        JPanel pst=new JPanel();
        
        model3.addColumn("Event Name");
        model3.addColumn("Start Time");
        model3.addColumn("End Time");
       
        
        JTable dtls=new JTable(model3);
        
        dtls.setBackground(new Color(251,234,235));
        dtls.setRowHeight(dtls.getRowHeight() * 2);
        dtls.setDefaultEditor(Object.class, null);
        
        for(int i=0;i<=2;i++)
        dtls.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        
        JPanel pp=new JPanel();
        JScrollPane ppr=new JScrollPane(dtls,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        pp.setBackground(new Color(252,231,125));
        
        pp.setLayout(null);
        JLabel check4 =new JLabel("EVENT DETAILS");
        
        check4.setFont(new Font("Arial",Font.BOLD,20));
        check4.setForeground(new Color(249,97,103));
        check4.setBounds(310,15 , 300, 20);
        
        pp.add(check4);
        
        pp.setBorder( BorderFactory.createLineBorder(Color.BLACK));
        
        pst.setLayout(new BorderLayout());
        pst.add(ppr,BorderLayout.SOUTH);
        pst.add(pp,BorderLayout.CENTER);

         setTable();
    
        main_pane.add("Schedule",schdl);
        main_pane.add("Upcoming",up);
        main_pane.add("Curent",current);
        main_pane.add("Past",pst);
        
        
    }
    
    public void setTable()
    {
        Date now=new Date();
        
        evnt=emanager.getEventList(user.getEmail());
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
        
        for(Event e: evnt)
        {
            Date dd=e.getStartDate();
            Date dd2=e.getEndDate();
            int cmp=sdf.format(now).compareTo(sdf.format(dd));
            int cmp2=sdf.format(now).compareTo(sdf.format(dd2));
            
            if(cmp==0 || (cmp>0 && cmp2<=0))
                loadCurrTable(e);
            else if(cmp<0)
                loadUpcomingTable(e);
            else
                loadPastTable(e);
        }
        
        
    }
    
    public void addToTable(Event e)
    {
        Date dd=e.getStartDate();
        Date dd2=e.getEndDate();
        
        Date now=new Date();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
        
        int cmp=sdf.format(now).compareTo(sdf.format(dd));
        int cmp2=sdf.format(now).compareTo(sdf.format(dd2));
        
        if(cmp==0 || (cmp>0 && cmp2<=0) )
            loadCurrTable(e);
        else if(cmp<0)
            loadUpcomingTable(e);
        else
            loadPastTable(e);
        
    }
    
    public void loadCurrTable(Event e)
    {
        
        addRow(model,row_curr++,e);
        clisted.setText("Total no. of Current Events        :: "+row_curr);
        elisted.setText("Total no. of events listed           :: "+(row_curr+row_pst+row_upcmng));        
    }
    
    public void loadPastTable(Event e)
    {
        addRow(model3,row_pst++,e);
        plisted.setText("Total no. of Past Events             :: "+row_pst);
        elisted.setText("Total no. of events listed           :: "+(row_curr+row_pst+row_upcmng));
    }
    
    public void loadUpcomingTable(Event e)
    {
        addRow(model2,row_upcmng++,e);
        month_mssg.setText("Total no. of Upcoming Events   :: "+row_upcmng);
        elisted.setText("Total no. of events listed           :: "+(row_curr+row_pst+row_upcmng));
    }
    
    public void addRow(DefaultTableModel model,int r,Event e)
    {
        Vector<String> lts=new Vector<>();
        
        lts.add(e.getName());
        Date d=e.getStartDate();
      
        SimpleDateFormat localDateFormat = new SimpleDateFormat("dd/MM/yyyy  HH:mm");
        String time = localDateFormat.format(d);
        
        lts.add(time);
        
        Date d2=e.getEndDate();
        
        String time2= localDateFormat.format(d2);
        
        lts.add(time2);
        
        model.insertRow(r, lts);
    }
    
}
