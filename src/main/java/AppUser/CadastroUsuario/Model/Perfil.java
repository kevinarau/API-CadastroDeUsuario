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
    private String dataNascimento;

   @OneToMany
   private List<User> users;

    public @NotEmpty String getBio() {
        return bio;
    }

    public void setBio(@NotEmpty String bio) {
        this.bio = bio;
    }

    public @NotEmpty String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotEmpty String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
}
