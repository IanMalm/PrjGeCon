/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TdPerfilDAO;
import dao.TbPessoaDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pojo.TbPessoa;
import pojo.TdPerfil;

/**
 *
 * @author Hiragi
 */
@ManagedBean
@ViewScoped
public class PessoaMB {

    private TbPessoa selecionado;
    private List<TbPessoa> pessoas;
    private String nmePessoa;
    private List<TdPerfil> perfis;

    /**
     * Creates a new instance of ProdutoMB
     */
    public PessoaMB() {
        selecionado = new TbPessoa();
        nmePessoa = "";
        filtrar();
    }

    public void filtrar() {
        TbPessoaDAO dao = new TbPessoaDAO();
        setPessoas(dao.consultarPorNme(getNmePessoa()));
        TdPerfilDAO dao1 = new TdPerfilDAO();
        setPerfis(dao1.consultarTodos());
    }

    public void novo() {
        setSelecionado(new TbPessoa());
        getSelecionado().setIdtPessoa(0);
        setNmePessoa("");
        getSelecionado().setFlagMoradorPessoa(false);
    }

    public void salvar() {
        TbPessoaDAO dao = new TbPessoaDAO();
        if (getSelecionado().getIdtPessoa() == 0) {
            getSelecionado().setIdtPessoa(null);
            dao.incluir(getSelecionado());
        } else {
            dao.juntar(getSelecionado());
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        filtrar();
    }

    public void excluir() {
        TbPessoaDAO dao = new TbPessoaDAO();
        if (getSelecionado().getIdtPessoa() != 0) {
            if (getSelecionado().getTbMensagems().size() > 0) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Existem Mensagens associadas não podemos excluir: " + getSelecionado().getNmePessoa()+ ".");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return;
            }

            if (dao.excluir(getSelecionado().getIdtPessoa())) {
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

    /**
     * @return the selecionado
     */
    public TbPessoa getSelecionado() {
        return selecionado;
    }

    /**
     * @param selecionado the selecionado to set
     */
    public void setSelecionado(TbPessoa selecionado) {
        this.selecionado = selecionado;
    }

    /**
     * @return the pessoas
     */
    public List<TbPessoa> getPessoas() {
        return pessoas;
    }

    /**
     * @param pessoas the pessoas to set
     */
    public void setPessoas(List<TbPessoa> pessoas) {
        this.pessoas = pessoas;
    }

    /**
     * @return the nmePessoa
     */
    public String getNmePessoa() {
        return nmePessoa;
    }

    /**
     * @param nmePessoa the nmePessoa to set
     */
    public void setNmePessoa(String nmePessoa) {
        this.nmePessoa = nmePessoa;
    }

    /**
     * @return the pessoas
     */
    public List<TdPerfil> getPerfis() {
        return perfis;
    }

    /**
     * @param pessoas the pessoas to set
     */
    public void setPerfis(List<TdPerfil> perfis) {
        this.perfis = perfis;
    }
    
}
