//объектное представление в виде класса для нашей сущности из БД

package metamodern7.testspringboot.model;

import lombok.Data; /*т.к. используем ломбок, то используя аннотацию @Data, которая по умолчанию
                     означает, что у нас будут геттеры и сеттеры, конструкторы и метод toString()
                     */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity                          //связка данного класса с таблицей БД
@Table(name = "soundcloud")     //именно так связанно - имя таблчики БД
public class User {
    @Id
    private Long id;

    @Column(name = "link")      //наше поле в табличке
    private String link;


}
