package metamodern7.testspringboot.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by igor on 02.06.2020
 */
@Data
@Entity                          //связка класса заявок с таблицей БД
@Table(name = "requests")
public class Req {
    @Id
    private Integer id;

    @Column(name = "disp")      // столбец с описанием заявки
    private String disp;
}
