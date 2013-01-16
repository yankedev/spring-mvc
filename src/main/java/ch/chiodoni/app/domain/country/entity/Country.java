package ch.chiodoni.app.domain.country.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: chiodonia
 * Date: 21.11.12
 * Time: 16:20
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "COUNTRIES")
public class Country implements Serializable {

    @Id
    private String code;

    @Column(unique = true, length = 50)
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
