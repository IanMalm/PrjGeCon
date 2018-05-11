/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TaMoradorDAO;
import dao.TbMensagemDAO;
import dao.TbForumDAO;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pojo.TaMorador;
import pojo.TbMensagem;
import pojo.TbForum;

/**
 *
 * @author ianmalm
 */
@ManagedBean
@ViewScoped
public class MensagemMB {
    
    private TbMensagem selecionado;
    private List<TbMensagem> mensagens;
    private String txtMensagem;
    private List<TaMorador> moradores;
    private TaMoradorDAO morDao = new TaMoradorDAO();
    private List<TbForum> foruns;
    private TbForumDAO forDao = new TbForumDAO();
    
    /**
     * Creates a new instance of VisitaMB
     */
    public MensagemMB() {
        selecionado = new TbMensagem();
        txtMensagem = "";
        filtrar();
    }
    
    public void filtrar(){
        TbMensagemDAO dao = new TbMensagemDAO();
        mensagens = dao.consultarPorTxt(txtMensagem);
        ordenar(mensagens);
        setMensagens(mensagens);
    }
    
    public void reFiltrar(){
        if(getSelecionado().getCodMorador() != null){
            setForuns(forDao.consultarForumPorCondominio(getSelecionado().getCodMorador().getCodResidencia().getCodCondominio().getIdtCondominio()));
        }
    }
    
    public void novo() {
        moradores = morDao.consultarTodos();
        setSelecionado(new TbMensagem());
        getSelecionado().setIdtMensagem(0);
        getSelecionado().setDtaMensagem(new Date(System.currentTimeMillis()));
    }

    public void salvar() {
        TbMensagemDAO dao = new TbMensagemDAO();
        if (getSelecionado().getIdtMensagem()== 0) {
            getSelecionado().setIdtMensagem(null);
            dao.incluir(getSelecionado());
        } else {
            dao.juntar(getSelecionado());
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        filtrar();
    }
    
    public void excluir() {
        TbMensagemDAO dao = new TbMensagemDAO();
        if (getSelecionado().getIdtMensagem() != 0) {
            if (dao.excluir(getSelecionado().getIdtMensagem())) {
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
    
    public void ordenar(List mensagemList){
        Collections.sort(mensagemList);
    }

    public TbMensagem getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(TbMensagem selecionado) {
        this.selecionado = selecionado;
    }

    public List<TbMensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<TbMensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public String getTxtMensagem() {
        return txtMensagem;
    }

    public void setTxtMensagem(String txtMensagem) {
        this.txtMensagem = txtMensagem;
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

    public List<TbForum> getForuns() {
        return foruns;
    }

    public void setForuns(List<TbForum> foruns) {
        this.foruns = foruns;
    }

    public TbForumDAO getForDao() {
        return forDao;
    }

    public void setForDao(TbForumDAO forDao) {
        this.forDao = forDao;
    }

    
    
}
