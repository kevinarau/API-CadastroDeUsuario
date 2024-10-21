package AppUser.CadastroUsuario;

import AppUser.CadastroUsuario.Model.User;
import AppUser.CadastroUsuario.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class appCadastro implements CommandLineRunner {


    @Autowired
  private  userRepository userRepository;


    @Override
    public void run(String... args) throws Exception {


        User user = new User();
        user.setId(1L);
    user.setNome("Kevin araujo");
    user.setEmail("kevin.aparecido@.com");
    user.setPassword("1234");
    user.setDataCadastro("01/03/2024");



        userRepository.save(user);


        for (User u: userRepository.findAll()){
            System.out.println(u);
        }



    }
}
