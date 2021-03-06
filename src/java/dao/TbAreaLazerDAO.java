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

