/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import pojo.TbAreaLazer;

/**
 *
 * @author ianmalm
 */
public class TbAreaLazerDAO extends BaseDAO<TbAreaLazer> {
    public List<TbAreaLazer> consultarAreaPorCondominio(Integer codMorador){
        List<TbAreaLazer> lista;
        Query qy = hib.createQuery("SELECT obj FROM TbAreaLazer obj WHERE obj.tbCondominio.idtCondominio = ?");
        qy.setInteger(0, codMorador);
        lista = qy.list();
        return lista;
    }
}
