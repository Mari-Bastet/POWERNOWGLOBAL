package fiap.br.powernow.builder;

import java.util.ArrayList;
import java.util.List;

import fiap.br.powernow.domain.PainelSolar;

public class PainelSolarDTOBuilder {

	public static PainelSolarDTO build(PainelSolar painel) {

		PainelSolarDTO painelDto = new PainelSolarDTO();
		painelDto.setFabricante(painel.getFabricante());
		painelDto.setModelo(painel.getModelo());
		painelDto.setPotencia(painel.getPotencia());
		painelDto.setId(painel.getId());
		
		return painelDto;

	}

	public static List<PainelSolarDTO> buildAll(List<PainelSolar> painel) {

		List<PainelSolarDTO> paineisDto = new ArrayList<>();

		for (PainelSolar painelSolar : painel) {
			paineisDto.add(build(painelSolar));

		}

		return paineisDto;
	}

}
