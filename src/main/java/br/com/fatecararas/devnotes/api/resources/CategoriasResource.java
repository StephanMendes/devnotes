package br.com.fatecararas.devnotes.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.fatecararas.devnotes.controllers.dtos.CategoriaDTO;
import br.com.fatecararas.devnotes.model.entities.Categoria;
import br.com.fatecararas.devnotes.model.services.CategoriaService;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriasResource {
    @Autowired
    private CategoriaService service;
    
    @GetMapping
    public List<CategoriaDTO> findAll() {
        return service.buscarTodas();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/salvar")
    public Categoria salvar(@RequestBody CategoriaDTO dto) {
        var c = new Categoria();
        c.setDescricao(dto.getDescricao());
        return service.salvar(c);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable("id") Long id) {
        service.excluir(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping("/alterar/{id}")
    public Categoria alterar(@PathVariable("id") Long id, @RequestBody CategoriaDTO dto){

        Categoria categoriaExistente = service.buscarPorId(id);

        if (categoriaExistente == null){
            throw  new CategoriaNaoEncontradaException("Categoria não encontrada com o ID: " + id);
        }
        categoriaExistente.setDescricao(dto.getDescricao());

        return service.salvar(categoriaExistente);
    }

    @GetMapping("/{id}")
    public CategoriaDTO findById(@PathVariable("id") Long id){
        Categoria categoria = service.buscarPorId(id);

        if(cetegoria == null){
            throw  new CategoriaNaoEncontradaException("Categoria não encontrada com o ID: " + id);
        }
        return new CategoriaDTO(categoria);
    }
}
















