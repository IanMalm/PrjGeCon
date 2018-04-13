/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mb;

import dao.PessoaDAO;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import pojo.TbPessoa;

/**
 *
 * @author ian.malm
 */
@ManagedBean
@ViewScoped
public class IncluirMB {
    private TbPessoa pessoa;
    /**
     * Creates a new instance of IncluirMB
     */
    public IncluirMB() {
        pessoa = new TbPessoa();
    }
    
    public void incluir() {
        PessoaDAO dao = new PessoaDAO();
        pessoa.setIdtPessoa(null);
        dao.incluir(pessoa);
        pessoa = new TbPessoa();
        
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultado da Gravação", "Atualização efetivada na base de dados.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    /**
     * @return the pessoa
     */
    public TbPessoa getPessoa() {
        return pessoa;
    }
    
    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(TbPessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
