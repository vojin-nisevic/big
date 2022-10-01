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


    //region CONSTRUCTOR SET GET
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

    //endregion

    //region DATA GENERATOR

    public static final class EwteamBuilder {
        private Long id;
        private String name;

        private List<Player> players;

        private EwteamBuilder() {

        }

        public static EwteamBuilder anEwteamBuilder() {
            return new EwteamBuilder();
        }

        public EwteamBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EwteamBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public Ewteam build() {
            Ewteam ewteam = new Ewteam();
            ewteam.setId(id);
            ewteam.setName(name);
            return ewteam;
        }
    }

    //endregion
}
