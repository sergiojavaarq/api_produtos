package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.queries.CategoriasDto;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

	@GetMapping
	public ResponseEntity<List<CategoriasDto>> getAll() {
		// TODO
		return null;
	}
}
