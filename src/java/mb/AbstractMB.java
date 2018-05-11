/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import util.JsfUtil;

/**
 * @ra 21450510
 * @author Matheus Lopes
 */
public class AbstractMB {

    public AbstractMB() {
    }
    
     protected void displayErrorMessage(String message){
        JsfUtil futil = new JsfUtil();
        futil.sendErrorMessage(message);
    }
    
    protected void displayInfoMessage(String message){
        JsfUtil futil = new JsfUtil();
        futil.sendInfoMessage(message);
    }
}
