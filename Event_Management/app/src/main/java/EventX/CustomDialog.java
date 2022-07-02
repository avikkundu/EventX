/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EventX;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author kundu
 */


class CustomDialog extends JDialog
        implements ActionListener,
        PropertyChangeListener {

    private String typedText = null;
    private JTextField textField;
    private String magicWord;
    private JOptionPane optionPane;
    private final String btnString1 = "Enter";
    private final String btnString2 = "Cancel";
    private String captcha;
    
    private boolean isVerified;
    
    public String getValidatedText() {
        return typedText;
    }

    public boolean getIsVerified() {
        return isVerified;
    }
    
    
    public CustomDialog(Frame aFrame,String title,String captcha) {
        super(aFrame, true);

        setTitle(title);
    
        textField = new JTextField(10);
        this.captcha=captcha;
        isVerified=false;
       // btnString1="Enter";
       // btnString2="Cancel";
       
        String msgString1 = "Enter verification code :: ";
      
        Object[] array = {msgString1, textField};

        Object[] options = {btnString1, btnString2};

        optionPane = new JOptionPane(array,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.YES_NO_OPTION,
                null,
                options,
                options[0]);

        setContentPane(optionPane);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent ce) {
                textField.requestFocusInWindow();
            }
        });
       
        textField.addActionListener(this);

        optionPane.addPropertyChangeListener(this);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        optionPane.setValue(btnString1);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        String prop = e.getPropertyName();
        
        if (isVisible()
                && (e.getSource() == optionPane)
                && (JOptionPane.VALUE_PROPERTY.equals(prop)
                || JOptionPane.INPUT_VALUE_PROPERTY.equals(prop))) {
            Object value = optionPane.getValue();

            if (value == JOptionPane.UNINITIALIZED_VALUE) {
                //ignore reset
                return;
            }

            optionPane.setValue(
                    JOptionPane.UNINITIALIZED_VALUE);

            if (btnString1.equals(value)) {
                typedText = textField.getText();
                String ucText = typedText;
                if (ucText.equals(captcha)) {
                    JOptionPane.showMessageDialog(this, "Verification succesfull !");
                    isVerified=true;
                    exit();
                } else {
                    //text was invalid
                    textField.setText("");
                    JOptionPane.showMessageDialog(this,"Wrong Verification Code. Try again!","ERROR",JOptionPane.ERROR_MESSAGE);
                    typedText = null;
                    textField.requestFocusInWindow();
                }
            } else { //user closed dialog or clicked cancel
                
                exit();
            }
        }
    }
    
    public void exit() {
        dispose();
    }

}
