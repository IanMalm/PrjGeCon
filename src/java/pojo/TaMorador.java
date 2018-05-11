/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuário
 */
@Entity
@Table(name = "ta_morador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaMorador.findAll", query = "SELECT t FROM TaMorador t")
    , @NamedQuery(name = "TaMorador.findByIdtMorador", query = "SELECT t FROM TaMorador t WHERE t.idtMorador = :idtMorador")})
public class TaMorador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idt_morador")
    private Integer idtMorador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMorador")
    private Set<TbUsuario> tbUsuarioSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMorador")
    private Set<TbForum> tbForumSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMorador")
    private Set<TbOcorrencia> tbOcorrenciaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMorador")
    private Set<TbMensagem> tbMensagemSet;
    @JoinColumn(name = "cod_pessoa", referencedColumnName = "idt_pessoa")
    @ManyToOne(optional = false)
    private TbPessoa codPessoa;
    @JoinColumn(name = "cod_residencia", referencedColumnName = "idt_residencia")
    @ManyToOne(optional = false)
    private TbResidencia codResidencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMorador")
    private Set<TaReserva> taReservaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMorador")
    private Set<TaVisita> taVisitaSet;

    public TaMorador() {
    }

    public TaMorador(Integer idtMorador) {
        this.idtMorador = idtMorador;
    }

    public Integer getIdtMorador() {
        return idtMorador;
    }

    public void setIdtMorador(Integer idtMorador) {
        this.idtMorador = idtMorador;
    }

    @XmlTransient
    public Set<TbUsuario> getTbUsuarioSet() {
        return tbUsuarioSet;
    }

    public void setTbUsuarioSet(Set<TbUsuario> tbUsuarioSet) {
        this.tbUsuarioSet = tbUsuarioSet;
    }

    @XmlTransient
    public Set<TbForum> getTbForumSet() {
        return tbForumSet;
    }

    public void setTbForumSet(Set<TbForum> tbForumSet) {
        this.tbForumSet = tbForumSet;
    }

    @XmlTransient
    public Set<TbOcorrencia> getTbOcorrenciaSet() {
        return tbOcorrenciaSet;
    }

    public void setTbOcorrenciaSet(Set<TbOcorrencia> tbOcorrenciaSet) {
        this.tbOcorrenciaSet = tbOcorrenciaSet;
    }

    @XmlTransient
    public Set<TbMensagem> getTbMensagemSet() {
        return tbMensagemSet;
    }

    public void setTbMensagemSet(Set<TbMensagem> tbMensagemSet) {
        this.tbMensagemSet = tbMensagemSet;
    }

    public TbPessoa getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(TbPessoa codPessoa) {
        this.codPessoa = codPessoa;
    }

    public TbResidencia getCodResidencia() {
        return codResidencia;
    }

    public void setCodResidencia(TbResidencia codResidencia) {
        this.codResidencia = codResidencia;
    }

    @XmlTransient
    public Set<TaReserva> getTaReservaSet() {
        return taReservaSet;
    }

    public void setTaReservaSet(Set<TaReserva> taReservaSet) {
        this.taReservaSet = taReservaSet;
    }

    @XmlTransient
    public Set<TaVisita> getTaVisitaSet() {
        return taVisitaSet;
    }

    public void setTaVisitaSet(Set<TaVisita> taVisitaSet) {
        this.taVisitaSet = taVisitaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtMorador != null ? idtMorador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaMorador)) {
            return false;
        }
        TaMorador other = (TaMorador) object;
        if ((this.idtMorador == null && other.idtMorador != null) || (this.idtMorador != null && !this.idtMorador.equals(other.idtMorador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TaMorador[ idtMorador=" + idtMorador + " ]";
    }
    
}
