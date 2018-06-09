/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.TbPessoaDAO;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pojo.TbPessoa;

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
    }

    public void novo() {
        setSelecionado(new TbPessoa());
        getSelecionado().setIdtPessoa(0);
        setNmePessoa("");
    }

    public void salvar() {
        if (validarNome() && validarEmail() && validarTelefone() && validarDataNascimento()) {
            TbPessoaDAO dao = new TbPessoaDAO();
            int idt = getSelecionado().getIdtPessoa();
            if (idt == 0) {
                getSelecionado().setIdtPessoa(null);
                dao.incluir(getSelecionado());
            } else {
                dao.juntar(getSelecionado());
            }
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Cadastro não efetuado, dados inválidos foram inseridos.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        filtrar();
    }

    public void excluir() {
        TbPessoaDAO dao = new TbPessoaDAO();
        if (getSelecionado().getIdtPessoa() != 0) {
            if (getSelecionado().getTaMoradors().size() > 0) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Esta pessoa é um(a) morador(a): " + getSelecionado().getNmePessoa()+ ".");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return;
            } else if (getSelecionado().getTaVisitas().size() > 0) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resultado da Exclusão", "Esta pessoa é um(a) visitante: " + getSelecionado().getNmePessoa()+ ".");
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

    public boolean validarEmail(){
        Pattern expressaoRegular = Pattern.compile("@");
        Matcher match = expressaoRegular.matcher(getSelecionado().getEmlPessoa());
        
        if (match.find()) {
            System.out.println(match.find());
            expressaoRegular = Pattern.compile(".");
            match = expressaoRegular.matcher(getSelecionado().getEmlPessoa());
        }
        System.out.println(match.find());
        return match.find();
    }
    
    public boolean validarTelefone(){
        String telefone = getSelecionado().getTelPessoa();
        Pattern expressaoRegular = Pattern.compile( "^([0-9]{7,})$");
        Matcher match = expressaoRegular.matcher(telefone);
       
        boolean resultado = match.find();
        return resultado;
    }
    
    public boolean validarDataNascimento() {
        Date data = getSelecionado().getDtaNascPessoa();
        if (data.compareTo(new Date()) >= 0) { // Compara com a data de hoje
            return false;
        }
        return true;
    }
    
    public boolean validarNome(){
        Pattern expressaoRegular = Pattern.compile( "[0-9]");
        Matcher match = expressaoRegular.matcher(getSelecionado().getNmePessoa());
        
        return !match.find();
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
    
}
