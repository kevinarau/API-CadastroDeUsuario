package AppUser.CadastroUsuario.Contollers;


import AppUser.CadastroUsuario.Repository.perfilRepository;
import AppUser.CadastroUsuario.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import AppUser.CadastroUsuario.Model.Perfil;
import AppUser.CadastroUsuario.Model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PerfilControlle {

    @Autowired
    private userRepository ur;

    @Autowired
    private perfilRepository pr;

    @RequestMapping(value = "AtualizarPerfil", method = RequestMethod.GET)
     public String atualizar(){
      return  "Perfil/AtualizadoPerfil";
    }

    @RequestMapping(value = "ExibirPerfil",method = RequestMethod.GET)
     public String exibir(){
        return "Perfil/ExibirPerfil";

     }

}
