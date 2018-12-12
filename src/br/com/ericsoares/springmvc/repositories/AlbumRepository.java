package br.com.ericsoares.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ericsoares.springmvc.domain.Album;

// A JPA IRÁ CRIAR UMA CLASSE EM TEMPO DE EXECUÇÃO PARA OS MÉTODOS CONTIDOS NO JPAREPOSITORY
public interface AlbumRepository extends JpaRepository<Album, Long>{

	Album findByNome(String nome);
	
}
