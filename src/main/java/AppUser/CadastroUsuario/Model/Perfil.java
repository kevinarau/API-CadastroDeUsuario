package AppUser.CadastroUsuario.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "perfil")
public class Perfil implements Serializable{


    @Serial
     private static final long serialVersionUID = 1L;

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String usuarioId;

    @NotEmpty
    private String bio;

    @NotEmpty
    private LocalDate dataNascimento;
    @NotEmpty
    private String contato;

    public @NotEmpty String getCont() {
        return contato;
    }

    public void setCont(@NotEmpty String contato) {
        contato = contato;
    }

    public @NotEmpty String getBio() {
        return bio;
    }

    public void setBio(@NotEmpty String bio) {
        this.bio = bio;
    }

    public @NotEmpty LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotEmpty LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
