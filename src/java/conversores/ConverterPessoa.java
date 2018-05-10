/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversores;

import dao.TbPessoaDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pojo.TbPessoa;

/**
 *
 * @author ian.malm
 */
@FacesConverter(value="converterPessoa")
public class ConverterPessoa implements Converter {

    private TbPessoaDAO dao = new TbPessoaDAO();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.equals("")){
            return null;
        }
        TbPessoa tbPessoa = dao.consultarPorIdt(Integer.parseInt(value));
        return tbPessoa;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null){
            return "";
        }
        TbPessoa tbPessoa = (TbPessoa) value;
        return String.valueOf( tbPessoa.getIdtPessoa());
    }

}