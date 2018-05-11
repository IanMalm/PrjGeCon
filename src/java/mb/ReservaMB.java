/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TaMoradorDAO;
import dao.TaReservaDAO;
import dao.TbAreaLazerDAO;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pojo.TaMorador;
import pojo.TaReserva;
import pojo.TbAreaLazer;

/**
 *
 * @author ianmalm
 */
@ManagedBean
@ViewScoped
public class ReservaMB {
    
    private TaReserva selecionado;
    private List<TaReserva> reservas;
    private String nmeMorador;
    private List<TaMorador> moradores;
    private TaMoradorDAO morDao = new TaMoradorDAO();
    private List<TbAreaLazer> areas;
    private TbAreaLazerDAO areDao = new TbAreaLazerDAO();
    
    /**
     * Creates a new instance of VisitaMB
     */
    public ReservaMB() {
        selecionado = new TaReserva();
        nmeMorador = "";
        filtrar();
    }
    
    public void filtrar(){
        TaReservaDAO dao = new TaReservaDAO();
        setReservas(dao.consultarReservaPorNomeMorador(nmeMorador));
    }
    
    public void reFiltrar(){
        if(getSelecionado().getCodMorador() != null){
            setAreas(areDao.consultarAreaPorCondominio(getSelecionado().getCodMorador().getCodResidencia().getCodCondominio().getIdtCondominio()));
        }
    }
    
    public void novo() {
        moradores = morDao.consultarTodos();
        setSelecionado(new TaReserva());
        getSelecionado().setIdtReserva(0);
        getSelecionado().setDtaCadastroReserva(new Date(System.currentTimeMillis()));
    }

    public void salvar() {
        TaReservaDAO dao = new TaReservaDAO();
        if (getSelecionado().getIdtReserva()== 0) {
            getSelecionado().setIdtReserva(null);
            dao.incluir(getSelecionado());
        } else {
            dao.juntar(getSelecionado());
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        filtrar();
    }
    
    public void excluir() {
        TaReservaDAO dao = new TaReservaDAO();
        if (getSelecionado().getIdtReserva()!= 0) {
            if (dao.excluir(getSelecionado().getIdtReserva())) {
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

    public TaReserva getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(TaReserva selecionado) {
        this.selecionado = selecionado;
    }

    public List<TaReserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<TaReserva> reservas) {
        this.reservas = reservas;
    }

    public String getNmeMorador() {
        return nmeMorador;
    }

    public void setNmeMorador(String nmeMorador) {
        this.nmeMorador = nmeMorador;
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

    public List<TbAreaLazer> getAreas() {
        return areas;
    }

    public void setAreas(List<TbAreaLazer> areas) {
        this.areas = areas;
    }

    public TbAreaLazerDAO getAreDao() {
        return areDao;
    }

    public void setAreDao(TbAreaLazerDAO areDao) {
        this.areDao = areDao;
    }    
}

