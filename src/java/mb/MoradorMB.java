/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TaMoradorDAO;
import dao.TbPessoaDAO;
import dao.TbResidenciaDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pojo.TaMorador;
import pojo.TbPessoa;
import pojo.TbResidencia;

/**
 *
 * @author ianmalm
 */
@ManagedBean
@ViewScoped
public class MoradorMB {
    
    private TaMorador selecionado;
    private List<TaMorador> moradores;
    private List<TbPessoa> pessoas;
    private TbPessoaDAO pesDao = new TbPessoaDAO();
    private List<TbResidencia> residencias;
    private TbResidenciaDAO resDao = new TbResidenciaDAO();

    public MoradorMB(){
        selecionado = new TaMorador();
        pessoas = pesDao.consultarPessoaNaoMorador();
        residencias = resDao.consultarResidenciaSemMorador();
    }
    
    public void salvar() {
        if(getSelecionado().getTbResidencia() == null){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Gravação", "Não foi possível gravar.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return;
        }
        TaMoradorDAO dao = new TaMoradorDAO();
        dao.incluir(getSelecionado());

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void excluir() {
        TaMoradorDAO dao = new TaMoradorDAO();
        if (getSelecionado().getIdtMorador()!= 0) {
            if (getSelecionado().getTbForums().size() > 0) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Este morador criou fóruns: " + getSelecionado().getTbPessoa().getNmePessoa()+ ".");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return;
            }else if (getSelecionado().getTbMensagems().size() > 0) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Este morador criou mensagens: " + getSelecionado().getTbPessoa().getNmePessoa()+ ".");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return;
            }else if (getSelecionado().getTbOcorrencias().size() > 0) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Este morador criou ocorrências: " + getSelecionado().getTbPessoa().getNmePessoa()+ ".");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return;
            }else if (getSelecionado().getTbUsuarios().size() > 0) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Este morador é um usuário: " + getSelecionado().getTbPessoa().getNmePessoa()+ ".");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return;
            }

            if (dao.excluir(getSelecionado().getIdtMorador())) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Exclusão", "Exclusão efetuada com sucesso.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Não foi possível excluir.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
        
    }
    
    public TaMorador getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(TaMorador selecionado) {
        this.selecionado = selecionado;
    }

    public List<TaMorador> getMoradores() {
        return moradores;
    }

    public void setMoradores(List<TaMorador> moradores) {
        this.moradores = moradores;
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
