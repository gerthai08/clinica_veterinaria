package com.clinica_veterinaria.controller;

import com.clinica_veterinaria.dto.MascoDuenioDTO;
import com.clinica_veterinaria.model.Duenio;
import com.clinica_veterinaria.model.Mascota;
import com.clinica_veterinaria.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MascotaController {

    @Autowired
    private IMascotaService mascoServ;

    @GetMapping("/mascotas/traer")
    public List<Mascota> traerMascotas(){
        return mascoServ.getMascotas();
    }

    @PostMapping("/mascotas/crear")
    public String saveMascota(@RequestBody Mascota masco){
        mascoServ.saveMascota(masco);

        return "La mascota fue creada  correctamente";
    }

    @DeleteMapping("/mascotas/borrar/{id_mascota}")
    public String deleteMascota(@PathVariable Long id_mascota){
        mascoServ.deleteMascota(id_mascota);

        return "La persona fue eliminada correctamente";
    }

    @PutMapping("/mascotas/editar/{id}")
    public String editMascota(@RequestBody Mascota masco, @PathVariable Long id) {
        mascoServ.editMascota(masco,id);
        return "Mascota editada correctamente";
    }

    @GetMapping("/mascotas/traer-caniches")
    public List<Mascota> traerCaniches(){
        return mascoServ.getCaniches();
    }

    @GetMapping("/mascotas/traer-duenios")
    public List<MascoDuenioDTO> traerMascoDuenio(){
        return mascoServ.getMascoDuenio();
    }
}
