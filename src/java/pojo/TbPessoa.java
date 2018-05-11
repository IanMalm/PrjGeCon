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
@Table(name = "tb_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPessoa.findAll", query = "SELECT t FROM TbPessoa t")
    , @NamedQuery(name = "TbPessoa.findByIdtPessoa", query = "SELECT t FROM TbPessoa t WHERE t.idtPessoa = :idtPessoa")
    , @NamedQuery(name = "TbPessoa.findByNmePessoa", query = "SELECT t FROM TbPessoa t WHERE t.nmePessoa = :nmePessoa")
    , @NamedQuery(name = "TbPessoa.findByCpfPessoa", query = "SELECT t FROM TbPessoa t WHERE t.cpfPessoa = :cpfPessoa")
    , @NamedQuery(name = "TbPessoa.findByDtaNascPessoa", query = "SELECT t FROM TbPessoa t WHERE t.dtaNascPessoa = :dtaNascPessoa")
    , @NamedQuery(name = "TbPessoa.findByTelPessoa", query = "SELECT t FROM TbPessoa t WHERE t.telPessoa = :telPessoa")
    , @NamedQuery(name = "TbPessoa.findByEmlPessoa", query = "SELECT t FROM TbPessoa t WHERE t.emlPessoa = :emlPessoa")})
public class TbPessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idt_pessoa")
    private Integer idtPessoa;
    @Basic(optional = false)
    @Column(name = "nme_pessoa")
    private String nmePessoa;
    @Basic(optional = false)
    @Column(name = "cpf_pessoa")
    private String cpfPessoa;
    @Basic(optional = false)
    @Column(name = "dta_nasc_pessoa")
    @Temporal(TemporalType.DATE)
    private Date dtaNascPessoa;
    @Basic(optional = false)
    @Column(name = "tel_pessoa")
    private String telPessoa;
    @Basic(optional = false)
    @Column(name = "eml_pessoa")
    private String emlPessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPessoa")
    private Set<TaMorador> taMoradorSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPessoa")
    private Set<TaVisita> taVisitaSet;

    public TbPessoa() {
    }

    public TbPessoa(Integer idtPessoa) {
        this.idtPessoa = idtPessoa;
    }

    public TbPessoa(Integer idtPessoa, String nmePessoa, String cpfPessoa, Date dtaNascPessoa, String telPessoa, String emlPessoa) {
        this.idtPessoa = idtPessoa;
        this.nmePessoa = nmePessoa;
        this.cpfPessoa = cpfPessoa;
        this.dtaNascPessoa = dtaNascPessoa;
        this.telPessoa = telPessoa;
        this.emlPessoa = emlPessoa;
    }

    public Integer getIdtPessoa() {
        return idtPessoa;
    }

    public void setIdtPessoa(Integer idtPessoa) {
        this.idtPessoa = idtPessoa;
    }

    public String getNmePessoa() {
        return nmePessoa;
    }

    public void setNmePessoa(String nmePessoa) {
        this.nmePessoa = nmePessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public Date getDtaNascPessoa() {
        return dtaNascPessoa;
    }

    public void setDtaNascPessoa(Date dtaNascPessoa) {
        this.dtaNascPessoa = dtaNascPessoa;
    }

    public String getTelPessoa() {
        return telPessoa;
    }

    public void setTelPessoa(String telPessoa) {
        this.telPessoa = telPessoa;
    }

    public String getEmlPessoa() {
        return emlPessoa;
    }

    public void setEmlPessoa(String emlPessoa) {
        this.emlPessoa = emlPessoa;
    }

    @XmlTransient
    public Set<TaMorador> getTaMoradorSet() {
        return taMoradorSet;
    }

    public void setTaMoradorSet(Set<TaMorador> taMoradorSet) {
        this.taMoradorSet = taMoradorSet;
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
        hash += (idtPessoa != null ? idtPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPessoa)) {
            return false;
        }
        TbPessoa other = (TbPessoa) object;
        if ((this.idtPessoa == null && other.idtPessoa != null) || (this.idtPessoa != null && !this.idtPessoa.equals(other.idtPessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TbPessoa[ idtPessoa=" + idtPessoa + " ]";
    }
    
}
