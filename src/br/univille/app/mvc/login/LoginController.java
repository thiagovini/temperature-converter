package br.univille.app.mvc.login;

import br.univille.app.mvc.navigation.AppNavigation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    private LoginModel model;
    private LoginView view;

    public LoginController(LoginView view, LoginModel model){
        this.view = view;
        this.model = model;
        this.view.setLoginButtonActionListener(new LoginButtonActionListener());
    }

    public void exibirTela(){

        view.setVisible(true);

    }

    private void validarAcessoDoUsuario(){
        model.setEmail(view.getEmail());
        model.setPassword(view.getPassword());
        try {
            model.validarAcesso();
            view.dispose(); // fecha a janela
            AppNavigation.toHome(model);
        }catch (LoginException e){
            view.setStatus(e.getMessage());
        }
    }

    public class LoginButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            validarAcessoDoUsuario();
        }

    }


}
