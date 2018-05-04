/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TbCondominioDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pojo.TbCondominio;

/**
 *
 * @author ian.malm
 */
@ManagedBean
@ViewScoped
public class CondominioMB {

    private TbCondominio selecionado;
    private List<TbCondominio> condominios;
    private String nmeCondominio;
    
    /**
     * Creates a new instance of Condominio
     */
    public CondominioMB() {
        
        selecionado = new TbCondominio();
        nmeCondominio = "";
        filtrar();
        
    }
    
    public void filtrar() {
        TbCondominioDAO dao = new TbCondominioDAO();
        setCondominios(dao.consultarPorNme(getNmeCondominio()));
    }
    
    public void novo() {
        setSelecionado(new TbCondominio());
        getSelecionado().setIdtCondominio(0);
        setNmeCondominio("");
    }

    public void salvar() {
        TbCondominioDAO dao = new TbCondominioDAO();
        if (getSelecionado().getIdtCondominio() == 0) {
            getSelecionado().setIdtCondominio(null);
            dao.incluir(getSelecionado());
        } else {
            dao.juntar(getSelecionado());
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        filtrar();
    }

    public void excluir() {
        TbCondominioDAO dao = new TbCondominioDAO();
        if (getSelecionado().getIdtCondominio() != 0) {
            if (getSelecionado().getTbResidencias().size() > 0) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Este condomínio possui residência(s): " + getSelecionado().getNmeCondominio()+ ".");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return;
            }else if (getSelecionado().getTbAreaLazers().size() > 0) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Este condomínio possui área(s) de lazer: " + getSelecionado().getNmeCondominio()+ ".");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return;
            }
            if (dao.excluir(getSelecionado().getIdtCondominio())) {
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
    
    public void setSelecionado(TbCondominio selecionado) {
        this.selecionado = selecionado;
    }

    public void setCondominios(List<TbCondominio> condominios) {
        this.condominios = condominios;
    }

    public TbCondominio getSelecionado() {
        return selecionado;
    }

    public List<TbCondominio> getCondominios() {
        return condominios;
    }

    public String getNmeCondominio() {
        return nmeCondominio;
    }

    public void setNmeCondominio(String nmeCondominio) {
        this.nmeCondominio = nmeCondominio;
    }
    
}
