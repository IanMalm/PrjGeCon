/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversores;

import dao.TbCondominioDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pojo.TbCondominio;

/**
 *
 * @author hiragi
 */
@FacesConverter(value="converterCondominio")
public class ConverterCondominio implements Converter {

    private TbCondominioDAO dao = new TbCondominioDAO();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.equals("")){
            return null;
        }
        TbCondominio tbCondominio = dao.consultarPorIdt(Integer.parseInt(value));
        return tbCondominio;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null){
            return "";
        }
        TbCondominio tbCondominio = (TbCondominio) value;
        return String.valueOf( tbCondominio.getIdtCondominio());
    }

}