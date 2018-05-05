/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TbCondominioDAO;
import dao.TbAreaLazerDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pojo.TbCondominio;
import pojo.TbAreaLazer;

/**
 *
 * @author ian.malm
 */
@ManagedBean
@ViewScoped
public class AreaLazerMB {

    private TbAreaLazer selecionado;
    private List<TbAreaLazer> areasLazer;
    private String dscAreaLazer;
    private List<TbCondominio> condominios;
    private TbCondominioDAO condDao = new TbCondominioDAO();
    
    /**
     * Creates a new instance of ResidenciaMB
     */
    public AreaLazerMB() {
        selecionado = new TbAreaLazer();
        dscAreaLazer = "";
        condominios = condDao.consultarTodos();
        filtrar();
    }
    
    public void filtrar(){
        TbAreaLazerDAO dao = new TbAreaLazerDAO();
        setAreasLazer(dao.consultarPorDsc(getDscAreaLazer()));
    }
    
    
    public void novo() {
        setSelecionado(new TbAreaLazer());
        getSelecionado().setIdtAreaLazer(0);
        setDscAreaLazer("");
    }

    public void salvar() {
        TbAreaLazerDAO dao = new TbAreaLazerDAO();
        if (getSelecionado().getIdtAreaLazer()== 0) {
            getSelecionado().setIdtAreaLazer(null);
            dao.incluir(getSelecionado());
        } else {
            dao.juntar(getSelecionado());
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        filtrar();
    }

    public void excluir() {
        TbAreaLazerDAO dao = new TbAreaLazerDAO();
        if (getSelecionado().getIdtAreaLazer()!= 0) {
            if (getSelecionado().getTaReservas().size() > 0) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Esta área possui reserva(s): " + getSelecionado().getDscAreaLazer()+ ".");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return;
            }
            
            if (dao.excluir(getSelecionado().getIdtAreaLazer())) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Exclusão", "Exclusão efetuada com sucesso.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Não foi possível excluir.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return;
            }
        }
        filtrar();
    }

    public TbAreaLazer getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(TbAreaLazer selecionado) {
        this.selecionado = selecionado;
    }

    public List<TbAreaLazer> getAreasLazer() {
        return areasLazer;
    }

    public void setAreasLazer(List<TbAreaLazer> areasLazer) {
        this.areasLazer = areasLazer;
    }

    public String getDscAreaLazer() {
        return dscAreaLazer;
    }

    public void setDscAreaLazer(String dscAreaLazer) {
        this.dscAreaLazer = dscAreaLazer;
    }

    public List<TbCondominio> getCondominios() {
        return condominios;
    }

    public void setCondominios(List<TbCondominio> condominios) {
        this.condominios = condominios;
    }

    public TbCondominioDAO getCondDao() {
        return condDao;
    }

    public void setCondDao(TbCondominioDAO condDao) {
        this.condDao = condDao;
    }
    
}
