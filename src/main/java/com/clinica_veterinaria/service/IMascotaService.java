package com.clinica_veterinaria.service;

import com.clinica_veterinaria.dto.MascoDuenioDTO;
import com.clinica_veterinaria.model.Mascota;

import java.util.List;

public interface IMascotaService {

    //Metodo para traer a todas las mascotas
    //lectura
    public List<Mascota> getMascotas();

    //alta
    public void saveMascota(Mascota masco);

    //baja
    public void deleteMascota(Long id_mascota);

    //lectura de un solo objeto
    public Mascota findMascota(Long id_mascota);

    //edición y modificación
    public void editMascota(Mascota masco,Long id_masco);

    //traer lista perro caniche
    public List<Mascota> getCaniches();

    //traer lista mascota con su duenio
    public List<MascoDuenioDTO> getMascoDuenio();


}
