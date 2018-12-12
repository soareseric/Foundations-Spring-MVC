package br.com.ericsoares.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ericsoares.springmvc.domain.Album;

// A JPA IR� CRIAR UMA CLASSE EM TEMPO DE EXECU��O PARA OS M�TODOS CONTIDOS NO JPAREPOSITORY
public interface AlbumRepository extends JpaRepository<Album, Long>{

	Album findByNome(String nome);
	
}
