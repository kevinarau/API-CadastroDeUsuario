package AppUser.CadastroUsuario.UserService;

import AppUser.CadastroUsuario.Model.User;
import AppUser.CadastroUsuario.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public String cadastrarUsuario(String nome, String email, String password) {
        if (userRepository.findByEmail(email) != null) {
            return "Email já Cadastrado";
        }
        if (password.length() <= 6) {
            return "Senha deve ter pelo menos  6 Caracteres";
        }

        User user = new User();
        user.setNome(nome);
        user.setEmail(email);
        user.setPassword(password);
        user.getRoles().add("users");
        userRepository.save(user);

        return "Redirct:/cadastra";
    }


    public String validarLogin(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user.getEmail() == null) {
            return "Usuario nao encontrado!";
        }

        if (!user.getPassword().equals(password)) {
            return "Senha incorreta!";
        }

        return "Logado com sucesso!";
    }


    public User AtualizarPerfil(Long id, User perfilAtualizado) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setNome(perfilAtualizado.getNome());
            user.setEmail(perfilAtualizado.getEmail());
            user.setDataCastro(perfilAtualizado.getDataCastro());
            user.setPassword(perfilAtualizado.getPassword());;
            userRepository.save(user);

        }
    return user;
    }

    public void deletaUsuario(long id) {
        userRepository.deleteById(id);
    }


}