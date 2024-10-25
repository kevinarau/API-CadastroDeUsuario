package AppUser.CadastroUsuario.Repository;

import AppUser.CadastroUsuario.Model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    Perfil findByUsuarioId(String usuarioId);




}

