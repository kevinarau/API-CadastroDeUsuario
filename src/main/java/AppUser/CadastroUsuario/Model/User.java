package AppUser.CadastroUsuario.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "users")
public class User  {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id_Usuario")
    private long Id;

    @NotEmpty
    @Column(length = 20, name = "nome_Usuario")
    private String nome;

    @NotEmpty
    @Column(length = 50, name = "Email_Usuario")
    private String email;

    @NotEmpty
    @Column(length = 100, name = "Senha_Usuario")
    private String password;

    @NotEmpty
    @Column(length = 20, name = "Data_Usuario")
    private String dataCastro;

    @Setter
    @Getter
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "id_Usuario",joinColumns = @JoinColumn(name = "users_id"))
    @Column(name = "role_id")
    private List<String> roles =  new ArrayList<>();



    public @NotEmpty String getDataCastro() {
        return dataCastro;
    }

    public void setDataCastro(@NotEmpty String dataCadastro) {
        this.dataCastro = dataCadastro;
    }

    public @NotEmpty String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty String email) {
        this.email = email;
    }

    public @NotEmpty String getNome() {
        return nome;
    }

    public void setNome(@NotEmpty String nome) {
        this.nome = nome;
    }

    public @NotEmpty String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty String password) {
        this.password = password;
    }


}
