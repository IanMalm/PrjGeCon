package pojo;
// Generated 19/04/2018 19:35:03 by Hibernate Tools 4.3.1


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

/**
 * TbApartamento generated by hbm2java
 */
@Entity
@Table(name="tb_apartamento"
    ,catalog="db_gecon"
)
public class TbApartamento  implements java.io.Serializable {


     private Integer idtApartamento;
     private TbCondominio tbCondominio;
     private String blocoApartamento;
     private String numApartamento;
     private Set<TaApartamentoPessoa> taApartamentoPessoas = new HashSet<TaApartamentoPessoa>(0);
     private Set<TaApartamentoGaragem> taApartamentoGaragems = new HashSet<TaApartamentoGaragem>(0);
     private Set<TbForum> tbForums = new HashSet<TbForum>(0);

    public TbApartamento() {
    }

	
    public TbApartamento(TbCondominio tbCondominio, String blocoApartamento, String numApartamento) {
        this.tbCondominio = tbCondominio;
        this.blocoApartamento = blocoApartamento;
        this.numApartamento = numApartamento;
    }
    public TbApartamento(TbCondominio tbCondominio, String blocoApartamento, String numApartamento, Set<TaApartamentoPessoa> taApartamentoPessoas, Set<TaApartamentoGaragem> taApartamentoGaragems, Set<TbForum> tbForums) {
       this.tbCondominio = tbCondominio;
       this.blocoApartamento = blocoApartamento;
       this.numApartamento = numApartamento;
       this.taApartamentoPessoas = taApartamentoPessoas;
       this.taApartamentoGaragems = taApartamentoGaragems;
       this.tbForums = tbForums;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idt_apartamento", unique=true, nullable=false)
    public Integer getIdtApartamento() {
        return this.idtApartamento;
    }
    
    public void setIdtApartamento(Integer idtApartamento) {
        this.idtApartamento = idtApartamento;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cod_condominio", nullable=false)
    public TbCondominio getTbCondominio() {
        return this.tbCondominio;
    }
    
    public void setTbCondominio(TbCondominio tbCondominio) {
        this.tbCondominio = tbCondominio;
    }

    
    @Column(name="bloco_apartamento", nullable=false, length=45)
    public String getBlocoApartamento() {
        return this.blocoApartamento;
    }
    
    public void setBlocoApartamento(String blocoApartamento) {
        this.blocoApartamento = blocoApartamento;
    }

    
    @Column(name="num_apartamento", nullable=false, length=45)
    public String getNumApartamento() {
        return this.numApartamento;
    }
    
    public void setNumApartamento(String numApartamento) {
        this.numApartamento = numApartamento;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tbApartamento")
    public Set<TaApartamentoPessoa> getTaApartamentoPessoas() {
        return this.taApartamentoPessoas;
    }
    
    public void setTaApartamentoPessoas(Set<TaApartamentoPessoa> taApartamentoPessoas) {
        this.taApartamentoPessoas = taApartamentoPessoas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tbApartamento")
    public Set<TaApartamentoGaragem> getTaApartamentoGaragems() {
        return this.taApartamentoGaragems;
    }
    
    public void setTaApartamentoGaragems(Set<TaApartamentoGaragem> taApartamentoGaragems) {
        this.taApartamentoGaragems = taApartamentoGaragems;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tbApartamento")
    public Set<TbForum> getTbForums() {
        return this.tbForums;
    }
    
    public void setTbForums(Set<TbForum> tbForums) {
        this.tbForums = tbForums;
    }




}


