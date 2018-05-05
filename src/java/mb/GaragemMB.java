/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TbResidenciaDAO;
import dao.TbGaragemDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pojo.TbResidencia;
import pojo.TbGaragem;

/**
 *
 * @author ian.malm
 */
@ManagedBean
@ViewScoped
public class GaragemMB {

    private TbGaragem selecionado;
    private List<TbGaragem> garagens;
    private String dscGaragem;
    private List<TbResidencia> residencias;
    private TbResidenciaDAO resDao = new TbResidenciaDAO();
    
    /**
     * Creates a new instance of ResidenciaMB
     */
    public GaragemMB() {
        selecionado = new TbGaragem();
        dscGaragem = "";
        residencias = resDao.consultarTodos();
        filtrar();
    }
    
    public void filtrar(){
        TbGaragemDAO dao = new TbGaragemDAO();
        setGaragens(dao.consultarPorDsc(getDscGaragem()));
    }
    
    
    public void novo() {
        setSelecionado(new TbGaragem());
        getSelecionado().setIdtGaragem(0);
        setDscGaragem("");
    }

    public void salvar() {
        TbGaragemDAO dao = new TbGaragemDAO();
        if (getSelecionado().getIdtGaragem()== 0) {
            getSelecionado().setIdtGaragem(null);
            dao.incluir(getSelecionado());
        } else {
            dao.juntar(getSelecionado());
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        filtrar();
    }

    public void excluir() {
        TbGaragemDAO dao = new TbGaragemDAO();
        if (getSelecionado().getIdtGaragem()!= 0) {
            
            if (dao.excluir(getSelecionado().getIdtGaragem())) {
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

    public TbGaragem getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(TbGaragem selecionado) {
        this.selecionado = selecionado;
    }

    public List<TbGaragem> getGaragens() {
        return garagens;
    }

    public void setGaragens(List<TbGaragem> garagens) {
        this.garagens = garagens;
    }

    public String getDscGaragem() {
        return dscGaragem;
    }

    public void setDscGaragem(String dscGaragem) {
        this.dscGaragem = dscGaragem;
    }

    public List<TbResidencia> getResidencias() {
        return residencias;
    }

    public void setResidencias(List<TbResidencia> residencias) {
        this.residencias = residencias;
    }

    public TbResidenciaDAO getResDao() {
        return resDao;
    }

    public void setResDao(TbResidenciaDAO resDao) {
        this.resDao = resDao;
    }


    
}
