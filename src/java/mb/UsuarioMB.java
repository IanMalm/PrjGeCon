/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TaMoradorDAO;
import dao.TbUsuarioDAO;
import dao.TdPerfilDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pojo.TaMorador;
import pojo.TbUsuario;
import pojo.TdPerfil;

/**
 *
 * @author ianmalm
 */
@ManagedBean
@ViewScoped
public class UsuarioMB {
    
    private TbUsuario selecionado;
    private List<TbUsuario> usuarios;
    private String nmeUsuario;
    private List<TaMorador> moradores;
    private TaMoradorDAO morDao = new TaMoradorDAO();
    private List<TdPerfil> perfis;
    private TdPerfilDAO perDao = new TdPerfilDAO();
    
    /**
     * Creates a new instance of VisitaMB
     */
    public UsuarioMB() {
        selecionado = new TbUsuario();
        nmeUsuario = "";
        filtrar();
    }
    
    public void filtrar(){
        TbUsuarioDAO dao = new TbUsuarioDAO();
        setUsuarios(dao.consultarTodos());
    }
    
    public void novo() {
        moradores = morDao.consultarMoradorNaoUsuario();
        perfis = perDao.consultarTodos();
        setSelecionado(new TbUsuario());
        getSelecionado().setIdtUsuario(0);
    }

    public void salvar() {
        TbUsuarioDAO dao = new TbUsuarioDAO();
        if (getSelecionado().getIdtUsuario()== 0) {
            getSelecionado().setIdtUsuario(null);
            dao.incluir(getSelecionado());
        } else {
            dao.juntar(getSelecionado());
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        filtrar();
    }
    
    public void excluir() {
        TbUsuarioDAO dao = new TbUsuarioDAO();
        if (getSelecionado().getIdtUsuario() != 0) {
            if (dao.excluir(getSelecionado().getIdtUsuario())) {
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

    public TbUsuario getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(TbUsuario selecionado) {
        this.selecionado = selecionado;
    }

    public List<TbUsuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<TbUsuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getNmeUsuario() {
        return nmeUsuario;
    }

    public void setNmeUsuario(String nmeUsuario) {
        this.nmeUsuario = nmeUsuario;
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

    public List<TdPerfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<TdPerfil> perfis) {
        this.perfis = perfis;
    }

    public TdPerfilDAO getPerDao() {
        return perDao;
    }

    public void setPerDao(TdPerfilDAO perDao) {
        this.perDao = perDao;
    }
    

    
}
