/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TbUsuarioDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import pojo.TbUsuario;

/**
 * @ra 21450510
 * @author Matheus Lopes
 */
@RequestScoped
@ManagedBean
public class LoginMB extends AbstractMB {

    @ManagedProperty(value = UsuarioMB.INJECTION_NAME)
    private UsuarioMB usuarioMB;

    private String loginUsuario;
    private String pwdUsuario;

    public void setUsuarioMB(UsuarioMB usuarioMB) {
        this.usuarioMB = usuarioMB;
    }
    
    private TbUsuario isValidLogin(String loginUsuario, String pwdUsuario) {
        TbUsuario user = new TbUsuarioDAO().findByLogin(loginUsuario);
        
        if (user == null || !pwdUsuario.equals(user.getPwdUsuario())) {
            return null;
        }
        return user;
    }

    public String logar() {
        TbUsuario user = isValidLogin(loginUsuario, pwdUsuario);
        if (user != null) {
            usuarioMB.setSelecionado(user);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            request.getSession().setAttribute("user", user);
            return "index";
        }
        displayErrorMessage("Login e senha inválidos");
        return null;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getPwdUsuario() {
        return pwdUsuario;
    }

    public void setPwdUsuario(String pwdUsuario) {
        this.pwdUsuario = pwdUsuario;
    }
}
