package br.com.fullcycle.mc;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Module {
    @Id
    private Long id;

    private String name;

    public Module() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
