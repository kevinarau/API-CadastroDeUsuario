package AppUser.CadastroUsuario.Contollers;
import AppUser.CadastroUsuario.Model.User;
import AppUser.CadastroUsuario.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{id}/perfil")
public class userController {

    @Autowired
    private  UserService userService;


    @PostMapping ("/cadastre")
    public ResponseEntity<String> cadastrarUsuario(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) {
        String cadastreUsuario = userService.cadastrarUsuario(nome, email, senha);
        return ResponseEntity.ok(cadastreUsuario);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String senha) {
        String Login = userService.validarLogin(email, senha);
        return ResponseEntity.ok(Login);
    }


    @PutMapping("/actualizer")
    public ResponseEntity<User> AtualizarPerfil(@PathVariable Long id, @RequestParam(required = false) User perfilAtualizado) {
        User atualizarPerfil = userService.AtualizarPerfil(id,perfilAtualizado);
        return ResponseEntity.ok(atualizarPerfil);
    }

    @DeleteMapping("/Deleter")
    public void DeletarUsuario (@PathVariable Long id){
        userService.deletaUsuario(id);
    }

}



