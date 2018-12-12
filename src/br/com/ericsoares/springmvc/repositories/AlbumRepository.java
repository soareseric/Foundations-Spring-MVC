package br.com.ericsoares.springmvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ericsoares.springmvc.domain.Album;

// A JPA IR� CRIAR UMA CLASSE EM TEMPO DE EXECU��O PARA OS M�TODOS CONTIDOS NO JPAREPOSITORY
public interface AlbumRepository extends JpaRepository<Album, Long>{

	@Query("SELECT a FROM Album a WHERE a.nome LIKE %:nome%")
	List<Album> findByNome(@Param("nome") String nome);
	
}
