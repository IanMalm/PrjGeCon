/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuário
 */
@Entity
@Table(name = "tb_garagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbGaragem.findAll", query = "SELECT t FROM TbGaragem t")
    , @NamedQuery(name = "TbGaragem.findByIdtGaragem", query = "SELECT t FROM TbGaragem t WHERE t.idtGaragem = :idtGaragem")
    , @NamedQuery(name = "TbGaragem.findByDscGaragem", query = "SELECT t FROM TbGaragem t WHERE t.dscGaragem = :dscGaragem")})
public class TbGaragem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idt_garagem")
    private Integer idtGaragem;
    @Basic(optional = false)
    @Column(name = "dsc_garagem")
    private String dscGaragem;
    @JoinColumn(name = "cod_residencia", referencedColumnName = "idt_residencia")
    @ManyToOne(optional = false)
    private TbResidencia codResidencia;

    public TbGaragem() {
    }

    public TbGaragem(Integer idtGaragem) {
        this.idtGaragem = idtGaragem;
    }

    public TbGaragem(Integer idtGaragem, String dscGaragem) {
        this.idtGaragem = idtGaragem;
        this.dscGaragem = dscGaragem;
    }

    public Integer getIdtGaragem() {
        return idtGaragem;
    }

    public void setIdtGaragem(Integer idtGaragem) {
        this.idtGaragem = idtGaragem;
    }

    public String getDscGaragem() {
        return dscGaragem;
    }

    public void setDscGaragem(String dscGaragem) {
        this.dscGaragem = dscGaragem;
    }

    public TbResidencia getCodResidencia() {
        return codResidencia;
    }

    public void setCodResidencia(TbResidencia codResidencia) {
        this.codResidencia = codResidencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtGaragem != null ? idtGaragem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbGaragem)) {
            return false;
        }
        TbGaragem other = (TbGaragem) object;
        if ((this.idtGaragem == null && other.idtGaragem != null) || (this.idtGaragem != null && !this.idtGaragem.equals(other.idtGaragem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TbGaragem[ idtGaragem=" + idtGaragem + " ]";
    }
    
}
