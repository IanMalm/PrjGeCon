/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TaVisitaDAO;
import dao.TbPessoaDAO;
import dao.TbResidenciaDAO;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pojo.TaVisita;
import pojo.TbPessoa;
import pojo.TbResidencia;

/**
 *
 * @author ianmalm
 */
@ManagedBean
@ViewScoped
public class VisitaMB {
    
    private TaVisita selecionado;
    private List<TaVisita> visitas;
    private String nmePessoa;
    private List<TbResidencia> residencias;
    private TbResidenciaDAO resDao = new TbResidenciaDAO();
    private List<TbPessoa> pessoas;
    private TbPessoaDAO pesDao = new TbPessoaDAO();
    
    /**
     * Creates a new instance of VisitaMB
     */
    public VisitaMB() {
        selecionado = new TaVisita();
        nmePessoa = "";
        residencias = resDao.consultarResidenciaComMorador();
        pessoas = pesDao.consultarPessoaMorador();
        //filtrar();
    }
    
    //TODO

    public TaVisita getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(TaVisita selecionado) {
        this.selecionado = selecionado;
    }

    public List<TaVisita> getVisitas() {
        return visitas;
    }

    public void setVisitas(List<TaVisita> visitas) {
        this.visitas = visitas;
    }

    public String getNmePessoa() {
        return nmePessoa;
    }

    public void setNmePessoa(String nmePessoa) {
        this.nmePessoa = nmePessoa;
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

    public List<TbPessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<TbPessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public TbPessoaDAO getPesDao() {
        return pesDao;
    }

    public void setPesDao(TbPessoaDAO pesDao) {
        this.pesDao = pesDao;
    }

    
    
    
}
