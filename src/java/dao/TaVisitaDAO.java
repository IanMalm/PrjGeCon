/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import pojo.TaVisita;

/**
 *
 * @author ianmalm
 */
public class TaVisitaDAO extends BaseDAO<TaVisita>{

    public List<TaVisita> consultarVisitasPorNmePessoa(String nme){
        List<TaVisita> lista;        
        Query qy = hib.createQuery("SELECT obj FROM TaVisita obj, TbPessoa "
                                + " WHERE obj.codPessoa = idt_pessoa"
                                + " AND nme_pessoa LIKE ? ");
        qy.setString(0, "%" + nme + "%");
        lista = qy.list();
        return lista;
    }
}
