package br.com.senac.siscomee.model.entidades;

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

/**
 *
 * @author rita.pavao
 */
@Entity
@Table(name = "fichas_tecnicas",  schema = "")
@NamedQueries({
@NamedQuery(name = "FichasTecnicas.findAll", query = "SELECT ft FROM FichasTecnicas ft")})
public class FichasTecnicas implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nm_ficha_tecnica")
    private String nmFichaTecnica;
    @Basic(optional = false)
    @Column(name = "tempo_preparo")
    private Integer tempoPreparo;
    @Basic(optional = false)
    @Column(name = "dt_criacao")
    private Date dtCriacao;
    @Basic(optional = false)
    @Column(name = "dt_validade")
    private Date dtValidade;
    @Basic(optional = false)
    @Column(name = "ds_ingredientes")
    private String dsIngredientes;
    @Basic(optional = false)
    @Column(name = "qtd_bruta")
    private Integer qtdBruta;
    @Basic(optional = false)
    @Column(name = "tx_desperdicio")
    private Integer txDesperdicio;
    @Basic(optional = false)
    @Column(name = "qtd_liquida")
    private Integer qtdLiquida;
    @Basic(optional = false)
    @Column(name = "ds_modo_preparo")
    private String dsModoPreparo;
    @Basic(optional = false)
    @Column(name = "ds_observacao")
    private String dsObservacao;
    @Basic(optional = false)
    @Column(name = "in_ativo")
    private short inAtivo;
    @Basic(optional = false)
    @Column(name = "usuario_id_atualiza")
    private int usuarioIdAtualiza;
	@Basic(optional = false)
    @Column(name = "dt_ult_atualiza")
    private Date dtUltAtualiza;
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categorias categoriaId;
    @JoinColumn(name = "tipo_produto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TiposProdutos tipoProdutoId;

	
    public FichasTecnicas() {
    }

    public FichasTecnicas(Integer id) {
        this.id = id;
    }

    public FichasTecnicas(Integer id, String nmFichaTecnica, Integer tempoPreparo, 
    		Date dtCriacao, Date dtValidade, String dsIngredientes, Integer qtdBruta, 
    		Integer txDesperdicio, Integer qtdLiquida, String dsModoPreparo, String dsObservacao,
    		short inAtivo, int usuarioIdAtualiza, Date dtUltAtualiza) 
    {
        this.id = id;
        this.nmFichaTecnica = nmFichaTecnica;
        this.tempoPreparo = tempoPreparo;
        this.dtCriacao = dtCriacao;
        this.dtValidade = dtValidade;
        this.dsIngredientes = dsIngredientes;
        this.qtdBruta = qtdBruta;
        this.txDesperdicio = txDesperdicio;
        this.qtdLiquida = qtdLiquida;
        this.dsModoPreparo = dsModoPreparo;
        this.dsObservacao = dsObservacao;
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
	
	public String getNmFichaTecnica() {
		return nmFichaTecnica;
	}

	public void setNmFichaTecnica(String nmFichaTecnica) {
		this.nmFichaTecnica = nmFichaTecnica;
	}

	public Integer getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(Integer tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public Date getDtValidade() {
		return dtValidade;
	}

	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}

	public String getDsIngredientes() {
		return dsIngredientes;
	}

	public void setDsIngredientes(String dsIngredientes) {
		this.dsIngredientes = dsIngredientes;
	}

	public Integer getQtdBruta() {
		return qtdBruta;
	}

	public void setQtdBruta(Integer qtdBruta) {
		this.qtdBruta = qtdBruta;
	}

	public Integer getTxDesperdicio() {
		return txDesperdicio;
	}

	public void setTxDesperdicio(Integer txDesperdicio) {
		this.txDesperdicio = txDesperdicio;
	}

	public Integer getQtdLiquida() {
		return qtdLiquida;
	}

	public void setQtdLiquida(Integer qtdLiquida) {
		this.qtdLiquida = qtdLiquida;
	}

	public String getDsModoPreparo() {
		return dsModoPreparo;
	}

	public void setDsModoPreparo(String dsModoPreparo) {
		this.dsModoPreparo = dsModoPreparo;
	}

	public String getDsObservacao() {
		return dsObservacao;
	}

	public void setDsObservacao(String dsObservacao) {
		this.dsObservacao = dsObservacao;
	}

	public short getInAtivo() {
		return inAtivo;
	}

	public void setInAtivo(short i) {
		this.inAtivo = i;
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

	public Categorias getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Categorias categoriaId) {
		this.categoriaId = categoriaId;
	}

	public TiposProdutos getTipoProdutoId() {
		return tipoProdutoId;
	}

	public void setTipoProdutoId(TiposProdutos tipoProdutoId) {
		this.tipoProdutoId = tipoProdutoId;
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
        if (!(object instanceof FichasTecnicas)) {
            return false;
        }
        FichasTecnicas other = (FichasTecnicas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.senac.siscomee.model.entidades.FichasTecnicas[ id=" + id + " ]";
    }

	

	
    
}
