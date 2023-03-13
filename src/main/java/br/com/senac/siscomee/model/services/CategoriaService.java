package br.com.senac.siscomee.model.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.senac.siscomee.model.dto.CategoriasDTO;
import br.com.senac.siscomee.model.entidades.Categorias;
import br.com.senac.siscomee.model.repository.CategoriaRepository;

@Service
public class CategoriaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaService.class);
	private Date dataLocal = new Date();

	private CategoriaRepository categoriaRepository;

	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public List<Categorias> listarTodos() {
		return this.categoriaRepository.findAll();
	}

	public List<CategoriasDTO> listarTodosAsDTO() {

		List<CategoriasDTO> listaDTO = new ArrayList<>();
		for (Categorias categoria : this.categoriaRepository.findAll()) {
			CategoriasDTO dto = new CategoriasDTO();
			dto.setId(categoria.getId());
			dto.setNmCategoria(categoria.getNmCategoria());
			dto.setInAtivo(categoria.getInAtivo());
			dto.setUsuarioIdAtualiza(categoria.getUsuarioIdAtualiza());
			dto.setDtUltAtualiza(categoria.getDtUltAtualiza());
			listaDTO.add(dto);
		}

		return listaDTO;
	}
	
	public List<Categorias> isSaveValid(String nmCategoria) {
		return categoriaRepository.findByNmCategoria(nmCategoria);
	}

	public Categorias saveCategoria(Categorias categoria) {
		return categoriaRepository.save(categoria);
	}

	public List<Categorias> saveCategoriaList(List<Categorias> categoria) {
		return categoriaRepository.saveAll(categoria);
	}

	public List<Categorias> getCategoria() {
		return categoriaRepository.findAll();
	}

	public Categorias getCategoriaById(int id) {
		return categoriaRepository.findById(id).orElse(null);
	}

	public Categorias updateTipoProduto(Categorias categoria) {
		Categorias existeCategoria = categoriaRepository.findById(categoria.getId())
				.orElse(null);
		existeCategoria.setNmCategoria(categoria.getNmCategoria());
		existeCategoria.setInAtivo(categoria.getInAtivo());
		existeCategoria.setUsuarioIdAtualiza(categoria.getUsuarioIdAtualiza());
		existeCategoria.setDtUltAtualiza(this.dataLocal);
		return categoriaRepository.save(existeCategoria);
	}
	
	public Categorias inativarCategoria(Categorias categoriasDTO) {
		Categorias existeCategoria = categoriaRepository.findById(categoriasDTO.getId())
				.orElse(null);
		existeCategoria.setNmCategoria(categoriasDTO.getNmCategoria());
		existeCategoria.setInAtivo(categoriasDTO.getInAtivo());
		existeCategoria.setUsuarioIdAtualiza(categoriasDTO.getUsuarioIdAtualiza());
		existeCategoria.setDtUltAtualiza(this.dataLocal);
		return categoriaRepository.save(existeCategoria);
	}

	public String deleleCategoria(int id) {
		categoriaRepository.deleteById(id);
		return "Cadastro removido com sucesso!" + id;
	}

	public Page<Categorias> buscarCategoriaPageSort( String nmCategoria, Short inAtivo,
			Integer page, Integer size) {

		Pageable paging = PageRequest.of(page, size, Sort.by("inAtivo").descending());

		Page<Categorias> pageCategoria;

		
		if ((inAtivo != null)  && (nmCategoria == null))
			pageCategoria = categoriaRepository.findByInAtivo(inAtivo, paging);
		
		else if ((inAtivo != null) && (nmCategoria == null))
			pageCategoria = categoriaRepository.findByInAtivoAndNmCategoriaContaining(inAtivo,nmCategoria,paging);
		
		else if ((inAtivo != null) && (nmCategoria != null))
			pageCategoria = categoriaRepository.findByInAtivoAndNmCategoriaContaining(inAtivo, nmCategoria,
					paging);
		
		else if ((nmCategoria != null) && (inAtivo == null))
			pageCategoria = categoriaRepository.findByNmCategoriaContaining(nmCategoria, paging);
		
		else if ((nmCategoria != null) && (inAtivo != null))
			pageCategoria = categoriaRepository.findByInAtivoAndNmCategoriaContaining(inAtivo,
					nmCategoria, paging);
		else
			pageCategoria = categoriaRepository.findAll(paging);

		return pageCategoria;
	}

}
