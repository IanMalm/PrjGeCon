package pojo;
// Generated 12/04/2018 19:01:32 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TbLazer generated by hbm2java
 */
@Entity
@Table(name="tb_lazer"
    ,catalog="db_gecon"
)
public class TbLazer  implements java.io.Serializable {


     private Integer idtLazer;
     private String dscLazer;
     private String latLazer;
     private String lgtLazer;
     private Set<TbReserva> tbReservas = new HashSet<TbReserva>(0);

    public TbLazer() {
    }

	
    public TbLazer(String dscLazer) {
        this.dscLazer = dscLazer;
    }
    public TbLazer(String dscLazer, String latLazer, String lgtLazer, Set<TbReserva> tbReservas) {
       this.dscLazer = dscLazer;
       this.latLazer = latLazer;
       this.lgtLazer = lgtLazer;
       this.tbReservas = tbReservas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idt_lazer", unique=true, nullable=false)
    public Integer getIdtLazer() {
        return this.idtLazer;
    }
    
    public void setIdtLazer(Integer idtLazer) {
        this.idtLazer = idtLazer;
    }

    
    @Column(name="dsc_lazer", nullable=false, length=45)
    public String getDscLazer() {
        return this.dscLazer;
    }
    
    public void setDscLazer(String dscLazer) {
        this.dscLazer = dscLazer;
    }

    
    @Column(name="lat_lazer", length=45)
    public String getLatLazer() {
        return this.latLazer;
    }
    
    public void setLatLazer(String latLazer) {
        this.latLazer = latLazer;
    }

    
    @Column(name="lgt_lazer", length=45)
    public String getLgtLazer() {
        return this.lgtLazer;
    }
    
    public void setLgtLazer(String lgtLazer) {
        this.lgtLazer = lgtLazer;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tbLazer")
    public Set<TbReserva> getTbReservas() {
        return this.tbReservas;
    }
    
    public void setTbReservas(Set<TbReserva> tbReservas) {
        this.tbReservas = tbReservas;
    }




}


