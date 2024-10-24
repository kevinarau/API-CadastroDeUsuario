package AppUser.CadastroUsuario.UserService;


import AppUser.CadastroUsuario.Model.Perfil;
import AppUser.CadastroUsuario.Model.User;
import AppUser.CadastroUsuario.Repository.perfilRepository;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PerfilService {

    private perfilRepository perfilRepository;

    public String Atualizarbio(String Novabio,String Novadata) {
        Perfil perfil = new Perfil();
        if (perfil == null) {
            perfil.setBio(perfil.getBio());
        } else {
            perfil.setBio(Novabio);
            perfil.setDataNascimento(Novadata);

            return "Bio Atualizada!";
        }
        return perfilRepository.save(perfil).getBio();
    }




        public List<Perfil> perfilList () {
            for (Perfil perfil : perfilRepository.findAll()) {
                System.out.println(perfil.getBio());
            }
            return perfilRepository.findAll();
        }




    }