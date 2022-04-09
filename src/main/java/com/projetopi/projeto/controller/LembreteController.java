package com.projetopi.projeto.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetopi.projeto.model.Lembrete;
import com.projetopi.projeto.repository.LembreteRepository;

@Controller
public class LembreteController {
	
	@Autowired
	private LembreteRepository lr;
	
	//Chama o form que cadastra o lembrete
    @RequestMapping("/cadastrarLembrete")
    public String form() {
        return "lembrete/form-lembrete";
    }
    
    //Post que cadastra o lembrete
    @RequestMapping(value = "/cadastrarLembrete", method = RequestMethod.POST)
    public String form(@Valid Lembrete lembrete, BindingResult result, RedirectAttributes attributes) {
        
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos...");
            return "redirect:/cadastrar";
        }
        
        lr.save(lembrete);
        attributes.addFlashAttribute("mensagem", "Lembrete cadastrado com sucesso!");
        return "redirect:/cadastrarLembrete";
    }
    
    // GET que lista os lembretes
    @RequestMapping("/lembretes")
    public ModelAndView listaLembretes() {
        ModelAndView mv = new ModelAndView("lembrete/lista-lembrete");
        Iterable<Lembrete> lembretes = lr.findAll();
        mv.addObject("lembretes", lembretes);
        return mv;
    }
    
    // GET que mostra os detalhes do lembrete
    @RequestMapping("/lembrete/{codigo}")
    public ModelAndView detalhesLembrete(@PathVariable("codigo") long codigo) {
        Lembrete lembrete = lr.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("lembrete/detalhes-lembrete");
        mv.addObject("lembrete", lembrete);

        return mv;
    }
    
    // GET que deleta o lembrete
    @RequestMapping("/deletarLembrete")
    public String deletarLembrete(long codigo) {
        Lembrete lembrete = lr.findByCodigo(codigo);
        lr.delete(lembrete);
        return "redirect:/lembretes";
    }
    
	// Métodos que atualiza lembrete
	// GET que chama o formulário de edição do lembrete
	@RequestMapping("/editar-lembrete")
	public ModelAndView editarLembrete(long codigo) {
		Lembrete lembrete = lr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("lembrete/update-lembrete");
		mv.addObject("lembrete", lembrete);
		return mv;
	}

	// POST do FORM que atualiza o lembrete
	@RequestMapping(value = "/editar-lembrete", method = RequestMethod.POST)
	public String updateLembrete(@Valid Lembrete lembrete, BindingResult result, RedirectAttributes attributes) {
		lr.save(lembrete);
		attributes.addFlashAttribute("success", "Lembrete alterado com sucesso!");
		return "redirect:/lembretes";
	}
}
