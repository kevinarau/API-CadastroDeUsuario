package AppUser.CadastroUsuario.Contollers;


import AppUser.CadastroUsuario.UserService.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import AppUser.CadastroUsuario.Model.Perfil;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("users/{id}/perfil")
public class PerfilControlle {


    @Autowired
    private PerfilService perfilService;

    @GetMapping("/GetList")
    public List<Perfil> getList() {
        return perfilService.perfilList();
    }

    @PutMapping("/AtualizarBio")
    private ResponseEntity<String> atualizarbio(@RequestParam(required = false) String bio, @RequestParam(required = false) String dataNasccimento, @PathVariable(required = false) Integer Contato) {
        String atulaizado = perfilService.Actualization(bio,dataNasccimento,Contato);
        return ResponseEntity.ok(atulaizado);
    }


    @GetMapping("/ExibirBio")
    private Perfil exibirBio() {
        return perfilService.perfilList().get(0);
    }


}
