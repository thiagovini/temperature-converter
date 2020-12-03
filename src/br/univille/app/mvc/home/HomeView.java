package br.univille.app.mvc.home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class HomeView extends JFrame {

    private HomeModel model;
    private JMenuItem logoutMenuItem;
    private JMenuItem exitMenuItem;
    private JMenuItem aboutMenuItem;
    private JComboBox comboBoxFrom;
    private JComboBox comboBoxTo;
    private JTextField valueFrom;
    private JTextField result;
    private JButton converterJButton;


    public void setResult(double finalResult) {

        result.setText(String.valueOf(finalResult));

    }

    public HomeModel getModel() {
        return model;
    }

    public String getValueFrom() {
        return valueFrom.getText();
    }

    public String getComboBoxTo() {
        return comboBoxTo.getSelectedItem().toString();
    }

    public String getComboBoxFrom() {
        return comboBoxFrom.getSelectedItem().toString();
    }

    /*fonts*/
    Font boldComicFont = new Font("Comic Sans MS", Font.BOLD, 15);
    Font comicFont = new Font("Comic Sans",Font.ITALIC, 12);
    Font verdanaFont = new Font("Verdana", Font.BOLD, 12);

    public HomeView(){}

    public HomeView(HomeModel model){
        this.model = model;
        setTitle("Home");
        setSize(600,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buildMenuBar();
        buildScreen();
    }

    private void buildScreen() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        /*Welcome label*/
        JLabel welcomeLabel = new JLabel("Welcome in the temperature converter.");
        welcomeLabel.setBounds(160,0,400,30);
        welcomeLabel.setFont(boldComicFont);

        /*text from label*/
        JLabel textFrom = new JLabel("FROM:");
        textFrom.setBounds(130,110,100,50);
        textFrom.setFont(boldComicFont);

        /*text to label*/
        JLabel textTo = new JLabel("TO:");
        textTo.setBounds(320,110,100,50);
        textTo.setFont(boldComicFont);

        /*result label*/
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(130,230,100,50);
        resultLabel.setFont(boldComicFont);

        /*-------------------------------------------------------------*/
        valueFrom = new JTextField();
        valueFrom.setHorizontalAlignment(JTextField.CENTER);
        valueFrom.setBounds(130,80,340,20);
        result = new JTextField();
        result.setHorizontalAlignment(JTextField.CENTER);
        result.setBounds(130,270,340,23);

        /*-------------------------------------------------------------*/

        converterJButton = new JButton("Converter");
        converterJButton.setBounds(130,200,340,23);

        /*-------------------------------------------------------------*/

        comboBoxFrom = new JComboBox();
        comboBoxFrom.setBounds(130,150,150,20);
        comboBoxFrom.setFont(comicFont);


        comboBoxFrom.addItem("Kelvin");
        comboBoxFrom.addItem("Celsius");
        comboBoxFrom.addItem("Fahrenheit");

        /*-------------------------------------------------------------*/

        comboBoxTo = new JComboBox();
        comboBoxTo.setBounds(320,150,150,20);
        comboBoxTo.setFont(comicFont);

        comboBoxTo.addItem("Kelvin");
        comboBoxTo.addItem("Celsius");
        comboBoxTo.addItem("Fahrenheit");

        /*-------------------------------------------------------------*/

        panel.add(welcomeLabel);
        panel.add(converterJButton);
        panel.add(textFrom);
        panel.add(comboBoxFrom);
        panel.add(textTo);
        panel.add(comboBoxTo);
        panel.add(valueFrom);
        panel.add(resultLabel);
        panel.add(result);

        setContentPane(panel);
        setVisible(true);
    }

    private void buildMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(verdanaFont);
        fileMenu.setMnemonic(KeyEvent.VK_F);
        logoutMenuItem = new JMenuItem("Logout");
        logoutMenuItem.setMnemonic(KeyEvent.VK_L);

        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic(KeyEvent.VK_E);

        fileMenu.add(logoutMenuItem);
        fileMenu.add(new JToolBar.Separator());
        fileMenu.add(exitMenuItem);

        JMenu helpMenu = new JMenu("Help");
        helpMenu.setFont(verdanaFont);

        aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.setMnemonic(KeyEvent.VK_A);

        helpMenu.add(aboutMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

    }

    public void setConverterButtonActionListener(ActionListener action){

        converterJButton.addActionListener(action);

    }

    public void setLogoutActionListener(ActionListener action){
        logoutMenuItem.addActionListener(action);
    }

    public void setExitActionListener(ActionListener action){
        exitMenuItem.addActionListener(action);
    }

    public void setAboutActionListener(ActionListener action){
        aboutMenuItem.addActionListener(action);
    }

}
