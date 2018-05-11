/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuário
 */
@Entity
@Table(name = "ta_visita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaVisita.findAll", query = "SELECT t FROM TaVisita t")
    , @NamedQuery(name = "TaVisita.findByIdtVisita", query = "SELECT t FROM TaVisita t WHERE t.idtVisita = :idtVisita")
    , @NamedQuery(name = "TaVisita.findByDtaInicioVisita", query = "SELECT t FROM TaVisita t WHERE t.dtaInicioVisita = :dtaInicioVisita")
    , @NamedQuery(name = "TaVisita.findByDtaFinalVisita", query = "SELECT t FROM TaVisita t WHERE t.dtaFinalVisita = :dtaFinalVisita")})
public class TaVisita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idt_visita")
    private Integer idtVisita;
    @Basic(optional = false)
    @Column(name = "dta_inicio_visita")
    @Temporal(TemporalType.DATE)
    private Date dtaInicioVisita;
    @Column(name = "dta_final_visita")
    @Temporal(TemporalType.DATE)
    private Date dtaFinalVisita;
    @JoinColumn(name = "cod_morador", referencedColumnName = "idt_morador")
    @ManyToOne(optional = false)
    private TaMorador codMorador;
    @JoinColumn(name = "cod_pessoa", referencedColumnName = "idt_pessoa")
    @ManyToOne(optional = false)
    private TbPessoa codPessoa;

    public TaVisita() {
    }

    public TaVisita(Integer idtVisita) {
        this.idtVisita = idtVisita;
    }

    public TaVisita(Integer idtVisita, Date dtaInicioVisita) {
        this.idtVisita = idtVisita;
        this.dtaInicioVisita = dtaInicioVisita;
    }

    public Integer getIdtVisita() {
        return idtVisita;
    }

    public void setIdtVisita(Integer idtVisita) {
        this.idtVisita = idtVisita;
    }

    public Date getDtaInicioVisita() {
        return dtaInicioVisita;
    }

    public void setDtaInicioVisita(Date dtaInicioVisita) {
        this.dtaInicioVisita = dtaInicioVisita;
    }

    public Date getDtaFinalVisita() {
        return dtaFinalVisita;
    }

    public void setDtaFinalVisita(Date dtaFinalVisita) {
        this.dtaFinalVisita = dtaFinalVisita;
    }

    public TaMorador getCodMorador() {
        return codMorador;
    }

    public void setCodMorador(TaMorador codMorador) {
        this.codMorador = codMorador;
    }

    public TbPessoa getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(TbPessoa codPessoa) {
        this.codPessoa = codPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtVisita != null ? idtVisita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaVisita)) {
            return false;
        }
        TaVisita other = (TaVisita) object;
        if ((this.idtVisita == null && other.idtVisita != null) || (this.idtVisita != null && !this.idtVisita.equals(other.idtVisita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TaVisita[ idtVisita=" + idtVisita + " ]";
    }
    
}
