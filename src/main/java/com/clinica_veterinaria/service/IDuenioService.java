package com.clinica_veterinaria.service;

import com.clinica_veterinaria.model.Duenio;

import java.util.List;

public interface IDuenioService {

    //método para traer todas las personas
    //lectura
    public List<Duenio> getDuenios();

    //alta
    public void saveDuenio(Duenio duenio);

    //baja
    public void deleteDuenio(Long id);

    //lectura de un solo duenio
    public Duenio findDuenio(Long id);

    //edicion/modificacion
    public void editDuenio(Long id,Duenio duenio);
}
