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
import javax.persistence.Lob;
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
@Table(name = "tb_condominio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCondominio.findAll", query = "SELECT t FROM TbCondominio t")
    , @NamedQuery(name = "TbCondominio.findByIdtCondominio", query = "SELECT t FROM TbCondominio t WHERE t.idtCondominio = :idtCondominio")
    , @NamedQuery(name = "TbCondominio.findByNmeCondominio", query = "SELECT t FROM TbCondominio t WHERE t.nmeCondominio = :nmeCondominio")})
public class TbCondominio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idt_condominio")
    private Integer idtCondominio;
    @Basic(optional = false)
    @Column(name = "nme_condominio")
    private String nmeCondominio;
    @Basic(optional = false)
    @Lob
    @Column(name = "dsc_local_condominio")
    private String dscLocalCondominio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCondominio")
    private Set<TbResidencia> tbResidenciaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCondominio")
    private Set<TbAreaLazer> tbAreaLazerSet;

    public TbCondominio() {
    }

    public TbCondominio(Integer idtCondominio) {
        this.idtCondominio = idtCondominio;
    }

    public TbCondominio(Integer idtCondominio, String nmeCondominio, String dscLocalCondominio) {
        this.idtCondominio = idtCondominio;
        this.nmeCondominio = nmeCondominio;
        this.dscLocalCondominio = dscLocalCondominio;
    }

    public Integer getIdtCondominio() {
        return idtCondominio;
    }

    public void setIdtCondominio(Integer idtCondominio) {
        this.idtCondominio = idtCondominio;
    }

    public String getNmeCondominio() {
        return nmeCondominio;
    }

    public void setNmeCondominio(String nmeCondominio) {
        this.nmeCondominio = nmeCondominio;
    }

    public String getDscLocalCondominio() {
        return dscLocalCondominio;
    }

    public void setDscLocalCondominio(String dscLocalCondominio) {
        this.dscLocalCondominio = dscLocalCondominio;
    }

    @XmlTransient
    public Set<TbResidencia> getTbResidenciaSet() {
        return tbResidenciaSet;
    }

    public void setTbResidenciaSet(Set<TbResidencia> tbResidenciaSet) {
        this.tbResidenciaSet = tbResidenciaSet;
    }

    @XmlTransient
    public Set<TbAreaLazer> getTbAreaLazerSet() {
        return tbAreaLazerSet;
    }

    public void setTbAreaLazerSet(Set<TbAreaLazer> tbAreaLazerSet) {
        this.tbAreaLazerSet = tbAreaLazerSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtCondominio != null ? idtCondominio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCondominio)) {
            return false;
        }
        TbCondominio other = (TbCondominio) object;
        if ((this.idtCondominio == null && other.idtCondominio != null) || (this.idtCondominio != null && !this.idtCondominio.equals(other.idtCondominio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TbCondominio[ idtCondominio=" + idtCondominio + " ]";
    }
    
}
