package com.clinica_veterinaria.controller;

import com.clinica_veterinaria.model.Duenio;
import com.clinica_veterinaria.service.IDuenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DuenioController {

    @Autowired
    private IDuenioService duenioServ;

    @GetMapping("/duenio/traer")
    public List<Duenio> getPersonas(){

        return duenioServ.getDuenios();
    }

    @PostMapping("/duenio/crear")
    public String savePersona (@RequestBody Duenio duenio){
        duenioServ.saveDuenio(duenio);

        return "La persona fue creada correctamente";
    }

    @DeleteMapping("/duenio/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        duenioServ.deleteDuenio(id);

        return "La persona fue eliminada correctamente";
    }

    @PutMapping ("/duenio/editar/{id}")
    public Duenio editPersona(@PathVariable Long id ,@RequestBody Duenio duenio){
        duenioServ.editDuenio(id,duenio);

        return duenioServ.findDuenio(duenio.getId_duenio());
    }
}
