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
@Table(name = "tb_residencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbResidencia.findAll", query = "SELECT t FROM TbResidencia t")
    , @NamedQuery(name = "TbResidencia.findByIdtResidencia", query = "SELECT t FROM TbResidencia t WHERE t.idtResidencia = :idtResidencia")
    , @NamedQuery(name = "TbResidencia.findByDscBlocoResidencia", query = "SELECT t FROM TbResidencia t WHERE t.dscBlocoResidencia = :dscBlocoResidencia")
    , @NamedQuery(name = "TbResidencia.findByDscResidencia", query = "SELECT t FROM TbResidencia t WHERE t.dscResidencia = :dscResidencia")})
public class TbResidencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idt_residencia")
    private Integer idtResidencia;
    @Basic(optional = false)
    @Column(name = "dsc_bloco_residencia")
    private String dscBlocoResidencia;
    @Basic(optional = false)
    @Column(name = "dsc_residencia")
    private String dscResidencia;
    @JoinColumn(name = "cod_condominio", referencedColumnName = "idt_condominio")
    @ManyToOne(optional = false)
    private TbCondominio codCondominio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codResidencia")
    private Set<TaMorador> taMoradorSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codResidencia")
    private Set<TbGaragem> tbGaragemSet;

    public TbResidencia() {
    }

    public TbResidencia(Integer idtResidencia) {
        this.idtResidencia = idtResidencia;
    }

    public TbResidencia(Integer idtResidencia, String dscBlocoResidencia, String dscResidencia) {
        this.idtResidencia = idtResidencia;
        this.dscBlocoResidencia = dscBlocoResidencia;
        this.dscResidencia = dscResidencia;
    }

    public Integer getIdtResidencia() {
        return idtResidencia;
    }

    public void setIdtResidencia(Integer idtResidencia) {
        this.idtResidencia = idtResidencia;
    }

    public String getDscBlocoResidencia() {
        return dscBlocoResidencia;
    }

    public void setDscBlocoResidencia(String dscBlocoResidencia) {
        this.dscBlocoResidencia = dscBlocoResidencia;
    }

    public String getDscResidencia() {
        return dscResidencia;
    }

    public void setDscResidencia(String dscResidencia) {
        this.dscResidencia = dscResidencia;
    }

    public TbCondominio getCodCondominio() {
        return codCondominio;
    }

    public void setCodCondominio(TbCondominio codCondominio) {
        this.codCondominio = codCondominio;
    }

    @XmlTransient
    public Set<TaMorador> getTaMoradorSet() {
        return taMoradorSet;
    }

    public void setTaMoradorSet(Set<TaMorador> taMoradorSet) {
        this.taMoradorSet = taMoradorSet;
    }

    @XmlTransient
    public Set<TbGaragem> getTbGaragemSet() {
        return tbGaragemSet;
    }

    public void setTbGaragemSet(Set<TbGaragem> tbGaragemSet) {
        this.tbGaragemSet = tbGaragemSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtResidencia != null ? idtResidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbResidencia)) {
            return false;
        }
        TbResidencia other = (TbResidencia) object;
        if ((this.idtResidencia == null && other.idtResidencia != null) || (this.idtResidencia != null && !this.idtResidencia.equals(other.idtResidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TbResidencia[ idtResidencia=" + idtResidencia + " ]";
    }
    
}
