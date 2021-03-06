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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ericsoares.springmvc.domain.Album;
import br.com.ericsoares.springmvc.repositories.AlbumRepository;

@Controller
public class AlbunsController {

	@Autowired
	private AlbumRepository repo;
	
	@RequestMapping(value = "albuns/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		List<Album> albuns = repo.findAll();
		model.addAttribute("albuns", albuns);
		return "album.listar.tiles";
 	}	
	
	@RequestMapping(value = "albuns/adicionar", method = RequestMethod.GET)
	public String adicionar(Model model) {
		model.addAttribute("album", new Album());
		return "album.adicionar.tiles";
	}
	
	@RequestMapping(value = "albuns/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("album") @Valid Album novoAlbum, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "album.adicionar.tiles";
		}
		repo.save(novoAlbum);	
		return "redirect:/albuns/listar";
	}
	
	@RequestMapping(value = "albuns/alterar/{id}", method = RequestMethod.GET)
	public String alterar(@PathVariable("id") Long id, Model model) {
		Album albumAlterado = repo.findOne(id);
		model.addAttribute("album", albumAlterado);
		return "album.alterar.tiles";
	}
	
	@RequestMapping(value = "albuns/alterar", method = RequestMethod.POST)
	public String alterar(@ModelAttribute("album") @Valid Album album, BindingResult result) {
		if(result.hasErrors()) {
			return "album.alterar.tiles";
		}
		repo.save(album);
		return "redirect:/albuns/listar";
	}
	
	@RequestMapping(value = "albuns/excluir/{id}", method = RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id) {
		repo.delete(id);
		return "redirect:/albuns/listar";
	}
	
	@RequestMapping(value = "albuns/porNome", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Album> pesquisarPorNome(@RequestParam(name="nome", defaultValue="") String nomeAlbum){
		return repo.findByNome(nomeAlbum);
	}
}
