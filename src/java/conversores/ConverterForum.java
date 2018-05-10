/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversores;

import dao.TbForumDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pojo.TbForum;

/**
 *
 * @author ian.malm
 */
@FacesConverter(value="converterForum")
public class ConverterForum implements Converter {

    private TbForumDAO dao = new TbForumDAO();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.equals("")){
            return null;
        }
        TbForum tbForum = dao.consultarPorIdt(Integer.parseInt(value));
        return tbForum;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null){
            return "";
        }
        TbForum tbForum = (TbForum) value;
        return String.valueOf( tbForum.getIdtForum());
    }

}