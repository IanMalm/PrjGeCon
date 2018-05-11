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
@Table(name = "tb_area_lazer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAreaLazer.findAll", query = "SELECT t FROM TbAreaLazer t")
    , @NamedQuery(name = "TbAreaLazer.findByIdtAreaLazer", query = "SELECT t FROM TbAreaLazer t WHERE t.idtAreaLazer = :idtAreaLazer")
    , @NamedQuery(name = "TbAreaLazer.findByDscAreaLazer", query = "SELECT t FROM TbAreaLazer t WHERE t.dscAreaLazer = :dscAreaLazer")
    , @NamedQuery(name = "TbAreaLazer.findByCapMaxAreaLazer", query = "SELECT t FROM TbAreaLazer t WHERE t.capMaxAreaLazer = :capMaxAreaLazer")
    , @NamedQuery(name = "TbAreaLazer.findByVlrReservaAreaLazer", query = "SELECT t FROM TbAreaLazer t WHERE t.vlrReservaAreaLazer = :vlrReservaAreaLazer")})
public class TbAreaLazer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idt_area_lazer")
    private Integer idtAreaLazer;
    @Basic(optional = false)
    @Column(name = "dsc_area_lazer")
    private String dscAreaLazer;
    @Basic(optional = false)
    @Column(name = "cap_max_area_lazer")
    private int capMaxAreaLazer;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vlr_reserva_area_lazer")
    private Double vlrReservaAreaLazer;
    @JoinColumn(name = "cod_condominio", referencedColumnName = "idt_condominio")
    @ManyToOne(optional = false)
    private TbCondominio codCondominio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codAreaLazer")
    private Set<TaReserva> taReservaSet;

    public TbAreaLazer() {
    }

    public TbAreaLazer(Integer idtAreaLazer) {
        this.idtAreaLazer = idtAreaLazer;
    }

    public TbAreaLazer(Integer idtAreaLazer, String dscAreaLazer, int capMaxAreaLazer) {
        this.idtAreaLazer = idtAreaLazer;
        this.dscAreaLazer = dscAreaLazer;
        this.capMaxAreaLazer = capMaxAreaLazer;
    }

    public Integer getIdtAreaLazer() {
        return idtAreaLazer;
    }

    public void setIdtAreaLazer(Integer idtAreaLazer) {
        this.idtAreaLazer = idtAreaLazer;
    }

    public String getDscAreaLazer() {
        return dscAreaLazer;
    }

    public void setDscAreaLazer(String dscAreaLazer) {
        this.dscAreaLazer = dscAreaLazer;
    }

    public int getCapMaxAreaLazer() {
        return capMaxAreaLazer;
    }

    public void setCapMaxAreaLazer(int capMaxAreaLazer) {
        this.capMaxAreaLazer = capMaxAreaLazer;
    }

    public Double getVlrReservaAreaLazer() {
        return vlrReservaAreaLazer;
    }

    public void setVlrReservaAreaLazer(Double vlrReservaAreaLazer) {
        this.vlrReservaAreaLazer = vlrReservaAreaLazer;
    }

    public TbCondominio getCodCondominio() {
        return codCondominio;
    }

    public void setCodCondominio(TbCondominio codCondominio) {
        this.codCondominio = codCondominio;
    }

    @XmlTransient
    public Set<TaReserva> getTaReservaSet() {
        return taReservaSet;
    }

    public void setTaReservaSet(Set<TaReserva> taReservaSet) {
        this.taReservaSet = taReservaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtAreaLazer != null ? idtAreaLazer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAreaLazer)) {
            return false;
        }
        TbAreaLazer other = (TbAreaLazer) object;
        if ((this.idtAreaLazer == null && other.idtAreaLazer != null) || (this.idtAreaLazer != null && !this.idtAreaLazer.equals(other.idtAreaLazer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TbAreaLazer[ idtAreaLazer=" + idtAreaLazer + " ]";
    }
    
}
