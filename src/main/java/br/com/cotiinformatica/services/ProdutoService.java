package br.com.cotiinformatica.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.commands.ProdutoCreateCommand;
import br.com.cotiinformatica.dtos.commands.ProdutoDeleteCommand;
import br.com.cotiinformatica.dtos.commands.ProdutoUpdateCommand;
import br.com.cotiinformatica.dtos.queries.ProdutosDto;
import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.infra.cache.ProdutosCache;
import br.com.cotiinformatica.infra.repositories.CategoriaRepository;
import br.com.cotiinformatica.infra.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutosCache produtosCache;

	@Autowired
	private ModelMapper modelMapper;

	public ProdutosDto create(ProdutoCreateCommand command) {

		Produto produto = modelMapper.map(command, Produto.class);
		produto.setCategoria(categoriaRepository.findById(command.getIdCategoria()).get());

		produtoRepository.save(produto);

		ProdutosDto dto = modelMapper.map(produto, ProdutosDto.class);
		produtosCache.save(dto);

		return dto;
	}

	public ProdutosDto update(ProdutoUpdateCommand command) {

		Produto produto = produtoRepository.findById(command.getId()).get();

		produto.setNome(command.getNome());
		produto.setPreco(command.getPreco());
		produto.setQuantidade(command.getQuantidade());
		produto.setCategoria(categoriaRepository.findById(command.getIdCategoria()).get());

		produtoRepository.save(produto);

		ProdutosDto dto = modelMapper.map(produto, ProdutosDto.class);
		produtosCache.save(dto);

		return dto;
	}

	public ProdutosDto delete(ProdutoDeleteCommand command) {

		Produto produto = produtoRepository.findById(command.getId()).get();
		produtoRepository.delete(produto);

		ProdutosDto dto = modelMapper.map(produto, ProdutosDto.class);
		produtosCache.delete(dto);

		return dto;
	}

	public List<ProdutosDto> findAll() {
		return produtosCache.findAll();
	}

	public ProdutosDto findById(Integer id) {
		return produtosCache.findById(id).get();
	}
}
