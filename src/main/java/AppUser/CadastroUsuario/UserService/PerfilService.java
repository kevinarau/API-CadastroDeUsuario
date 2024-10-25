package AppUser.CadastroUsuario.UserService;


import AppUser.CadastroUsuario.Model.Perfil;
import AppUser.CadastroUsuario.Repository.PerfilRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public String AtualizaBio(String Novabio, LocalDate Novadata, String NovoContato) {
        Perfil perfil = new Perfil();
        if (perfil != null) {
            perfil.setBio(perfil.getBio());
        } else {
            perfil.setBio(Novabio);
            perfil.setDataNascimento(Novadata);
            perfil.setCont(NovoContato);

            return "Bio Atualizada!";
        }
        return perfilRepository.save(perfil).getBio();
    }


    public List<Perfil> perfilLista () {
            System.out.println("LIST DE PERFIL");
        for (Perfil perfil  : perfilRepository.findAll()) {
            System.out.println(perfil.getUsuarioId());
            }
            return perfilRepository.findAll();
        }

    public void exbirBio() {

        System.out.println("Bio :" + perfilRepository.findByUsuarioId("1").getBio());
    }



}