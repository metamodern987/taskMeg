package metamodern7.testspringboot.controller;

import metamodern7.testspringboot.model.User;
import metamodern7.testspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/*
Класс для реализации точки входа из внеш мира в наше приложение
Контроллер - сущность, связывающая страницу в нашем приложении с функцианалом этого же приложения

 */
@Controller                   //говорим спрингу что это и есть контроллер
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){           //передаем юзера из класса на страницу хтмл через model(аналог мапы куда добавляем атрибуты)
        List<User> users = userService.findAll();
        model.addAttribute("users", users);    //передаем в model users, который указан на хтмл странице и сюда положи юзера которого получили из БД методом findAll
        return "user-string";                    //возвращаем путь к нашему html файлу, где реализуем логику

    }

    @GetMapping("/user-create")                //также и для создания юзера без реализации логики
    public String createUserForm(User user){
        return "user-create";

    }

    @PostMapping("/user-create")                             //методом HTTP POST будем добавлять нового юзера
    public String createUser(User user){
        userService.saveUser(user);         //Сохраняем юзера
        return "redirect:/users";           //после сохранения верни нас на страницу users-string

    }

    @GetMapping("user-delete/{id}")                  //для возможности удаления маппим id через @PathVariable ("id")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("user-update/{id}")                     //id указываем т.к. изменяем уже имеющегося пользователя
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

}
