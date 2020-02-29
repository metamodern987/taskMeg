package metamodern7.testspringboot.repository;

/*Интерфейс для взаимодействия с БД
генерирует запросы*/

import metamodern7.testspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> { //требует generic - класс (для которого реализуем) и ИД

}
