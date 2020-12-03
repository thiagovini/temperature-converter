package br.univille.app.mvc.login;

import br.univille.app.mvc.utils.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Representa a interface de Tela
public class LoginView extends JFrame {

    private LoginModel model;
    private JTextField emailTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;
    private JLabel statusLabel;

    /*fonts*/

    Font loginFont = new Font("Verdana", Font.BOLD, 13);

    public LoginView(LoginModel model){
        this.model = model;
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildScreen();
        // Configura o tamanho da tela automaticamente
        pack();
    }

    private void buildScreen() {
        JPanel panel = new JPanel(new SpringLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,250,150));
        /*------------------------------------------------------------------------------------*/

        ImageIcon icon = new ImageIcon("assets/login.png");
        JLabel image = new JLabel(icon);
        image.setBounds(0,0,0,0);

        /*------------------------------------------------------------------------------------*/

        JLabel emailLabel = new JLabel("email",JLabel.TRAILING);
        emailLabel.setFont(loginFont);

        JLabel passwordLabel = new JLabel("password",JLabel.TRAILING);
        passwordLabel.setFont(loginFont);

        passwordLabel.setToolTipText("Informe sua senha");


        /*------------------------------------------------------------------------------------*/

        emailTextField = new JTextField(20);
        emailTextField.setToolTipText("Informe seu email");
        passwordTextField = new JPasswordField(20);

        /*------------------------------------------------------------------------------------*/

        loginButton = new JButton("LOGIN");
        loginButton.setFont(loginFont);

        /*------------------------------------------------------------------------------------*/

        statusLabel = new JLabel("");

        /*------------------------------------------------------------------------------------*/

        panel.add(emailLabel);
        panel.add(emailTextField);
        panel.add(passwordLabel);
        panel.add(passwordTextField);
        panel.add(new JLabel(""));
        panel.add(loginButton);
        panel.add(new JLabel(""));
        panel.add(statusLabel);

        SpringUtilities.makeCompactGrid(panel,
                4, 2, //rows, cols
                65, 180,        //initX, initY
                6, 10);       //xPad, yPad

        setContentPane(panel);
        panel.add(image);
    }

    public void setLoginButtonActionListener(ActionListener action){

        loginButton.addActionListener(action);

    }

    public String getEmail(){

        return emailTextField.getText();

    }

    public String getPassword(){

        return passwordTextField.getText();

    }

    public void setStatus(String message) {

        statusLabel.setText(message);

    }
}
