package AppUser.CadastroUsuario.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "perfil")
public class Perfil implements Serializable{


    @Serial
     private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String usuarioId;

    @NotEmpty
    private String bio;

   @NotEmpty
    private String fotoPerfil;

   @NotEmpty
    private String dataNascimento;

   @OneToMany
   private List<User> users;



}
