package br.com.senac.siscomee.rest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.siscomee.model.entidades.Categorias;
import br.com.senac.siscomee.model.services.CategoriaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaController.class);

	private final CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@ApiOperation(value = "método p/ adicionar as categorias")
	@PostMapping("/adicionar")
	public Categorias addTipoProduto(@RequestBody Categorias categoria) {
		return categoriaService.saveCategoria(categoria);
	}

	@PostMapping("/addCategoria")
	public List<Categorias> addCategoria(@RequestBody List<Categorias> categoria) {
		return categoriaService.saveCategoriaList(categoria);
	}

	@GetMapping("/categoria")
	public List<Categorias> findAllCategoria() {
		return categoriaService.getCategoria();
	}

	@GetMapping("/buscar/{id}")
	public Categorias findCategoriasById(@PathVariable int id) {
		return categoriaService.getCategoriaById(id);
	}

	@ApiOperation(value = "método p/ editar as categorias")
	@PutMapping("/editar")
	public Categorias updateTipoProduto(@RequestBody Categorias categoria) {
		return categoriaService.updateTipoProduto(categoria);
	}

	@ApiOperation(value = "método p/ inativar as categorias")
	@PutMapping("/inativar")
	public Categorias inativarCategoria(@RequestBody Categorias CategoriasDTO) {
		return categoriaService.inativarCategoria(CategoriasDTO);
	}
	
	@ApiOperation(value = "método p/ excluir as categorias")
	@DeleteMapping("/excluir/{id}")
	public String deleteTipoProduto(@PathVariable int id) {
		return categoriaService.deleleCategoria(id);
	}

	@ApiOperation(value = "método p/ listar as categorias")
	@RequestMapping("/listarTodos")
	public ResponseEntity<?> listar(
			@RequestParam(required = false) String nmCategoria, 
			@RequestParam(required = false) Short inAtivo,
			@RequestParam(defaultValue = "0") int page, 
			@RequestParam(defaultValue = "10") int size) {
		try {

			Page<Categorias> pageCategoria = categoriaService.buscarCategoriaPageSort(nmCategoria, inAtivo, page, size);

			Map<String, Object> response = new HashMap<>();
			response.put("categorias", pageCategoria.getContent());
			response.put("paginaAtual", pageCategoria.getNumber());
			response.put("itensTotal", pageCategoria.getTotalElements());
			response.put("paginasTotal", pageCategoria.getTotalPages());
			response.put("paginaItens", pageCategoria.getSize());
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			LOGGER.error("Erro ao listar todos!", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@ApiOperation(value = "método p/ verificar a unicidade")
	@RequestMapping("/unicidade")
	public ResponseEntity<?> listarCodigo(@RequestParam(required = true) String nmCategoria) {
		try {
			return ResponseEntity.ok(categoriaService.isSaveValid(nmCategoria));
		} catch (Exception e) {
			LOGGER.error("Já existe!", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@ApiOperation(value = "método p/ listar todos as categorias")
	@RequestMapping(path = "/listar", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> listarTodos() {
		try {
			return ResponseEntity.ok(categoriaService.listarTodos());
		} catch (Exception e) {
			LOGGER.error("Erro ao listar todos!", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
