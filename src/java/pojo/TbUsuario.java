/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuário
 */
@Entity
@Table(name = "tb_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUsuario.findAll", query = "SELECT t FROM TbUsuario t")
    , @NamedQuery(name = "TbUsuario.findByIdtUsuario", query = "SELECT t FROM TbUsuario t WHERE t.idtUsuario = :idtUsuario")
    , @NamedQuery(name = "TbUsuario.findByLoginUsuario", query = "SELECT t FROM TbUsuario t WHERE t.loginUsuario = :loginUsuario")
    , @NamedQuery(name = "TbUsuario.findByPwdUsuario", query = "SELECT t FROM TbUsuario t WHERE t.pwdUsuario = :pwdUsuario")
    , @NamedQuery(name = "TbUsuario.findByRole", query = "SELECT t FROM TbUsuario t WHERE t.role = :role")})
public class TbUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idt_usuario")
    private Integer idtUsuario;
    @Basic(optional = false)
    @Column(name = "login_usuario")
    private String loginUsuario;
    @Basic(optional = false)
    @Column(name = "pwd_usuario")
    private String pwdUsuario;
    @Basic(optional = false)
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @JoinColumn(name = "cod_morador", referencedColumnName = "idt_morador")
    @ManyToOne(optional = false)
    private TaMorador codMorador;
    @JoinColumn(name = "cod_perfil", referencedColumnName = "idt_perfil")
    @ManyToOne(optional = false)
    private TdPerfil codPerfil;

    public TbUsuario() {
    }

    public TbUsuario(Integer idtUsuario) {
        this.idtUsuario = idtUsuario;
    }

    public TbUsuario(Integer idtUsuario, String loginUsuario, String pwdUsuario, Role role) {
        this.idtUsuario = idtUsuario;
        this.loginUsuario = loginUsuario;
        this.pwdUsuario = pwdUsuario;
        this.role = role;
    }

    public Integer getIdtUsuario() {
        return idtUsuario;
    }

    public void setIdtUsuario(Integer idtUsuario) {
        this.idtUsuario = idtUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getPwdUsuario() {
        return pwdUsuario;
    }

    public void setPwdUsuario(String pwdUsuario) {
        this.pwdUsuario = pwdUsuario;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public TaMorador getCodMorador() {
        return codMorador;
    }

    public void setCodMorador(TaMorador codMorador) {
        this.codMorador = codMorador;
    }

    public TdPerfil getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(TdPerfil codPerfil) {
        this.codPerfil = codPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtUsuario != null ? idtUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsuario)) {
            return false;
        }
        TbUsuario other = (TbUsuario) object;
        if ((this.idtUsuario == null && other.idtUsuario != null) || (this.idtUsuario != null && !this.idtUsuario.equals(other.idtUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TbUsuario[ idtUsuario=" + idtUsuario + " ]";
    }
    
}
