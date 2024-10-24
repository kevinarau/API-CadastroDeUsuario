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

    public String Atualizarbio(String bio,String Novadata) {
        Perfil perfil = new Perfil();
        perfil.setBio(bio);
        perfil.setDataNascimento(Novadata);

        return perfilRepository.save(perfil).getBio();
    }

    public List<Perfil> perfilList(){
        System.out.println("Lista De Perfils Cadastrados ");
        List<Perfil> perfils = new ArrayList<>();
           return perfilRepository.findAll();
    }




    }