package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.queries.CategoriasDto;
import br.com.cotiinformatica.services.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<CategoriasDto>> getAll() {
		return ResponseEntity.status(200).body(categoriaService.findAll());
	}
}
