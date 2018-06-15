/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TaMoradorDAO;
import dao.TbForumDAO;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pojo.TaMorador;
import pojo.TbForum;

/**
 *
 * @author ianmalm
 */
@ManagedBean
@ViewScoped
public class ForumMB {
    
    private TbForum selecionado;
    private List<TbForum> foruns;
    private String titForum;
    private List<TaMorador> moradores;
    private TaMoradorDAO morDao = new TaMoradorDAO();
    
    /**
     * Creates a new instance of ForumMB
     */
    public ForumMB() {
        selecionado = new TbForum();
        titForum = "";
        moradores = morDao.consultarTodos();
        filtrar();
    }
    
    public void filtrar(){
        TbForumDAO dao = new TbForumDAO();
        foruns = dao.consultarPorTit(titForum);
        ordenar(foruns);
        setForuns(foruns);
    }
    
    
    public void novo() {
        setSelecionado(new TbForum());
        getSelecionado().setIdtForum(0);
        getSelecionado().setDtaCadastroForum(new Date(System.currentTimeMillis()));
    }

    public void salvar() {
        if(getSelecionado().getTaMorador() == null){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Gravação", "Não foi possível gravar.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return;
        }
        TbForumDAO dao = new TbForumDAO();
        if (getSelecionado().getIdtForum()== 0) {
            getSelecionado().setIdtForum(null);
            dao.incluir(getSelecionado());
        } else {
            dao.juntar(getSelecionado());
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        filtrar();
    }
    
    public void excluir(){
        TbForumDAO dao = new TbForumDAO();
        if(getSelecionado().getIdtForum()!= 0){
            if (getSelecionado().getTbMensagems().size() > 0){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Este fórum possui mensagem(ns): " + getSelecionado().getTitForum()+ ".");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return;
            }

        if (dao.excluir(getSelecionado().getIdtForum())) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Exclusão", "Exclusão efetuada com sucesso.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Não foi possível excluir.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
        filtrar();
    }
    
    public void ordenar(List forumList){
        Collections.sort(forumList);
    }

    public TbForum getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(TbForum selecionado) {
        this.selecionado = selecionado;
    }

    public List<TbForum> getForuns() {
        return foruns;
    }

    public void setForuns(List<TbForum> foruns) {
        this.foruns = foruns;
    }

    public String getTitForum() {
        return titForum;
    }

    public void setTitForum(String titForum) {
        this.titForum = titForum;
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
