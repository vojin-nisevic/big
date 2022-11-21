package com.big.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
//    @JsonManagedReference
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static final class BackRowBuilder {

        private Long id;
        private String name;


        private BackRowBuilder() {
        }

        public static BackRow.BackRowBuilder anBackRowBuilder() {
            return new BackRow.BackRowBuilder();
        }

        public BackRow.BackRowBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public BackRow.BackRowBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public BackRow build() {
            BackRow backRow = new BackRow();
            backRow.setId(id);
            backRow.setName(name);
            return backRow;
        }
    }
}
