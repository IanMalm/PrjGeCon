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
@Table(name = "tb_mensagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMensagem.findAll", query = "SELECT t FROM TbMensagem t")
    , @NamedQuery(name = "TbMensagem.findByIdtMensagem", query = "SELECT t FROM TbMensagem t WHERE t.idtMensagem = :idtMensagem")
    , @NamedQuery(name = "TbMensagem.findByDtaMensagem", query = "SELECT t FROM TbMensagem t WHERE t.dtaMensagem = :dtaMensagem")})
public class TbMensagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idt_mensagem")
    private Integer idtMensagem;
    @Basic(optional = false)
    @Lob
    @Column(name = "txt_mensagem")
    private String txtMensagem;
    @Basic(optional = false)
    @Column(name = "dta_mensagem")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtaMensagem;
    @JoinColumn(name = "cod_morador", referencedColumnName = "idt_morador")
    @ManyToOne(optional = false)
    private TaMorador codMorador;
    @JoinColumn(name = "cod_forum", referencedColumnName = "idt_forum")
    @ManyToOne(optional = false)
    private TbForum codForum;

    public TbMensagem() {
    }

    public TbMensagem(Integer idtMensagem) {
        this.idtMensagem = idtMensagem;
    }

    public TbMensagem(Integer idtMensagem, String txtMensagem, Date dtaMensagem) {
        this.idtMensagem = idtMensagem;
        this.txtMensagem = txtMensagem;
        this.dtaMensagem = dtaMensagem;
    }

    public Integer getIdtMensagem() {
        return idtMensagem;
    }

    public void setIdtMensagem(Integer idtMensagem) {
        this.idtMensagem = idtMensagem;
    }

    public String getTxtMensagem() {
        return txtMensagem;
    }

    public void setTxtMensagem(String txtMensagem) {
        this.txtMensagem = txtMensagem;
    }

    public Date getDtaMensagem() {
        return dtaMensagem;
    }

    public void setDtaMensagem(Date dtaMensagem) {
        this.dtaMensagem = dtaMensagem;
    }

    public TaMorador getCodMorador() {
        return codMorador;
    }

    public void setCodMorador(TaMorador codMorador) {
        this.codMorador = codMorador;
    }

    public TbForum getCodForum() {
        return codForum;
    }

    public void setCodForum(TbForum codForum) {
        this.codForum = codForum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtMensagem != null ? idtMensagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbMensagem)) {
            return false;
        }
        TbMensagem other = (TbMensagem) object;
        if ((this.idtMensagem == null && other.idtMensagem != null) || (this.idtMensagem != null && !this.idtMensagem.equals(other.idtMensagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TbMensagem[ idtMensagem=" + idtMensagem + " ]";
    }
    
}
