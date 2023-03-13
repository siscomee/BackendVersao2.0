package br.com.senac.siscomee.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.senac.siscomee.model.entidades.FichasTecnicas;
import br.com.senac.siscomee.model.specifications.CategoriasRet;
import br.com.senac.siscomee.model.specifications.FichaTecnicasRet;
import br.com.senac.siscomee.model.specifications.TipoProdutosRet;

@Repository
public interface FichaTecnicaRepository extends JpaRepository<FichasTecnicas, Integer> {
	
	@Query(nativeQuery = true,
            value = "select ft.id as Id, ft.nm_ficha_tecnica as NmFichaTecnica,"
            		+ "ft.tempo_preparo as TempoPreparo, ft.dt_criacao as DtCriacao,"
            		+ "ft.dt_validade as DtValidade, ft.ds_ingredientes as DsIngredientes, "
            		+ "ft.qtd_bruta as QtdBruta, ft.tx_desperdicio as TxDesperdicio,"
            		+ "ft.qtd_liquida as QtdLiquida, ft.ds_modo_preparo as DsModoPreparo,"
            		+ "ft.ds_observacao as DsObservacao,"
            		+ "tp.ds_tipo_produto as DsTipoProduto, ft.tipo_produto_id as TipoProdutoId, " 
            		+ "c.nm_categoria as NmCategoria, ft.categoria_id as CategoriaId, "
            		+ "ft.in_ativo as InAtivo, " 
            		+ "ft.usuario_id_atualiza as UsuarioIdAtualiza, ft.dt_ult_atualiza as DtUltAtualiza " 
            		+ "From fichas_tecnicas ft " 
            		+ "INNER JOIN tipos_produtos as tp ON (ft.tipo_produto_id = tp.id) " 
            		+ "INNER JOIN categorias as c ON (ft.categoria_id = c.id) " 
                    + "order by ft.in_ativo desc")
	List<FichaTecnicasRet> listarFichasTecnicas();
	
	@Query(nativeQuery = true,
			 value = "select ft.id as Id, ft.nm_ficha_tecnica as NmFichaTecnica,"
			 		+ "ft.tempo_preparo as TempoPreparo, ft.dt_criacao as DtCriacao,"
			 		+ "ft.dt_validade as DtValidade, ft.ds_ingredientes as DsIngredientes, "
			 		+ "ft.qtd_bruta as QtdBruta, ft.tx_desperdicio as TxDesperdicio,"
			 		+ "ft.qtd_liquida as QtdLiquida, ft.ds_modo_preparo as DsModoPreparo,"
			 		+ "ft.ds_observacao as DsObservacao,"
			 		+ "tp.ds_tipo_produto as DsTipoProduto, ft.tipo_produto_id as TipoProdutoId,"
			 		+ "c.nm_categoria as NmCategoria, ft.categoria_id as CategoriaId,"
			 		+ "ft.in_ativo as InAtivo,"
			 		+ "ft.usuario_id_atualiza as UsuarioIdAtualiza, ft.dt_ult_atualiza as DtUltAtualiza"
			 		+ "From fichas_tecnicas ft "
			 		+ "INNER JOIN tipos_produtos as tp ON (ft.tipo_produto_id = tp.id)"
			 		+ "INNER JOIN categorias as c ON (ft.categoria_id = c.id)"
			 		+ "order by ft.in_ativo desc")
	List<FichaTecnicasRet> listarFichasTecnicas(@Param("idTipo") Integer idTipo, @Param("idCategoria") Integer idCategoria, @Param("nmFichaTecnica") String nmFichaTecnica, @Param("situacao") Integer situacao);
	

	@Query(nativeQuery = true,
			 value = "select ft.id as Id, ft.nm_ficha_tecnica as NmFichaTecnica,"
			 		+ "ft.tempo_preparo as TempoPreparo, ft.dt_criacao as DtCriacao,"
			 		+ "ft.dt_validade as DtValidade, ft.ds_ingredientes as DsIngredientes,"
			 		+ "ft.qtd_bruta as QtdBruta, ft.tx_desperdicio as TxDesperdicio,"
			 		+ "ft.qtd_liquida as QtdLiquida, ft.ds_modo_preparo as DsModoPreparo,"
			 		+ "ft.ds_observacao as DsObservacao,"
			 		+ "tp.ds_tipo_produto as DsTipoProduto, ft.tipo_produto_id as TipoProdutoId,"
			 		+ "c.nm_categoria as NmCategoria, ft.categoria_id as CategoriaId,"
			 		+ "ft.in_ativo as InAtivo,"
			 		+ "ft.usuario_id_atualiza as UsuarioIdAtualiza, ft.dt_ult_atualiza as DtUltAtualiza"
			 		+ "From fichas_tecnicas ft "
			 		+ "INNER JOIN tipos_produtos as tp ON (ft.tipo_produto_id = tp.id)"
			 		+ "INNER JOIN categorias as c ON (ft.categoria_id = c.id)"
			 		+ "order by ft.in_ativo desc")
	List<FichaTecnicasRet> filtrarFichasTecnicas(@Param("idTipo") Integer idTipo, @Param("idCategoria") Integer idCategoria, @Param("nmFichaTecnica") String nmFichaTecnica, @Param("situacao") Integer situacao);
	
	@Query(nativeQuery = true,
            value = "select tp.id AS Id, tp.ds_tipo_produto AS DsTipoProduto " +
            		"from tipos_produtos tp where in_ativo = '1' " +
                    "order by tp.ds_tipo_produto asc")
	List<TipoProdutosRet> getTipoDeProdutos();
	
	@Query(nativeQuery = true,
            value = "select c.id AS Id, c.nm_categoria AS NmCategoria " +
            		"from categorias c where in_ativo = '1' " +
                    "order by c.nm_categoria asc")
	List<CategoriasRet> getCategorias();
	
	@Query(nativeQuery = true,
            value = "select FT.* from fichas_tecnicas FT "
            		+ "inner join tipos_produtos TP ON (FT.tipo_produto_id = TP.id) " 
            		+ "inner join categorias C ON (FT.categoria_id = C.id) " 
                    + "where TP.id = :tipo and C.id = :categoria and FT.nmFichaTecnica = :nmFichaTecnica and F.in_ativo = :situacao")
	List<FichasTecnicas> filtrarFichaTecnica(@Param("tipo") Long tipo, @Param("categoria") Long categoria, @Param("nmFichaTecnica") String nmFichaTecnica, @Param("situacao") Short situacao);

	List<FichasTecnicas> findAll(Direction desc, String string);


}
