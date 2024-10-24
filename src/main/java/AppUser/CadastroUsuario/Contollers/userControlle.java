package AppUser.CadastroUsuario.Contollers;
import AppUser.CadastroUsuario.Model.User;
import AppUser.CadastroUsuario.UserService.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Users")
public class userControlle {

    @Autowired
    private  UserService userService;


    @GetMapping ("/cadastrar")
    public ResponseEntity<String> cadastrarUsuario(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) {
        String resposta = userService.cadastrarUsuario(nome, email, senha);
        return ResponseEntity.ok(resposta);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String senha) {
        String resposta = userService.validarLogin(email, senha);
        return ResponseEntity.ok(resposta);
    }


    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> AtualizarPerfil(@PathVariable Long id, @RequestParam(required = false) String novoNome, @RequestParam(required = false) String novaSenha) {
        String resposta = userService.AtualizarPerfil(id, novoNome, novaSenha);
        return ResponseEntity.ok(resposta);
    }

    @DeleteMapping("/Deletar/{id}")
    public void DeletarUsuario (@PathVariable Long id){
        userService.deletaUsuario(id);
    }

}



