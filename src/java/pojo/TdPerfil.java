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
@Table(name = "td_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TdPerfil.findAll", query = "SELECT t FROM TdPerfil t")
    , @NamedQuery(name = "TdPerfil.findByIdtPerfil", query = "SELECT t FROM TdPerfil t WHERE t.idtPerfil = :idtPerfil")
    , @NamedQuery(name = "TdPerfil.findByNmePerfil", query = "SELECT t FROM TdPerfil t WHERE t.nmePerfil = :nmePerfil")})
public class TdPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idt_perfil")
    private Integer idtPerfil;
    @Basic(optional = false)
    @Column(name = "nme_perfil")
    private String nmePerfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPerfil")
    private Set<TbUsuario> tbUsuarioSet;

    public TdPerfil() {
    }

    public TdPerfil(Integer idtPerfil) {
        this.idtPerfil = idtPerfil;
    }

    public TdPerfil(Integer idtPerfil, String nmePerfil) {
        this.idtPerfil = idtPerfil;
        this.nmePerfil = nmePerfil;
    }

    public Integer getIdtPerfil() {
        return idtPerfil;
    }

    public void setIdtPerfil(Integer idtPerfil) {
        this.idtPerfil = idtPerfil;
    }

    public String getNmePerfil() {
        return nmePerfil;
    }

    public void setNmePerfil(String nmePerfil) {
        this.nmePerfil = nmePerfil;
    }

    @XmlTransient
    public Set<TbUsuario> getTbUsuarioSet() {
        return tbUsuarioSet;
    }

    public void setTbUsuarioSet(Set<TbUsuario> tbUsuarioSet) {
        this.tbUsuarioSet = tbUsuarioSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtPerfil != null ? idtPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TdPerfil)) {
            return false;
        }
        TdPerfil other = (TdPerfil) object;
        if ((this.idtPerfil == null && other.idtPerfil != null) || (this.idtPerfil != null && !this.idtPerfil.equals(other.idtPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TdPerfil[ idtPerfil=" + idtPerfil + " ]";
    }
    
}
