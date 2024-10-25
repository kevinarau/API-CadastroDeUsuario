package AppUser.CadastroUsuario.Contollers;
import AppUser.CadastroUsuario.Model.User;
import AppUser.CadastroUsuario.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{id}/perfil")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/cadastre")
    public ResponseEntity<String> cadastrarUsuario(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) {
        String usuarioCadastrado = userService.cadastrarUsuario(nome, email, senha);
        return ResponseEntity.ok(usuarioCadastrado);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String senha) {
        String loginResult = userService.validarLogin(email, senha);
        return ResponseEntity.ok(loginResult);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<User> atualizarPerfil(@PathVariable Long id, @RequestBody User perfilAtualizado) {
        User usuarioAtualizado = userService.AtualizarPerfil(id, perfilAtualizado);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        userService.deletaUsuario(id);
        return ResponseEntity.noContent().build();
    }
}

