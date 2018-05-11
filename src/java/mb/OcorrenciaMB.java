/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TaMoradorDAO;
import dao.TbOcorrenciaDAO;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pojo.TaMorador;
import pojo.TbOcorrencia;

/**
 *
 * @author ianmalm
 */
@ManagedBean
@ViewScoped
public class OcorrenciaMB {
    
    private TbOcorrencia selecionado;
    private List<TbOcorrencia> ocorrencias;
    private String dscOcorrencia;
    private List<TaMorador> moradores;
    private TaMoradorDAO morDao = new TaMoradorDAO();
    
    /**
     * Creates a new instance of OcorrenciaMB
     */
    public OcorrenciaMB() {
        selecionado = new TbOcorrencia();
        dscOcorrencia = "";
        moradores = morDao.consultarTodos();
        filtrar();
    }
    
    public void filtrar(){
        TbOcorrenciaDAO dao = new TbOcorrenciaDAO();
        setOcorrencias(dao.consultarPorDsc(getDscOcorrencia()));
    }
    
    
    public void novo() {
        setSelecionado(new TbOcorrencia());
        getSelecionado().setIdtOcorrencia(0);
        getSelecionado().setDtaOcorrencia(new Date(System.currentTimeMillis()));
        setDscOcorrencia("");
    }

    public void salvar() {
        TbOcorrenciaDAO dao = new TbOcorrenciaDAO();
        if (getSelecionado().getIdtOcorrencia()== 0) {
            getSelecionado().setIdtOcorrencia(null);
            dao.incluir(getSelecionado());
        } else {
            dao.juntar(getSelecionado());
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        filtrar();
    }

    public TbOcorrencia getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(TbOcorrencia selecionado) {
        this.selecionado = selecionado;
    }

    public List<TbOcorrencia> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(List<TbOcorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    public String getDscOcorrencia() {
        return dscOcorrencia;
    }

    public void setDscOcorrencia(String dscOcorrencia) {
        this.dscOcorrencia = dscOcorrencia;
    }

    public List<TaMorador> getMoradores() {
        return moradores;
    }

    public void setMoradores(List<TaMorador> moradores) {
        this.moradores = moradores;
    }

    public TaMoradorDAO getMorDao() {
        return morDao;
    }

    public void setMorDao(TaMoradorDAO morDao) {
        this.morDao = morDao;
    }
    
    
    
}
