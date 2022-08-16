package com.big.backend.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(uniqueConstraints = {@UniqueConstraint(name = "ewteam_name", columnNames = "name")})
public class Ewteam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @OneToMany(mappedBy = "ewTeam", fetch = FetchType.LAZY, targetEntity = Player.class)
    private List<Player> players = new ArrayList<>();

    public Ewteam() {
    }


    public Ewteam(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "EWTeam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
