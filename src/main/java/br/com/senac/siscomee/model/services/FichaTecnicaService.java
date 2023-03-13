package br.com.senac.siscomee.model.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.senac.siscomee.model.dto.FichasTecnicasDTO;
import br.com.senac.siscomee.model.entidades.FichasTecnicas;
import br.com.senac.siscomee.model.repository.FichaTecnicaRepository;
import br.com.senac.siscomee.model.specifications.CategoriasRet;
import br.com.senac.siscomee.model.specifications.FichaTecnicasRet;
import br.com.senac.siscomee.model.specifications.TipoProdutosRet;


@Service
public class FichaTecnicaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FichaTecnicaService.class);
    private Date dataLocal = new Date();

    @Autowired
	private FichaTecnicaRepository fichaTecnicaRepository;
    
    @PersistenceContext
    private EntityManager entityManager;

    public List<FichaTecnicasRet> listarFichasTecnicas() {
    	return this.fichaTecnicaRepository.listarFichasTecnicas();
	}

	public List<FichasTecnicasDTO> listarFichasTecnicasDTO()
	{
		List<FichasTecnicasDTO> listaDTO = new ArrayList<>();
		
		for(FichasTecnicas FichaTecnica : this.fichaTecnicaRepository.findAll()) {
			FichasTecnicasDTO dto = new FichasTecnicasDTO();
				 dto.setId(FichaTecnica.getId());
				 dto.setNmFichaTecnica(FichaTecnica.getNmFichaTecnica());
				 dto.setTempoPreparo(FichaTecnica.getTempoPreparo());
				 dto.setDtCriacao(FichaTecnica.getDtCriacao());
				 dto.setDtValidade(FichaTecnica.getDtValidade());
				 dto.setDsIngredientes(FichaTecnica.getDsIngredientes());
				 dto.setQtdBruta(FichaTecnica.getQtdBruta());
				 dto.setTxDesperdicio(FichaTecnica.getTxDesperdicio());
				 dto.setQtdLiquida(FichaTecnica.getQtdLiquida());
				 dto.setDsModoPreparo(FichaTecnica.getDsModoPreparo());
				 dto.setDsObservacao(FichaTecnica.getDsObservacao());
				 dto.setInAtivo(FichaTecnica.getInAtivo());
				 dto.setDtUltAtualiza(FichaTecnica.getDtUltAtualiza());
				 dto.setUsuarioIdAtualiza(FichaTecnica.getUsuarioIdAtualiza());
				 dto.setCategoriaId(FichaTecnica.getCategoriaId().getId());
		         dto.setNmCategoria(FichaTecnica.getCategoriaId().getNmCategoria());
	             dto.setTipoProdutoId(FichaTecnica.getTipoProdutoId().getId());
	             dto.setDsTipoProduto(FichaTecnica.getTipoProdutoId().getDsTipoProduto());
				 listaDTO.add(dto);
			}	
			return listaDTO;
	}
	
	public FichasTecnicas addFichaTecnica(FichasTecnicas fichaTecnica)
	{
		return fichaTecnicaRepository.save(fichaTecnica);
	}
	
	public FichasTecnicas atualizarFichaTecnica(FichasTecnicas fichaTecnica)
	{
		FichasTecnicas FichaTecnica = fichaTecnicaRepository.findById(fichaTecnica.getId()).orElse(null);

		FichaTecnica.setNmFichaTecnica(fichaTecnica.getNmFichaTecnica());
		FichaTecnica.setTempoPreparo(fichaTecnica.getTempoPreparo());
		FichaTecnica.setDtCriacao(fichaTecnica.getDtCriacao());
		FichaTecnica.setDtValidade(fichaTecnica.getDtValidade());
		FichaTecnica.setDsIngredientes(fichaTecnica.getDsIngredientes());
		FichaTecnica.setQtdBruta(fichaTecnica.getQtdBruta());
		FichaTecnica.setTxDesperdicio(fichaTecnica.getTxDesperdicio());
		FichaTecnica.setQtdLiquida(fichaTecnica.getQtdLiquida());
		FichaTecnica.setDsModoPreparo(fichaTecnica.getDsModoPreparo());
		FichaTecnica.setDsObservacao(fichaTecnica.getDsObservacao());
		FichaTecnica.setInAtivo(fichaTecnica.getInAtivo());
		FichaTecnica.setTipoProdutoId(fichaTecnica.getTipoProdutoId());
		FichaTecnica.setCategoriaId(fichaTecnica.getCategoriaId());
		FichaTecnica.setUsuarioIdAtualiza(fichaTecnica.getUsuarioIdAtualiza());
		FichaTecnica.setDtUltAtualiza(this.dataLocal);
		
		return fichaTecnicaRepository.save(FichaTecnica);
	}
	
	// combo tipos de produtos
	public List<TipoProdutosRet> getTipoDeProdutos()
	{
		return fichaTecnicaRepository.getTipoDeProdutos();
	}
	
	// combo categorias
	public List<CategoriasRet> getCategorias()
	{
		return fichaTecnicaRepository.getCategorias();
	}
	
	public FichasTecnicas getFichaTecnicaById(int id)
	{
		return fichaTecnicaRepository.findById(id).orElse(null);
	}	
	
	public FichasTecnicas inativarFichaTecnicaByID(int idFichaTecnica)
	{
		FichasTecnicas FichaTecnica = fichaTecnicaRepository.findById(idFichaTecnica).orElse(null);

		FichaTecnica.setInAtivo((short) 0);		
		FichaTecnica.setDtUltAtualiza(this.dataLocal);

		return fichaTecnicaRepository.save(FichaTecnica);
	}
	
	public List<FichasTecnicasDTO> filtrarFichaTecnica(int idTipoDeProduto, int idCategoria, String nmFichaTecnica, int situacao)
	{
		String Sql = "select ft from FichasTecnicas ft "
				   
				   	+ "where 1=1";

					if(idTipoDeProduto != 0)
					{
						Sql += " and ft.tipoProdutoId = " + idTipoDeProduto;
					}
					
					if(idCategoria != 0)
					{
						Sql += " and ft.categoriaId = " + idCategoria;
					}
					
					if(!nmFichaTecnica.equals(null) && !nmFichaTecnica.equals("nulo"))
					{
						Sql += " and ft.nmFichaTecnica like '%" + nmFichaTecnica + "%'";
					}
					
					if((situacao != -1)|| (situacao == 1) || situacao == 0)
					{
						Sql += " and ft.inAtivo = " + situacao;
					}
				
					Sql += " order by ft.inAtivo desc";

					Query q = entityManager.createQuery(Sql);
		
					List<FichasTecnicas> Lista = q.getResultList();
					
					List<FichasTecnicasDTO> listaDTO = new ArrayList<>();
					
					for(FichasTecnicas FichaTecnica : Lista)
					{
						FichasTecnicasDTO dto = new FichasTecnicasDTO();
						
						
						 dto.setId(FichaTecnica.getId());
						 dto.setNmFichaTecnica(FichaTecnica.getNmFichaTecnica());
						 dto.setTempoPreparo(FichaTecnica.getTempoPreparo());
						 dto.setDtCriacao(FichaTecnica.getDtCriacao());
						 dto.setDtValidade(FichaTecnica.getDtValidade());
						 dto.setDsIngredientes(FichaTecnica.getDsIngredientes());
						 dto.setQtdBruta(FichaTecnica.getQtdBruta());
						 dto.setTxDesperdicio(FichaTecnica.getTxDesperdicio());
						 dto.setQtdLiquida(FichaTecnica.getQtdLiquida());
						 dto.setDsModoPreparo(FichaTecnica.getDsModoPreparo());
						 dto.setDsObservacao(FichaTecnica.getDsObservacao());
						 dto.setInAtivo(FichaTecnica.getInAtivo());
						 dto.setDtUltAtualiza(FichaTecnica.getDtUltAtualiza());
						 dto.setUsuarioIdAtualiza(FichaTecnica.getUsuarioIdAtualiza());
						 dto.setCategoriaId(FichaTecnica.getCategoriaId().getId());
				         dto.setNmCategoria(FichaTecnica.getCategoriaId().getNmCategoria());
			             dto.setTipoProdutoId(FichaTecnica.getTipoProdutoId().getId());
			             dto.setDsTipoProduto(FichaTecnica.getTipoProdutoId().getDsTipoProduto());
						 listaDTO.add(dto);
					}
						
					return listaDTO;
	}
	
	public Boolean unicidade(int idTipoDeProduto, int idCategoria, String nmFichaTecnica, String id)
	{
		String Sql = "select ft from FichasTecnicas ft "
				   	+ "where 1=1 "
					+ "and ft.tipoProdutoId = " + idTipoDeProduto
					+ "and ft.categoriaId = " + idCategoria;
					
					if(!nmFichaTecnica.equals(null) && !nmFichaTecnica.equals("nulo"))
					{
						Sql += " and ft.nmFichaTecnica = '" + nmFichaTecnica + "'";
					}

					if(!id.equals("null"))
					{
						Sql += " and ft.id != " + id;
					}

					Query q = entityManager.createQuery(Sql);
		
					List<FichasTecnicas> Lista = q.getResultList();
						
					return Lista.size() > 0 ? false : true;
	}

	@Transactional
	public void execute(String sql)
	{
		entityManager.createNativeQuery(sql).getResultList();		
	}


	
}