package AppUser.CadastroUsuario.UserService;

import AppUser.CadastroUsuario.Model.User;
import AppUser.CadastroUsuario.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    @Autowired
    private userRepository userRepository;


    public String cadastrarUsuario(String nome, String email, String password) {
        if (userRepository.findByEmail(email) != null) {
            return "Email já Cadastrado";
        }
           if (password.length() < 6) {
                return "Senha menor que 6 Caracteres";
           }

        User user = new User();
        user.setNome(nome);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        return "Usuario Cadastrado";
    }



    public String validarLogin ( String email, String password ) {

        User user = userRepository.findByEmail(email);
               if (user.getEmail() == null){
                     return  "Usuario nao encontrado!";
              }

                     if (!user.getPassword().equals(password)){
                  return "Senha incorreta!";
                     }

                           return " Login realizado com sucesso!";
    }





    public String AtualizarPerfil(Long id, String novoNome,String NovoPassword) {
        User user = userRepository.findById(id).orElse(null);

            if (user == null){
            return  "Usuario não encontrado!";
            }

        if (novoNome != null && novoNome.length() > 20) {
                  user.setNome(novoNome);
              }

                  if (NovoPassword != null && NovoPassword.length() >= 6) {
                  user.setPassword(NovoPassword);

                  }else if (NovoPassword.length() < 6) {
            return   "A nova senha precisa ter pelo menos 6 caracteres.!";
        }

        userRepository.save(user);
        return " Usuario salvo com sucesso!";

    }

    public void deletaUsuario(long id){
        userRepository.deleteById(id);
    }

}