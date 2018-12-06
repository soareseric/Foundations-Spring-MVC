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

import br.com.ericsoares.springmvc.domain.Musica;
import br.com.ericsoares.springmvc.repositories.AlbumRepository;
import br.com.ericsoares.springmvc.repositories.MusicaRepository;

@Controller
public class MusicasController {

	@Autowired
	private AlbumRepository repoAlbum;
	@Autowired
	private MusicaRepository repoMusica;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		List<Musica> musicas = repoMusica.findAll();
		model.addAttribute("musicas", musicas);
		return "musica.listar.tiles";
	}
	
	@RequestMapping(value = "/adicionar", method = RequestMethod.GET)
	public String adicionar(Model model) {
		model.addAttribute("musica", new Musica());
		model.addAttribute("albuns", repoAlbum.findAll());
		return "musica.adicionar.tiles";
	}
	
	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("musica") @Valid Musica novaMusica, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("albuns", repoAlbum.findAll());
			return "musica.adicionar.tiles";
		}
		repoMusica.save(novaMusica);
		return "redirect:/musicas/listas";
	}
	
	@RequestMapping(value = "/alterar/{id}", method = RequestMethod.GET)
	public String alterar(@PathVariable("id") Long id,Model model) {
		Musica musicaAlterada = repoMusica.findOne(id);
		model.addAttribute("musica", musicaAlterada);
		model.addAttribute("albuns", repoAlbum.findAll());
		return "musica.alterar.tiles";
	}
	
	@RequestMapping(value = "/alterar", method = RequestMethod.POST)
	public String alterar(@ModelAttribute("musica") @Valid Musica musica, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("albuns", repoAlbum.findAll());
			return "musica.alterar.tiles";
		}
		repoMusica.save(musica);
		return "redirect:/musicas/listar";
	}
	
	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id) {
		Musica musica = repoMusica.findOne(id);
		musica.setAlbum(null);
		repoMusica.delete(musica);
		return "redirect:/musicas/listar";
	}
	
}
