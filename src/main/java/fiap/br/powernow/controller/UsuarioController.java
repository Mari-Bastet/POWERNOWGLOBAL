package fiap.br.powernow.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
			return "/inicial";

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
	
	@RequestMapping(value = "/dadoscliente", method = RequestMethod.POST)
	public String carregaTemplateDadosUsuario(@RequestParam("id") Long id,  Model model) {

		Optional<Usuario> cliente = repo.findById(id);
        model.addAttribute("cliente", cliente);
		return "/usuario/dados";
	}
	
	@PostMapping("/clientes/atualizarPerfil")
	public String atualizarPerfil(@ModelAttribute Usuario cliente) {
	    // Lógica para atualizar o perfil do cliente
	    if (cliente != null) {
	        repo.save(cliente);
	    }
	    return "redirect:/clientes/dadoscliente?id=" + cliente.getId(); // Redireciona para o perfil atualizado
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> excluirCliente(@PathVariable Long id) {

		try {
			repo.deleteById(id);
			return ResponseEntity.ok("Cliente eliminado com sucesso");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro ao remover cliente" + e.getMessage());

		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarclientePorId(@PathVariable Long id) {
		try {
			Optional<Usuario> cli = repo.findById(id);
			if (cli.isPresent()) {
				return ResponseEntity.ok(cli.get());

			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com o ID " + id + " não encontrado");
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro ao consultar cliente por ID: " + e.getMessage());
		}
	}
}