package br.com.senac.siscomee.rest.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import br.com.senac.siscomee.model.services.FichaTecnicaService;
import br.com.senac.siscomee.model.entidades.FichasTecnicas;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/fichaTecnica")
public class FichaTecnicaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProdutoController.class);

    @Autowired
    private FichaTecnicaService fichaTecnicaService;

	@ApiOperation(value="método p/ listar todas as fichas técnicas")
	@RequestMapping(path = "/listarTodos", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> listarFichasTecnicas() {
		try {
			return ResponseEntity.ok(fichaTecnicaService.listarFichasTecnicas());
		}catch (Exception e) {
			LOGGER.error("Erro ao listar todas as fichas técnicas!", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
    
	@ApiOperation(value="método p/ adicionar as fichas técnicas")
    @PostMapping("/adicionar")
	public FichasTecnicas addFichaTecnica (@RequestBody FichasTecnicas fichaTecnica)
    {
		return fichaTecnicaService.addFichaTecnica(fichaTecnica);
	}
		
	@ApiOperation(value="método p/ combo (tipo de produtos)")
	@RequestMapping(path = "/tipoDeProdutos", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getTipoDeProdutos() {
		try {
			return ResponseEntity.ok(fichaTecnicaService.getTipoDeProdutos());
		}catch (Exception e) {
			LOGGER.error("Erro ao listar os tipos de produtos!", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value="método p/ combo (categorias)")
	@RequestMapping(path = "/categorias", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getCategorias() {
		try {
			return ResponseEntity.ok(fichaTecnicaService.getCategorias());
		}catch (Exception e) {
			LOGGER.error("Erro ao listar categorias!", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value="método p/ filtrar")
	@GetMapping(path = "/filtrar/{idTipoDeProduto}/{idCategoria}/{nmFichaTecnica}/{situacao}", produces = "application/json")
	public ResponseEntity<?> filtrar(@PathVariable int idTipoDeProduto, @PathVariable int idCategoria, @PathVariable String nmFichaTecnica, @PathVariable int situacao) {	
		try {
			return ResponseEntity.ok(fichaTecnicaService.filtrarFichaTecnica(idTipoDeProduto, idCategoria, nmFichaTecnica, situacao));
		}catch (Exception e) {
			LOGGER.error("Erro ao filtrar!", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value="método p/ unicidade")
	@GetMapping(path = "/unicidade/{idTipoDeProduto}/{idCategoria}/{nmFichaTecnica}/{idFichaTecnica}", produces = "application/json")
	public ResponseEntity<?> unicidade(@PathVariable int idTipoDeProduto,@PathVariable int idCategoria, @PathVariable String nmFichaTecnica, @PathVariable String idFichaTecnica) {	
		try {
			return ResponseEntity.ok(fichaTecnicaService.unicidade(idTipoDeProduto, idCategoria, nmFichaTecnica, idFichaTecnica));
		}catch (Exception e) {
			LOGGER.error("Erro ao listar todos!", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value="método p/ editar as fichas técnicas")
	@PutMapping("/editar")
	public FichasTecnicas atualizarFichaTecnica(@RequestBody FichasTecnicas fichaTecnica)
	{
		return fichaTecnicaService.atualizarFichaTecnica(fichaTecnica);
	}
	
	@ApiOperation(value="método p/ inativar")
	@GetMapping(path = "/inativar/{id}", produces = "application/json")
	public ResponseEntity<?> inativarProdutoByID(@PathVariable int id) {	
		try {
			return ResponseEntity.ok(fichaTecnicaService.inativarFichaTecnicaByID(id));
		}catch (Exception e) {
			LOGGER.error("Erro ao inativar!", e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	}