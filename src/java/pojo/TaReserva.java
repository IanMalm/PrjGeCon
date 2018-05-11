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
@Table(name = "ta_reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaReserva.findAll", query = "SELECT t FROM TaReserva t")
    , @NamedQuery(name = "TaReserva.findByIdtReserva", query = "SELECT t FROM TaReserva t WHERE t.idtReserva = :idtReserva")
    , @NamedQuery(name = "TaReserva.findByDtaInicioReserva", query = "SELECT t FROM TaReserva t WHERE t.dtaInicioReserva = :dtaInicioReserva")
    , @NamedQuery(name = "TaReserva.findByDtaFimReserva", query = "SELECT t FROM TaReserva t WHERE t.dtaFimReserva = :dtaFimReserva")
    , @NamedQuery(name = "TaReserva.findByDtaCadastroReserva", query = "SELECT t FROM TaReserva t WHERE t.dtaCadastroReserva = :dtaCadastroReserva")
    , @NamedQuery(name = "TaReserva.findByStsConfirmadoReserva", query = "SELECT t FROM TaReserva t WHERE t.stsConfirmadoReserva = :stsConfirmadoReserva")})
public class TaReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idt_reserva")
    private Integer idtReserva;
    @Basic(optional = false)
    @Column(name = "dta_inicio_reserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtaInicioReserva;
    @Basic(optional = false)
    @Column(name = "dta_fim_reserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtaFimReserva;
    @Basic(optional = false)
    @Column(name = "dta_cadastro_reserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtaCadastroReserva;
    @Basic(optional = false)
    @Column(name = "sts_confirmado_reserva")
    private Character stsConfirmadoReserva;
    @JoinColumn(name = "cod_morador", referencedColumnName = "idt_morador")
    @ManyToOne(optional = false)
    private TaMorador codMorador;
    @JoinColumn(name = "cod_area_lazer", referencedColumnName = "idt_area_lazer")
    @ManyToOne(optional = false)
    private TbAreaLazer codAreaLazer;

    public TaReserva() {
    }

    public TaReserva(Integer idtReserva) {
        this.idtReserva = idtReserva;
    }

    public TaReserva(Integer idtReserva, Date dtaInicioReserva, Date dtaFimReserva, Date dtaCadastroReserva, Character stsConfirmadoReserva) {
        this.idtReserva = idtReserva;
        this.dtaInicioReserva = dtaInicioReserva;
        this.dtaFimReserva = dtaFimReserva;
        this.dtaCadastroReserva = dtaCadastroReserva;
        this.stsConfirmadoReserva = stsConfirmadoReserva;
    }

    public Integer getIdtReserva() {
        return idtReserva;
    }

    public void setIdtReserva(Integer idtReserva) {
        this.idtReserva = idtReserva;
    }

    public Date getDtaInicioReserva() {
        return dtaInicioReserva;
    }

    public void setDtaInicioReserva(Date dtaInicioReserva) {
        this.dtaInicioReserva = dtaInicioReserva;
    }

    public Date getDtaFimReserva() {
        return dtaFimReserva;
    }

    public void setDtaFimReserva(Date dtaFimReserva) {
        this.dtaFimReserva = dtaFimReserva;
    }

    public Date getDtaCadastroReserva() {
        return dtaCadastroReserva;
    }

    public void setDtaCadastroReserva(Date dtaCadastroReserva) {
        this.dtaCadastroReserva = dtaCadastroReserva;
    }

    public Character getStsConfirmadoReserva() {
        return stsConfirmadoReserva;
    }

    public void setStsConfirmadoReserva(Character stsConfirmadoReserva) {
        this.stsConfirmadoReserva = stsConfirmadoReserva;
    }

    public TaMorador getCodMorador() {
        return codMorador;
    }

    public void setCodMorador(TaMorador codMorador) {
        this.codMorador = codMorador;
    }

    public TbAreaLazer getCodAreaLazer() {
        return codAreaLazer;
    }

    public void setCodAreaLazer(TbAreaLazer codAreaLazer) {
        this.codAreaLazer = codAreaLazer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtReserva != null ? idtReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaReserva)) {
            return false;
        }
        TaReserva other = (TaReserva) object;
        if ((this.idtReserva == null && other.idtReserva != null) || (this.idtReserva != null && !this.idtReserva.equals(other.idtReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TaReserva[ idtReserva=" + idtReserva + " ]";
    }
    
}
