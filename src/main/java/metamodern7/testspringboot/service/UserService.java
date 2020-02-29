package metamodern7.testspringboot.service;

/*
Типа для хранения бизнес-логики, но у нас это просто обертка над репозиторным слоем

UserService - оболочка, принимающая запрос извне и дергающая репозиторные методы
 */

import metamodern7.testspringboot.model.User;
import metamodern7.testspringboot.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(Long id) { //получаем юзера по ид
         return userRepository.getOne(id);
    }
    public User saveUser(User user) {    //сохранять нашего пользователя
        return userRepository.save(user);
    }

    public void deleteById(Long id) {    //удаляем пользователя
         userRepository.deleteById(id);
    }
}
