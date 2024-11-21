package fiap.br.powernow;

import java.util.ArrayList;
import java.util.List;

import fiap.br.powernow.domain.PainelSolar;
import fiap.br.powernow.service.PainelSolarUsuarioService;

public class PainelSolarUsuarioDTOBuilder {

	public static PainelSolarUsuarioDTO build(PainelSolar painel, Long idUsuario, PainelSolarUsuarioService service) {

		PainelSolarUsuarioDTO painelDto = new PainelSolarUsuarioDTO();
		painelDto.setPotencia(painel.getPotencia());
		painelDto.setModelo(painel.getModelo());
		painelDto.setId(painel.getId());

		painelDto.setEnergiaGeradaTotal(service.getEnergiaGeradaTotal(idUsuario, painel.getId()));
		return painelDto;

	}

	public static List<PainelSolarUsuarioDTO> buildAll(List<PainelSolar> painel, Long idUsuario,
			PainelSolarUsuarioService service) {

		List<PainelSolarUsuarioDTO> paineisDto = new ArrayList<>();

		for (PainelSolar painelSolar : painel) {
			paineisDto.add(build(painelSolar, idUsuario, service));

		}

		return paineisDto;
	}

}
