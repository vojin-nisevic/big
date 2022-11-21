package com.big.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "front_row")
public class FrontRow {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Size(min = 2)
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "frontRow", fetch = FetchType.LAZY, targetEntity = Player.class)
//    @JsonManagedReference
    private List<Player> players = new ArrayList<>();

    //region CONSTRUCTOR
    public FrontRow(String name) {
        this.name = name;
    }

    public FrontRow() {

    }

    //endregion

    //region GET SET TO STRING

    @Override
    public String toString() {
        return "FrontRow{" +
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

    //endregion

    //region DATA GENERATOR

    public static final class FrontRowBuilder {
        private Long id;
        private String name;

        private FrontRowBuilder() {
        }

        public static FrontRow.FrontRowBuilder anFrontRowBuilder() {
            return new FrontRow.FrontRowBuilder();
        }

        public FrontRow.FrontRowBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public FrontRow.FrontRowBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FrontRow build() {
            FrontRow frontRow = new FrontRow();
            frontRow.setId(id);
            frontRow.setName(name);
            return frontRow;
        }
    }

    //endregion
}
