/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import pojo.TbMensagem;

/**
 *
 * @author ianmalm
 */
public class TbMensagemDAO extends BaseDAO<TbMensagem>{
    public List<TbMensagem> consultarPorTxt(String txt) {
        List<TbMensagem> lista;
        Query qy = hib.createQuery("SELECT obj FROM TbMensagem obj WHERE txtMensagem LIKE ?");
        qy.setString(0, "%" + txt + "%");
        lista = qy.list();
        return lista;
    }
}
