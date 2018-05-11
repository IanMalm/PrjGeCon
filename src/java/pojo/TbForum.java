/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuário
 */
@Entity
@Table(name = "tb_forum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbForum.findAll", query = "SELECT t FROM TbForum t")
    , @NamedQuery(name = "TbForum.findByIdtForum", query = "SELECT t FROM TbForum t WHERE t.idtForum = :idtForum")
    , @NamedQuery(name = "TbForum.findByTitForum", query = "SELECT t FROM TbForum t WHERE t.titForum = :titForum")
    , @NamedQuery(name = "TbForum.findByDtaCadastroForum", query = "SELECT t FROM TbForum t WHERE t.dtaCadastroForum = :dtaCadastroForum")})
public class TbForum implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idt_forum")
    private Integer idtForum;
    @Basic(optional = false)
    @Column(name = "tit_forum")
    private String titForum;
    @Basic(optional = false)
    @Lob
    @Column(name = "dsc_forum")
    private String dscForum;
    @Basic(optional = false)
    @Column(name = "dta_cadastro_forum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtaCadastroForum;
    @JoinColumn(name = "cod_morador", referencedColumnName = "idt_morador")
    @ManyToOne(optional = false)
    private TaMorador codMorador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codForum")
    private Set<TbMensagem> tbMensagemSet;

    public TbForum() {
    }

    public TbForum(Integer idtForum) {
        this.idtForum = idtForum;
    }

    public TbForum(Integer idtForum, String titForum, String dscForum, Date dtaCadastroForum) {
        this.idtForum = idtForum;
        this.titForum = titForum;
        this.dscForum = dscForum;
        this.dtaCadastroForum = dtaCadastroForum;
    }

    public Integer getIdtForum() {
        return idtForum;
    }

    public void setIdtForum(Integer idtForum) {
        this.idtForum = idtForum;
    }

    public String getTitForum() {
        return titForum;
    }

    public void setTitForum(String titForum) {
        this.titForum = titForum;
    }

    public String getDscForum() {
        return dscForum;
    }

    public void setDscForum(String dscForum) {
        this.dscForum = dscForum;
    }

    public Date getDtaCadastroForum() {
        return dtaCadastroForum;
    }

    public void setDtaCadastroForum(Date dtaCadastroForum) {
        this.dtaCadastroForum = dtaCadastroForum;
    }

    public TaMorador getCodMorador() {
        return codMorador;
    }

    public void setCodMorador(TaMorador codMorador) {
        this.codMorador = codMorador;
    }

    @XmlTransient
    public Set<TbMensagem> getTbMensagemSet() {
        return tbMensagemSet;
    }

    public void setTbMensagemSet(Set<TbMensagem> tbMensagemSet) {
        this.tbMensagemSet = tbMensagemSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtForum != null ? idtForum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbForum)) {
            return false;
        }
        TbForum other = (TbForum) object;
        if ((this.idtForum == null && other.idtForum != null) || (this.idtForum != null && !this.idtForum.equals(other.idtForum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TbForum[ idtForum=" + idtForum + " ]";
    }
    
}
