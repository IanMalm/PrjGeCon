/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.HibernateUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.TbUsuario;

@Transactional
public class BaseDAO<Tab> implements Serializable {

    private Class<Tab> classe;
    protected Session hib;

    public BaseDAO(Class<Tab> entity) {
        this.classe = entity;
    }

    public BaseDAO() {
        classe = (Class<Tab>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        hib = HibernateUtil.getSessionFactory().openSession();
    }

    public Class<Tab> getClasse() {
        return this.classe;
    }

    public Tab incluir(Tab obj) {
        Transaction ts = hib.beginTransaction();
        hib.persist(obj);
        hib.flush();
        ts.commit();
        return obj;
    }

    public boolean excluir(int idt) {
        Transaction ts = hib.beginTransaction();
        Tab obj = consultarPorIdt(idt);
        hib.delete(obj);
        hib.flush();
        ts.commit();
        return true;
    }

    public Tab alterar(Tab obj) {
        Transaction ts = hib.beginTransaction();
        hib.update(obj);
        hib.flush();
        ts.commit();
        return obj;
    }

    public Tab juntar(Tab obj) {
        Transaction ts = hib.beginTransaction();
        hib.merge(obj);
        hib.flush();
        ts.commit();
        return obj;
    }

    public Tab consultarPorIdt(int idt) {
        Tab obj;
        Query qy = hib.createQuery("SELECT obj FROM " + getClasse().getSimpleName() + " obj WHERE idt" + getClasse().getSimpleName().substring(2) + "=?");
        qy.setInteger(0, idt);
        obj = (Tab) qy.uniqueResult();
        return obj;
    }

    public Object findByNameJoin() {
        Query query = hib.createSQLQuery("select P.nme_pessoa\n"
                + "    From ta_morador M, tb_pessoa P, tb_condominio C, tb_residencia R\n"
                + "    Where M.cod_pessoa = P.idt_pessoa and\n"
                + "    M.cod_residencia = R.idt_residencia and\n"
                + "    R.cod_condominio = C.idt_condominio;");
        return query.uniqueResult();
    }

    public List<Tab> consultarTodos() {
        List<Tab> lista;
        Query qy = hib.createQuery("SELECT obj FROM " + getClasse().getSimpleName() + " obj ");
        lista = qy.list();
        return lista;
    }

    public List<Tab> consultarPorNme(String nme) {
        List<Tab> lista;
        Query qy = hib.createQuery("SELECT obj FROM " + getClasse().getSimpleName() + " obj WHERE nme" + getClasse().getSimpleName().substring(2) + " LIKE ?");
        qy.setString(0, "%" + nme + "%");
        lista = qy.list();
        return lista;
    }

    public List<Tab> consultarPorSgl(String sgl) {
        List<Tab> lista;
        Query qy = hib.createQuery("SELECT obj FROM " + getClasse().getSimpleName() + " obj WHERE sgl" + getClasse().getSimpleName().substring(2) + " LIKE ?");
        qy.setString(0, "%" + sgl + "%");
        lista = qy.list();
        return lista;
    }

    public List<Tab> consultarPorDsc(String dsc) {
        List<Tab> lista;
        Query qy = hib.createQuery("SELECT obj FROM " + getClasse().getSimpleName() + " obj WHERE dsc" + getClasse().getSimpleName().substring(2) + " LIKE ?");
        qy.setString(0, "%" + dsc + "%");
        lista = qy.list();
        return lista;
    }

    public TbUsuario findByLogin(String loginUsuario) {
        hib.beginTransaction();
        TbUsuario user = (TbUsuario) hib.getNamedQuery("TbUsuario.findByLoginUsuario")
                .setParameter("loginUsuario", loginUsuario).uniqueResult();
        hib.close();
        return user;
    }
}
