package br.com.ericsoares.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ericsoares.springmvc.domain.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long>{

}
