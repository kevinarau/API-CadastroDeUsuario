package AppUser.CadastroUsuario.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;


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
    private String dataNascimento;
    @NotEmpty
    private Integer Contact;

    public @NotEmpty Integer getCont() {
        return Contact;
    }

    public void setCont(@NotEmpty Integer contact) {
        Contact = contact;
    }

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

}
