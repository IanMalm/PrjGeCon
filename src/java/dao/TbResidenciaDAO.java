/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import pojo.TbResidencia;

/**
 *
 * @author ian.malm
 */
public class TbResidenciaDAO extends BaseDAO<TbResidencia>{
public List<TbResidencia> consultarResidenciaSemMorador() {
        List<TbResidencia> lista;
        Query qy = hib.createQuery("SELECT obj FROM TbResidencia obj WHERE NOT EXISTS (SELECT obj FROM TaMorador WHERE obj.idtResidencia = cod_residencia)");
        lista = qy.list();
        return lista;
    }
}
