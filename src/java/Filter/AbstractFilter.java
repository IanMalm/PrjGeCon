/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Matheus Lopes
 * @ra 21450510
 */
public class AbstractFilter {

    public AbstractFilter() {
    }
    
    protected void doLogin(ServletRequest request, ServletResponse response, HttpServletRequest req) throws ServletException, IOException{
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.xhtml");
        dispatcher.forward(request, response);
    }
    
    protected void acessoNegado(ServletRequest request, ServletResponse response, HttpServletRequest req) throws ServletException, IOException{
        RequestDispatcher dispatcher = req.getRequestDispatcher("acesso negado");
        dispatcher.forward(request, response);
    }
}
