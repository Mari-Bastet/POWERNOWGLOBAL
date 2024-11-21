package fiap.br.powernow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import fiap.br.powernow.repository.PainelSolarRepository;
import fiap.br.powernow.repository.UsuarioRepository;

@Service
public class PainelSolarUsuarioService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UsuarioRepository userRepo;
	
	public void inserirPainelSolarUsuario(Long selectedPainelId) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = ((User) authentication.getPrincipal()).getUsername();

		Long idUsuario = (userRepo.findByEmail(username)).get().getId();
		
		String sql = "CALL INSERIR_PAINEL_SOLAR_USUARIO(?, ?)";
		jdbcTemplate.update(sql, selectedPainelId, idUsuario);
	}
	
	public Double getEnergiaGeradaTotal(Long idUsuario, Integer idPainel) {
		
		return userRepo.somaEnergiaGeradaPorPainelUsuario(idUsuario, idPainel);
		
		
		
	}

}
