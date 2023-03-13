package br.com.senac.siscomee.model.dto;

import java.io.Serializable;
import java.util.Date;

public class FichasTecnicasDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nmFichaTecnica;
    private Integer tempoPreparo;
    private Date dtCriacao;
    private Date dtValidade;
    private String dsIngredientes;
    private Integer qtdBruta;
    private Integer txDesperdicio;
    private Integer qtdLiquida;
    private String dsModoPreparo;
    private String dsObservacao;
    private short inAtivo;
    private int usuarioIdAtualiza;
    private Date dtUltAtualiza;
    private Integer tipoProdutoId;
    private String dsTipoProduto; 
    private Integer categoriaId;
    private String nmCategoria;
    
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
	public void setInAtivo(short inAtivo) {
		this.inAtivo = inAtivo;
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
	public Integer getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}
	
	public String getNmCategoria() {
		return nmCategoria;
	}
	public void setNmCategoria(String nmCategoria) {
		this.nmCategoria = nmCategoria;
	}
	public Integer getTipoProdutoId() {
		return tipoProdutoId;
	}
	public void setTipoProdutoId(Integer tipoProdutoId) {
		this.tipoProdutoId = tipoProdutoId;
	}
	
	public String getDsTipoProduto() {
		return dsTipoProduto;
	}
	public void setDsTipoProduto(String dsTipoProduto) {
		this.dsTipoProduto = dsTipoProduto;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
    
}
