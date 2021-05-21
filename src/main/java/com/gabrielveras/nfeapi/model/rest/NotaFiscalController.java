package com.gabrielveras.nfeapi.model.rest;

import com.gabrielveras.nfeapi.model.entity.NotaFiscal;
import com.gabrielveras.nfeapi.model.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/notasfiscais")
@CrossOrigin("http://localhost:4200")
public class NotaFiscalController {
    private final NotaFiscalRepository repository;

    @Autowired
    public NotaFiscalController(NotaFiscalRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Valid
    public NotaFiscal save(@Valid @RequestBody NotaFiscal notaFiscal){
        return repository.save(notaFiscal);
    }

    @GetMapping
    public List<NotaFiscal> getall() {
        return repository.findAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id, @RequestBody NotaFiscal notaFiscal ) {
        repository
                .findById(id)
                .map( nfe -> {
                    nfe.setNumeroNota(notaFiscal.getNumeroNota());
                    nfe.setEstabelecimento(notaFiscal.getEstabelecimento());
                    nfe.setValorTotal(notaFiscal.getValorTotal());
                    return repository.save(nfe);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("{id}")
    public NotaFiscal getById( @PathVariable Integer id ) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id) {
        repository
                .findById(id)
                .map( notaFiscal -> {
                    repository.delete(notaFiscal);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}