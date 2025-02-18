package com.clinica_veterinaria.service;

import com.clinica_veterinaria.dto.MascoDuenioDTO;
import com.clinica_veterinaria.model.Mascota;
import com.clinica_veterinaria.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaService implements IMascotaService {

     @Autowired
     private IMascotaRepository repoMasco;

    @Override
    public List<Mascota> getMascotas() {

        List<Mascota> listaMasco = repoMasco.findAll();
        return listaMasco;
    }

    @Override
    public void saveMascota(Mascota masco) {

        repoMasco.save(masco);
    }

    @Override
    public void deleteMascota(Long id_mascota) {

        repoMasco.deleteById(id_mascota);
    }

    @Override
    public Mascota findMascota(Long id_mascota) {

        return repoMasco.findById(id_mascota).orElse(null);
    }

    @Override
    public void editMascota(Mascota masco,Long id_masco) {

        repoMasco.findById(id_masco).orElse(null);

        masco.setId_masco(id_masco);

        repoMasco.save(masco);
    }

    @Override
    public List<Mascota> getCaniches() {

        List<Mascota> listaMascotas = this.getMascotas();
        List<Mascota> listaCaniches = new ArrayList<Mascota>();

        for (Mascota masco : listaMascotas)
            if (masco.getEspecie().equalsIgnoreCase("perro") && masco.getRaza().equalsIgnoreCase("caniche")){
                listaCaniches.add(masco);
            }

        return listaCaniches;
    }

    @Override
    public List<MascoDuenioDTO> getMascoDuenio() {

        List<Mascota> listaMascotas = this.getMascotas();
        List<MascoDuenioDTO> listaMascotaDuenio = new ArrayList<MascoDuenioDTO>();
        MascoDuenioDTO masco_duenio = new MascoDuenioDTO();

        for (Mascota masco : listaMascotas){

            System.out.println(masco.getNombre());
            masco_duenio.setNombre_duenio(masco.getUnDuenio().getNombre());
            masco_duenio.setNombre_mascota(masco.getNombre());
            masco_duenio.setApellido_duenio(masco.getUnDuenio().getApellido());
            masco_duenio.setEspecie(masco.getEspecie());
            masco_duenio.setRaza(masco.getRaza());

            listaMascotaDuenio.add(masco_duenio);
            masco_duenio = new MascoDuenioDTO();

        }
        return listaMascotaDuenio;
    }
}
