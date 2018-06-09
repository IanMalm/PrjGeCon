/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TaMoradorDAO;
import dao.TaVisitaDAO;
import dao.TbPessoaDAO;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pojo.TaMorador;
import pojo.TaVisita;
import pojo.TbPessoa;

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
    private List<TaMorador> moradores;
    private TaMoradorDAO morDao = new TaMoradorDAO();
    private List<TbPessoa> pessoas;
    private TbPessoaDAO pesDao = new TbPessoaDAO();
    
    /**
     * Creates a new instance of VisitaMB
     */
    public VisitaMB() {
        selecionado = new TaVisita();
        nmePessoa = "";
        filtrar();
    }
    
    public void filtrar(){
        TaVisitaDAO dao = new TaVisitaDAO();
        setVisitas(dao.consultarVisitasPorNmePessoa(nmePessoa));
    }
    
    public void novo() {
        moradores = morDao.consultarTodos();
        pessoas = pesDao.consultarPessoaNaoMorador();
        setSelecionado(new TaVisita());
        getSelecionado().setIdtVisita(0);
        getSelecionado().setDtaInicioVisita(new Date(System.currentTimeMillis()));
    }

    public void salvar() {
        if (validarData()) {
            TaVisitaDAO dao = new TaVisitaDAO();
            if (getSelecionado().getIdtVisita()== 0) {
                getSelecionado().setIdtVisita(null);
                dao.incluir(getSelecionado());
            } else {
                dao.juntar(getSelecionado());
            }
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            filtrar();
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Data final da visita posterior à data inicial.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
   
    public boolean validarData() {
        Date dataFinal = getSelecionado().getDtaFinalVisita();
        Date dataInicio = getSelecionado().getDtaInicioVisita();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataInicio);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);
        dataInicio = cal.getTime();
        int comparacao = dataFinal.compareTo(dataInicio);
        if (comparacao >= 0) { // Compara as datas
            return true;
        }
        return false;
    }
    
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

    public List<TaMorador> getMoradores() {
        return moradores;
    }

    public void setMoradores(List<TaMorador> moradores) {
        this.moradores = moradores;
    }

    public TaMoradorDAO getResDao() {
        return morDao;
    }

    public void setResDao(TaMoradorDAO resDao) {
        this.morDao = resDao;
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
