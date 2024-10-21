package AppUser.CadastroUsuario.Repository;

import AppUser.CadastroUsuario.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User,Long> {

   User findByEmail(String email);


    void deleteById(Long id);


    User save (User user);

}
