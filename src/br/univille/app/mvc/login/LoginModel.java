package br.univille.app.mvc.login;

import br.univille.app.mvc.utils.Strings;


// Classe que representa os dados e lógicas de negócio
public class LoginModel {

    private String email;
    private String password;

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    /*
    TODO: Consultar no Banco de dados
     */
    public void validarAcesso() throws LoginException{
        if(Strings.isNullOrEmpty(email)){
            throw new LoginException("email não informado");
        }
        if(Strings.isNullOrEmpty(password)){
            throw new LoginException("password não informado");
        }
        // TODO : chamar a DAO
        if(!"teste".equals(email)
         || !"teste".equals(password)){
            throw new LoginException("login/senha incorretos");
        }
    }

}
