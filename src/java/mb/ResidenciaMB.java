/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TbCondominioDAO;
import dao.TbResidenciaDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pojo.TbCondominio;
import pojo.TbResidencia;

/**
 *
 * @author ian.malm
 */
@ManagedBean
@ViewScoped
public class ResidenciaMB {

    private TbResidencia selecionado;
    private List<TbResidencia> residencias;
    private String dscResidencia;
    private List<TbCondominio> condominios;
    private TbCondominioDAO condDao = new TbCondominioDAO();
    
    /**
     * Creates a new instance of ResidenciaMB
     */
    public ResidenciaMB() {
        selecionado = new TbResidencia();
        dscResidencia = "";
        condominios = condDao.consultarTodos();
        filtrar();
    }
    
    public void filtrar(){
        TbResidenciaDAO dao = new TbResidenciaDAO();
        setResidencias(dao.consultarPorDsc(getDscResidencia()));
    }
    
    
    public void novo() {
        setSelecionado(new TbResidencia());
        getSelecionado().setIdtResidencia(0);
        setDscResidencia("");
    }

    public void salvar() {
        TbResidenciaDAO dao = new TbResidenciaDAO();
        if (getSelecionado().getIdtResidencia()== 0) {
            getSelecionado().setIdtResidencia(null);
            dao.incluir(getSelecionado());
        } else {
            dao.juntar(getSelecionado());
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        filtrar();
    }

    public void excluir() {
        TbResidenciaDAO dao = new TbResidenciaDAO();
        if (getSelecionado().getIdtResidencia() != 0) {
            if (getSelecionado().getTaMoradors().size() > 0) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Esta residência possui moradore(s): " + getSelecionado().getDscResidencia()+ ".");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return;
            }else if (getSelecionado().getTbGaragems().size() > 0) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Esta residência possui garagem(ns): " + getSelecionado().getDscResidencia()+ ".");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return;
            }
            
            if (dao.excluir(getSelecionado().getIdtResidencia())) {
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
    
    public TbResidencia getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(TbResidencia selecionado) {
        this.selecionado = selecionado;
    }

    public List<TbResidencia> getResidencias() {
        return residencias;
    }

    public void setResidencias(List<TbResidencia> residencias) {
        this.residencias = residencias;
    }

    public String getDscResidencia() {
        return dscResidencia;
    }

    public void setDscResidencia(String dscResidencia) {
        this.dscResidencia = dscResidencia;
    }

    public List<TbCondominio> getCondominios() {
        return condominios;
    }

    public void setCondominios(List<TbCondominio> condominios) {
        this.condominios = condominios;
    }
    
}
