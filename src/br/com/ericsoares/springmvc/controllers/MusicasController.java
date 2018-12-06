package br.com.ericsoares.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.ericsoares.springmvc.repositories.AlbumRepository;
import br.com.ericsoares.springmvc.repositories.MusicaRepository;

@Controller
public class MusicasController {

	@Autowired
	private AlbumRepository repoAlbum;
	@Autowired
	private MusicaRepository repoMusica;
}
