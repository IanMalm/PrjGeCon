/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mb;

import dao.TbPessoaDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import pojo.TbPessoa;

/**
 *
 * @author ian.malm
 */
@ManagedBean
@ViewScoped
public class ConsultarMB {
    
    private TbPessoa pessoa;
    private String nome;
    
    /**
     * Creates a new instance of ConsultarMB
     */
    public ConsultarMB() {
        
        pessoa = new TbPessoa();
        
    }
    
    public void consultar() {
        TbPessoaDAO dao = new TbPessoaDAO();
        List<TbPessoa> lista = dao.consultarPorNme(nome);
        
        if(!lista.isEmpty()){
            pessoa = lista.get(0);
        }
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

    /**
     * @return the nmeCliente
     */
    public String getNmeCliente() {
        return nome;
    }

    /**
     * @param nmeCliente the nmeCliente to set
     */
    public void setNmeCliente(String nmeCliente) {
        this.nome = nmeCliente;
    }
    
    
}
