package pojo;
// Generated 12/04/2018 19:01:32 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TbForum generated by hbm2java
 */
@Entity
@Table(name="tb_forum"
    ,catalog="db_gecon"
)
public class TbForum  implements java.io.Serializable {


     private Integer idtForum;
     private TbApartamento tbApartamento;
     private String tituloForum;
     private String dscForum;
     private Date dtiCriacaoForum;
     private Date dtiAtualizacaoForum;
     private Set<TbMensagem> tbMensagems = new HashSet<TbMensagem>(0);

    public TbForum() {
    }

	
    public TbForum(TbApartamento tbApartamento, String tituloForum, Date dtiCriacaoForum, Date dtiAtualizacaoForum) {
        this.tbApartamento = tbApartamento;
        this.tituloForum = tituloForum;
        this.dtiCriacaoForum = dtiCriacaoForum;
        this.dtiAtualizacaoForum = dtiAtualizacaoForum;
    }
    public TbForum(TbApartamento tbApartamento, String tituloForum, String dscForum, Date dtiCriacaoForum, Date dtiAtualizacaoForum, Set<TbMensagem> tbMensagems) {
       this.tbApartamento = tbApartamento;
       this.tituloForum = tituloForum;
       this.dscForum = dscForum;
       this.dtiCriacaoForum = dtiCriacaoForum;
       this.dtiAtualizacaoForum = dtiAtualizacaoForum;
       this.tbMensagems = tbMensagems;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idt_forum", unique=true, nullable=false)
    public Integer getIdtForum() {
        return this.idtForum;
    }
    
    public void setIdtForum(Integer idtForum) {
        this.idtForum = idtForum;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cod_apartamento", nullable=false)
    public TbApartamento getTbApartamento() {
        return this.tbApartamento;
    }
    
    public void setTbApartamento(TbApartamento tbApartamento) {
        this.tbApartamento = tbApartamento;
    }

    
    @Column(name="titulo_forum", nullable=false, length=45)
    public String getTituloForum() {
        return this.tituloForum;
    }
    
    public void setTituloForum(String tituloForum) {
        this.tituloForum = tituloForum;
    }

    
    @Column(name="dsc_forum", length=200)
    public String getDscForum() {
        return this.dscForum;
    }
    
    public void setDscForum(String dscForum) {
        this.dscForum = dscForum;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dti_criacao_forum", nullable=false, length=19)
    public Date getDtiCriacaoForum() {
        return this.dtiCriacaoForum;
    }
    
    public void setDtiCriacaoForum(Date dtiCriacaoForum) {
        this.dtiCriacaoForum = dtiCriacaoForum;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dti_atualizacao_forum", nullable=false, length=19)
    public Date getDtiAtualizacaoForum() {
        return this.dtiAtualizacaoForum;
    }
    
    public void setDtiAtualizacaoForum(Date dtiAtualizacaoForum) {
        this.dtiAtualizacaoForum = dtiAtualizacaoForum;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tbForum")
    public Set<TbMensagem> getTbMensagems() {
        return this.tbMensagems;
    }
    
    public void setTbMensagems(Set<TbMensagem> tbMensagems) {
        this.tbMensagems = tbMensagems;
    }




}


