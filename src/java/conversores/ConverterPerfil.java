/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversores;

import dao.TdPerfilDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pojo.TdPerfil;

/**
 *
 * @author ian.malm
 */
@FacesConverter(value="converterPerfil")
public class ConverterPerfil implements Converter {

    private TdPerfilDAO dao = new TdPerfilDAO();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.equals("")){
            return null;
        }
        TdPerfil tdPerfil = dao.consultarPorIdt(Integer.parseInt(value));
        return tdPerfil;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null){
            return "";
        }
        TdPerfil tdPerfil = (TdPerfil) value;
        return String.valueOf( tdPerfil.getIdtPerfil());
    }

}