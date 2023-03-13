package br.com.senac.siscomee.model.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author rita.pavao
 */
@Entity
@Table(name = "categorias",  schema = "")
@NamedQueries({
@NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c")})
public class Categorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nm_categoria")
    private String nmCategoria;
    @Basic(optional = false)
    @Column(name = "in_ativo")
    private short inAtivo;
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaId")
    private Collection<FichasTecnicas> fichasTecnicasCollection;
    @Basic(optional = false)
    @Column(name = "usuario_id_atualiza")
    private int usuarioIdAtualiza;
    @Basic(optional = false)
    @Column(name = "dt_ult_atualiza")
    private Date dtUltAtualiza;
    
    public Categorias() {
    }

    public Categorias(Integer id) {
        this.id = id;
    }

    public Categorias(Integer id, String nmCategoria, short inAtivo, int usuarioIdAtualiza, Date dtUltAtualiza) {
        this.id = id;
        this.nmCategoria = nmCategoria;
        this.inAtivo = inAtivo;
        this.usuarioIdAtualiza = usuarioIdAtualiza;
        this.dtUltAtualiza = dtUltAtualiza;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNmCategoria() {
        return nmCategoria;
    }

    public void setNmCategoria(String nmCategoria) {
        this.nmCategoria = nmCategoria;
    }

    public short getInAtivo() {
        return inAtivo;
    }

    public void setInAtivo(short inAtivo) {
        this.inAtivo = inAtivo;  
    }
    
    public Collection<FichasTecnicas> getFichasTecnicasCollection() {
		return fichasTecnicasCollection;
}

    public void setFichasTecnicasCollection(Collection<FichasTecnicas> fichasTecnicasCollection) {
		this.fichasTecnicasCollection = fichasTecnicasCollection;
}
    
    public int getUsuarioIdAtualiza() {
        return usuarioIdAtualiza;
    }

    public void setUsuarioIdAtualiza(int usuarioIdAtualiza) {
        this.usuarioIdAtualiza = usuarioIdAtualiza;
    }

    public Date getDtUltAtualiza() {
        return dtUltAtualiza;
    }

    public void setDtUltAtualiza(Date dtUltAtualiza) {
        this.dtUltAtualiza = dtUltAtualiza;
    }


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorias)) {
            return false;
        }
        Categorias other = (Categorias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.montreal.siscomee.model.entidades.Categorias[ id=" + id + " ]";
    }
    
}
