package AppUser.CadastroUsuario.Repository;

import AppUser.CadastroUsuario.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

   User findByEmail(String email);


    void deleteById(Long id);

    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.email = (:email)")
    public User findByEmailFetchPerfis(@Param("email") String email);




}
