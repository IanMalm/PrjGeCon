/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Query;
import pojo.TbPessoa;

/**
 *
 * @author Hiragi
 */
public class TbPessoaDAO extends BaseDAO<TbPessoa>{
    public List<TbPessoa> consultarPorNumApartamento(int numero) {
        List<TbPessoa> lista;
        Query qy = hib.createQuery("SELECT obj FROM TbPessoa obj WHERE obj.tbApartamento.numApartamento = ?");
        qy.setInteger(1, numero);
        lista = qy.list();
        return lista;
    }
}
