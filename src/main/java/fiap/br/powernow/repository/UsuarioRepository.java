package fiap.br.powernow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fiap.br.powernow.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT c.id FROM Usuario c WHERE UPPER(c.nome) = UPPER(:nome) AND c.senha = :senha")
	Long buscaClienteLogin(@Param("nome") String nome, @Param("senha") String senha);

	@Query("SELECT c FROM Usuario c WHERE UPPER(c.nome) = UPPER(:nome)")
	Optional<Usuario> findByUsername(@Param("nome") String nome);

	@Query("SELECT c FROM Usuario c WHERE UPPER(c.email) = UPPER(:email)")
	Optional<Usuario> findByEmail(@Param("email") String email);

	@Query(value = "select sum(me.energia_gerada) gerada"
			+ " from tb_medida me"
			+ " ,   tb_painel_solar_usuario psu"
			+ " where me.id_painel_solar = psu.id_painel_solar"
			+ " and   me.id_usuario = psu.id_usuario"
			+ " and   me.id_painel_solar = :idPainel"
			+ " and   me.id_usuario = :idUsuario"
			
			, nativeQuery = true)
	Double somaEnergiaGeradaPorPainelUsuario(@Param("idUsuario") Long idUsuario
			,@Param("idPainel") Integer idPainel
			);
}