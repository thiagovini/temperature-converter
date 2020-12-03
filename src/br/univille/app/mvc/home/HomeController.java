package br.univille.app.mvc.home;


import br.univille.app.mvc.converter.ConverterController;
import br.univille.app.mvc.converter.ConverterModel;
import br.univille.app.mvc.navigation.AppNavigation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class HomeController {

    private HomeModel homeModel;
    private ConverterModel converterModel;
    private HomeView view;

    public HomeController(HomeView view, HomeModel model, ConverterModel converterModel){
        this.homeModel = model;
        this.converterModel = converterModel;
        this.view = view;
        this.view.setLogoutActionListener(new LogoutButtonActionListener());
        this.view.setExitActionListener(new ExitActionListener());
        this.view.setAboutActionListener(new AboutActionListener());
        this.view.setConverterButtonActionListener(new ConverterButtonActionListener());
    }


    public void exibirTela(){
        view.setVisible(true);
    }


    private void logoutDoUsuario() throws IOException {
        view.dispose();
        AppNavigation.toLogin();
    }

    private void exit(){
        view.dispose();
    }

    private void showAlertAboutApp(){
        JOptionPane.showMessageDialog(null
                ,"To use the temperature converter is very simple."
                +   "\n"
                +   "\n"
                +   "Just select where to where and click \"converter\""
                ,"About this app"
                ,JOptionPane.INFORMATION_MESSAGE);
    }

    public class LogoutButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                logoutDoUsuario();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    public class ExitActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            exit();
        }

    }

    public class AboutActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            showAlertAboutApp();
        }

    }

    public class ConverterButtonActionListener implements ActionListener {
        ConverterController converterController = new ConverterController(view, converterModel);
        @Override
        public void actionPerformed(ActionEvent e) {
            converterController.callConverter();
        }
    }

}
