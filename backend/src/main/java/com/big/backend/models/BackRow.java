package com.big.backend.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "back_row")
public class BackRow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Size(min = 2)
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "backRow", fetch = FetchType.LAZY, targetEntity = Player.class)
    private List<Player> players = new ArrayList<>();

    public BackRow() {
    }

    public BackRow(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BackRow{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
