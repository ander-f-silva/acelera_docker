package br.com.fullcycle.mc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/modules")
public class ModuleController {

    private final ModuleRepository repository;

    public ModuleController(final ModuleRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Module> findAll() {
        return repository.findAll();
    }

}
