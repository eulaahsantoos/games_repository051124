package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.record.PlataformaDTO;
import application.service.PlataformaSevice;

@RestController
@RequestMapping("/plataformas")
public class PlataformaController {
    @Autowired
    private PlataformaSevice plataformaSevice;

    @PostMapping
    public PlataformaDTO insert(@RequestBody PlataformaDTO plataforma) {
        return plataformaSevice.addPlataforma(plataforma);
    }

    @GetMapping
    public Iterable<PlataformaDTO> list () {
        return plataformaSevice.getAll();
    }

    @GetMapping("/{id}")
    public PlataformaDTO get(@PathVariable long id){
        return plataformaSevice.getOne(id);
    }
}