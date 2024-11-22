package fiap.br.powernow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fiap.br.powernow.domain.Usuario;
import fiap.br.powernow.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String retornaTemplateAdicionarUsuario(Model model) {

		try {

			model.addAttribute("usuario", new Usuario());
			return "cadastro";

		} catch (Exception e) {
			return "/erro";
		}
	}

	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
	public String adicionarUsuario(@ModelAttribute Usuario usuario) {

		try {

			usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
			repo.save(usuario);
			return "/login";

		} catch (Exception e) {
			return "redirect:/erro";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String carregaTemplateLoginCliente() {

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String carregaTemplateInicial() {

		return "inicial";
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public String carregaTemplateEditarDados(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = ((User) authentication.getPrincipal()).getUsername();

		Usuario usuario = repo.findByEmail(username).get();

		model.addAttribute("usuario", usuario);

		return "dados";
	}

	@RequestMapping(value = "/atualizar", method = RequestMethod.POST)
	public String atualizarDadosUsuario(@ModelAttribute("usuario") Usuario usuarioAtualizado) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = ((User) authentication.getPrincipal()).getUsername();

		Usuario usuario = repo.findByEmail(username).get();

		usuario.setEndereco(usuarioAtualizado.getEndereco());
		usuario.setSenha(usuarioAtualizado.getSenha());
		usuario.setTelefone(usuarioAtualizado.getTelefone());

		repo.save(usuario);
		return "inicial";
	}

}