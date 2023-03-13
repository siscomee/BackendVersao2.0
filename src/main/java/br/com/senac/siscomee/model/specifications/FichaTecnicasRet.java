package br.com.senac.siscomee.model.specifications;

import java.util.Date;

public interface FichaTecnicasRet {

	Integer getId();	
	String  getNmFichaTecnica();
	Integer getTempoPreparo();
	Date    getDtCriacao();
	Date    getDtValidade();
	String  getDsIngredientes();
	Integer getQtdBruta();
	Integer getTxDesperdicio();
	Integer getQtdLiquida();
	String  getDsModoPreparo();
	String  getDsObservacao();
	String  getInAtivo();
	Integer getUsuarioIdAtualiza();
	Date    getDtUltAtualiza();
	Integer getTipoProdutoId();
	String  getDsTipoProduto();
	Integer getCategoriaId();
	String  getNmCategoria();
   
}
