/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import pojo.TaMorador;

/**
 *
 * @author ian.malm
 */
public class TaMoradorDAO extends BaseDAO<TaMorador>{
    public List<TaMorador> consultarMoradorNaoUsuario(){
        List<TaMorador> lista;
        Query qy = hib.createQuery("SELECT obj FROM TaMorador obj WHERE NOT EXISTS (SELECT obj FROM TbUsuario WHERE obj.idtMorador = cod_morador)");
        lista = qy.list();
        return lista;
    }
    
}
