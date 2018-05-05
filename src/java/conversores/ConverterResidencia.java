/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversores;

import dao.TbResidenciaDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pojo.TbResidencia;

/**
 *
 * @author ian.malm
 */
@FacesConverter(value="converterResidencia")
public class ConverterResidencia implements Converter {

    private TbResidenciaDAO dao = new TbResidenciaDAO();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.equals("")){
            return null;
        }
        TbResidencia tdResidencia = dao.consultarPorIdt(Integer.parseInt(value));
        return tdResidencia;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null){
            return "";
        }
        TbResidencia tdResidencia = (TbResidencia) value;
        return String.valueOf( tdResidencia.getIdtResidencia());
    }

}