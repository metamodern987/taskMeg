package metamodern7.testspringboot.repository;

import metamodern7.testspringboot.model.Req;
import metamodern7.testspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by igor on 02.06.2020
 */

public interface ReqRepository extends JpaRepository<Req, Integer> {

}

