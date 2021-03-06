/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversores;

import dao.TbAreaLazerDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pojo.TbAreaLazer;

/**
 *
 * @author ian.malm
 */
@FacesConverter(value="converterAreaLazer")
public class ConverterAreaLazer implements Converter {

    private TbAreaLazerDAO dao = new TbAreaLazerDAO();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.equals("")){
            return null;
        }
        TbAreaLazer tbAreaLazer = dao.consultarPorIdt(Integer.parseInt(value));
        return tbAreaLazer;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null){
            return "";
        }
        TbAreaLazer tbAreaLazer = (TbAreaLazer) value;
        return String.valueOf( tbAreaLazer.getIdtAreaLazer());
    }

}