package catboot4.model;

import lombok.Data;
import org.hibernate.annotations.Cache;

import javax.persistence.*;

/**
 * Created by USER on 11.11.2017.
 */
@Entity
@Data

public class Cat {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Basic
    @Column(name = "name")
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
