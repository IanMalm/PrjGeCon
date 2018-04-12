/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Hiragi
 */
@ManagedBean
@SessionScoped
public class GeralMB {

    String hoje;

    /**
     * Creates a new instance of GeralMB
     */
    public GeralMB() {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
            String data = fmt.format(new Date());
            hoje = "Hoje é " + data;
        } catch (Exception ex) {
            hoje = "";
        }
    }

    public String getHoje() {
        return hoje;
    }

    public void setHoje(String hoje) {
        this.hoje = hoje;
    }

}
