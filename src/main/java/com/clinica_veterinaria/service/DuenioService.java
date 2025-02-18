package com.clinica_veterinaria.service;

import com.clinica_veterinaria.model.Duenio;
import com.clinica_veterinaria.repository.IDuenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenioService implements IDuenioService {

    @Autowired
    private IDuenioRepository repoDuenio;

    @Override
    public List<Duenio> getDuenios() {

        List<Duenio> listaDuenios = repoDuenio.findAll();
        return listaDuenios;
    }

    @Override
    public void saveDuenio(Duenio duenio) {

        repoDuenio.save(duenio);
    }

    @Override
    public void deleteDuenio(Long id) {

        repoDuenio.deleteById(id);
    }

    @Override
    public Duenio findDuenio(Long id) {
        return repoDuenio.findById(id).orElse(null);
    }

    @Override
    public void editDuenio(Long id, Duenio duenio) {

        repoDuenio.findById(id).orElse(null);

        duenio.setId_duenio(id);

        repoDuenio.save(duenio);
    }
}
