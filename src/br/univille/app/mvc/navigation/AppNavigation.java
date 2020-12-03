package br.univille.app.mvc.navigation;

import br.univille.app.mvc.converter.ConverterModel;
import br.univille.app.mvc.home.HomeController;
import br.univille.app.mvc.home.HomeModel;
import br.univille.app.mvc.home.HomeView;
import br.univille.app.mvc.login.LoginController;
import br.univille.app.mvc.login.LoginModel;
import br.univille.app.mvc.login.LoginView;

import java.io.IOException;

// Utilizada para abrir as telas, navegação
public class AppNavigation {

    public static void toLogin() throws IOException {
        LoginModel model = new LoginModel();
        LoginController control = new LoginController(new LoginView(model), model);
        control.exibirTela();
    }

    /*
    TODO :  Obter os dados do login recebido por parametro
        e consultar no banco de dados os dados do usuario
     */
    public static void toHome(LoginModel model){
        HomeModel homeModel = new HomeModel();
        ConverterModel converterModel = new ConverterModel();
        HomeController homeController = new HomeController(new HomeView(homeModel),homeModel, converterModel);
        homeController.exibirTela();
    }

}
