package br.com.ericsoares.springmvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ericsoares.springmvc.domain.Album;
import br.com.ericsoares.springmvc.repositories.AlbumRepository;

@Controller
@RequestMapping("/albuns")
public class AlbunsController {

	@Autowired
	private AlbumRepository repo;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		List<Album> albuns = repo.findAll();
		model.addAttribute("albuns", albuns);
		return "album.listar.tiles";
 	}
	
	@RequestMapping(value = "/adicionar", method = RequestMethod.GET)
	public String adicionar(Model model) {
		model.addAttribute("album", new Album());
		return "album.adicionar.tiles";
	}
	
	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("album") @Valid Album novoAlbum, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "album.adicionar.tiles";
		}
		repo.save(novoAlbum);	
		return "redirect/albuns/listar";
	}
	
	@RequestMapping(value = "/alterar/{id}", method = RequestMethod.POST)
	public String alterar(@PathVariable("id") Long id, Model model) {
		// TODO
	}
}
