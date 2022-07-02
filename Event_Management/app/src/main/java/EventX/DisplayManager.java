/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EventX;

/**
 *
 * @author kundu
 */
public class DisplayManager {
    
    private  LogIn login;
    private  SignUp signUp;
    private DashBoard dashBoard;
    private ForgotPassword forgotpwd;
    
     public DisplayManager()
    {
        login=new LogIn(this);
        signUp=new SignUp();
        dashBoard=new DashBoard(this);
        forgotpwd=new ForgotPassword(login.getUmanager());
    }

    public ForgotPassword getForgotpwd() {
        return forgotpwd;
    }

    public void setForgotpwd(ForgotPassword forgotpwd) {
        this.forgotpwd = forgotpwd;
    }
    
    public DashBoard getDashBoard() {
        return dashBoard;
    }

    public void setDashBoard(DashBoard dashBoard) {
        this.dashBoard = dashBoard;
    }
    
    public LogIn getLogin() {
        return login;
    }

    public SignUp getSignUp() {
        return signUp;
    }

    public void setLogin(LogIn login) {
        this.login = login;
    }

    public void setSignUp(SignUp signUp) {
        this.signUp = signUp;
    }
  
}
