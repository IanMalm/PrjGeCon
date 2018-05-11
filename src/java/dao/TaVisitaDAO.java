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
        Query qy = hib.createQuery("SELECT obj FROM TaVisita obj WHERE obj.tbPessoa.nmePessoa LIKE ? ");
        qy.setString(0, "%" + nme + "%");
        lista = qy.list();
        return lista;
    }
}

