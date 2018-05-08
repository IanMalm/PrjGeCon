/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import pojo.TaReserva;

/**
 *
 * @author ian.malm
 */
public class TaReservaDAO extends BaseDAO<TaReserva>{
    public List<TaReserva> consultarReservaPorNomeMorador(String nme){
        List<TaReserva> lista;
        Query qy = hib.createQuery("SELECT obj FROM TaReserva obj WHERE obj.taMorador.tbPessoa.nmePessoa LIKE ?");
        qy.setString(0, "%" + nme + "%");
        lista = qy.list();
        return lista;
    }
}
