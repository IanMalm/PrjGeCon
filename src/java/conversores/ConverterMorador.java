/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversores;

import dao.TaMoradorDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pojo.TaMorador;

/**
 *
 * @author ian.malm
 */
@FacesConverter(value="converterMorador")
public class ConverterMorador implements Converter {

    private TaMoradorDAO dao = new TaMoradorDAO();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.equals("")){
            return null;
        }
        TaMorador taMorador = dao.consultarPorIdt(Integer.parseInt(value));
        return taMorador;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null){
            return "";
        }
        TaMorador taMorador = (TaMorador) value;
        return String.valueOf( taMorador.getIdtMorador());
    }

}