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
import javax.persistence.Lob;
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
@Table(name = "tb_ocorrencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbOcorrencia.findAll", query = "SELECT t FROM TbOcorrencia t")
    , @NamedQuery(name = "TbOcorrencia.findByIdtOcorrencia", query = "SELECT t FROM TbOcorrencia t WHERE t.idtOcorrencia = :idtOcorrencia")
    , @NamedQuery(name = "TbOcorrencia.findByDtaOcorrencia", query = "SELECT t FROM TbOcorrencia t WHERE t.dtaOcorrencia = :dtaOcorrencia")})
public class TbOcorrencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idt_ocorrencia")
    private Integer idtOcorrencia;
    @Basic(optional = false)
    @Column(name = "dta_ocorrencia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtaOcorrencia;
    @Basic(optional = false)
    @Lob
    @Column(name = "dsc_ocorrencia")
    private String dscOcorrencia;
    @JoinColumn(name = "cod_morador", referencedColumnName = "idt_morador")
    @ManyToOne(optional = false)
    private TaMorador codMorador;

    public TbOcorrencia() {
    }

    public TbOcorrencia(Integer idtOcorrencia) {
        this.idtOcorrencia = idtOcorrencia;
    }

    public TbOcorrencia(Integer idtOcorrencia, Date dtaOcorrencia, String dscOcorrencia) {
        this.idtOcorrencia = idtOcorrencia;
        this.dtaOcorrencia = dtaOcorrencia;
        this.dscOcorrencia = dscOcorrencia;
    }

    public Integer getIdtOcorrencia() {
        return idtOcorrencia;
    }

    public void setIdtOcorrencia(Integer idtOcorrencia) {
        this.idtOcorrencia = idtOcorrencia;
    }

    public Date getDtaOcorrencia() {
        return dtaOcorrencia;
    }

    public void setDtaOcorrencia(Date dtaOcorrencia) {
        this.dtaOcorrencia = dtaOcorrencia;
    }

    public String getDscOcorrencia() {
        return dscOcorrencia;
    }

    public void setDscOcorrencia(String dscOcorrencia) {
        this.dscOcorrencia = dscOcorrencia;
    }

    public TaMorador getCodMorador() {
        return codMorador;
    }

    public void setCodMorador(TaMorador codMorador) {
        this.codMorador = codMorador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtOcorrencia != null ? idtOcorrencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbOcorrencia)) {
            return false;
        }
        TbOcorrencia other = (TbOcorrencia) object;
        if ((this.idtOcorrencia == null && other.idtOcorrencia != null) || (this.idtOcorrencia != null && !this.idtOcorrencia.equals(other.idtOcorrencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TbOcorrencia[ idtOcorrencia=" + idtOcorrencia + " ]";
    }
    
}
