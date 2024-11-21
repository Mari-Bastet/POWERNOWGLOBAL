package fiap.br.powernow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fiap.br.powernow.domain.PainelSolar;

@Repository
public interface PainelSolarRepository extends JpaRepository<PainelSolar, Long>{
	
    @Query("SELECT u.paineis FROM Usuario u WHERE upper(u.email) = upper(:email)")
	List<PainelSolar> buscarPainelPorUsuario(String email);

}
