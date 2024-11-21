package fiap.br.powernow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fiap.br.powernow.PainelSolarDTO;
import fiap.br.powernow.PainelSolarDTOBuilder;
import fiap.br.powernow.PainelSolarUsuarioDTO;
import fiap.br.powernow.PainelSolarUsuarioDTOBuilder;
import fiap.br.powernow.domain.PainelSolar;
import fiap.br.powernow.repository.PainelSolarRepository;
import fiap.br.powernow.repository.UsuarioRepository;
import fiap.br.powernow.service.PainelSolarUsuarioService;

@Controller
@RequestMapping("/paineis")
public class PainelSolarController {

	@Autowired
	private PainelSolarRepository repo;

	@Autowired
	private UsuarioRepository userRepo;

	@Autowired
	private PainelSolarUsuarioService painelUserService;

	@GetMapping("/selecionar-painel")
	public String exibirPaineis(Model model) {

		List<PainelSolar> paineis = repo.findAll();

		List<PainelSolarDTO> paineisDto = PainelSolarDTOBuilder.buildAll(paineis);

		model.addAttribute("paineis", paineisDto);
		model.addAttribute("selectedPainelId", null);
		return "listapaineis";
	}

	@PostMapping("/selecionarPainel")
	public String selecionarPainel(@RequestParam("selectedPainelId") Long selectedPainelId, Model model) {

		painelUserService.inserirPainelSolarUsuario(selectedPainelId);
		return "meuspaineis";
	}

	@GetMapping("/meus-paineis")
	public String listarPaineisUsuario(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = ((User) authentication.getPrincipal()).getUsername();

		Long iUsuario = userRepo.findByEmail(username).get().getId();

		List<PainelSolarUsuarioDTO> paineis = PainelSolarUsuarioDTOBuilder
				.buildAll(repo.buscarPainelPorUsuario(username), iUsuario, painelUserService);

		model.addAttribute("painel", paineis);
		return "meuspaineis";
	}

}
