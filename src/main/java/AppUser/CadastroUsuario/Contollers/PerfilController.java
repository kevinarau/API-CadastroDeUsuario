package AppUser.CadastroUsuario.Contollers;


import AppUser.CadastroUsuario.UserService.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import AppUser.CadastroUsuario.Model.Perfil;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("users/{id}/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<Perfil> getLista() {
        return perfilService.perfilLista();
    }

    @PutMapping("/atualizarBio")
    public ResponseEntity<String> atualizarBio(@RequestParam(required = false) String bio, @RequestParam(required = false) LocalDate dataNascimento, @RequestParam(required = false) String contato) {
        String atualizado = perfilService.AtualizaBio(bio, dataNascimento, contato);
        return ResponseEntity.ok(atualizado);
    }

    @GetMapping("/exibirBio")
    public Perfil exibirBio() {
        return perfilService.perfilLista().get(0);
    }
}
