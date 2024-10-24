package AppUser.CadastroUsuario.Contollers;


import AppUser.CadastroUsuario.UserService.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import AppUser.CadastroUsuario.Model.Perfil;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/Perfil")
public class PerfilControlle {



    @Autowired
    private PerfilService perfilService;

    @GetMapping()
    public List<Perfil> getList(){
        return perfilService.perfilList();
    }

    @PutMapping("/AtualizarBio")
    private ResponseEntity<String> atualizarbio(@RequestParam (required = false)String bio,@RequestParam(required = false) String dataNasccimento){
       String atulaizado = perfilService.Atualizarbio(bio, dataNasccimento);
       return ResponseEntity.ok(atulaizado);
   }


   @GetMapping("/ExibirBio")
    private Perfil exibirBio(){
        return perfilService.perfilList().set(0,new Perfil());
   }


}
