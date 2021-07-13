package com.mascotas.mascotas.services;

import java.util.ArrayList;
import java.util.Optional;

import com.mascotas.mascotas.models.AnuncioModel;
import com.mascotas.mascotas.repositories.AnuncioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnuncioService {
  @Autowired
  AnuncioRepository anuncioRepository;
  
  public ArrayList<AnuncioModel> getAnuncios(){
    return (ArrayList<AnuncioModel>) anuncioRepository.findAll();
  }

  public ArrayList<AnuncioModel> getAnunciosByTipoPublicacion(Integer tipoPublicacion){
    return anuncioRepository.findByTipoPublicacion(tipoPublicacion);
  }

  public ArrayList<AnuncioModel> getAnunciosByTipoMascota(Integer tipoMascota){
    return anuncioRepository.findByTipoMascota(tipoMascota);
  }


  public AnuncioModel saveAnuncio(AnuncioModel anuncio){
    return anuncioRepository.save(anuncio);
  }

  public Optional<AnuncioModel> getById(Long id){
    return anuncioRepository.findById(id);
  }

  public boolean existsById(Long id){
    return anuncioRepository.existsById(id);
  }
  
  public boolean deleteAnuncio(Long id) {
    try{
      anuncioRepository.deleteById(id);
      return true;
    }catch(Exception err){
      return false;
    }
  }
}