/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import pojo.TbForum;

/**
 *
 * @author ian.malm
 */
public class TbForumDAO extends BaseDAO<TbForum>{
    public List<TbForum> consultarPorTit(String tit) {
        List<TbForum> lista;
        Query qy = hib.createQuery("SELECT obj FROM TbForum obj WHERE titForum LIKE ?");
        qy.setString(0, "%" + tit + "%");
        lista = qy.list();
        return lista;
    }
    
    public List<TbForum> consultarForumPorCondominio(Integer codMorador){
        List<TbForum> lista;
        Query qy = hib.createQuery("SELECT obj FROM TbForum obj WHERE obj.taMorador.tbResidencia.tbCondominio.idtCondominio = ?");
        qy.setInteger(0, codMorador);
        lista = qy.list();
        return lista;
    }
}
