package com.big.backend.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(uniqueConstraints = {@UniqueConstraint(name = "ewteam_name", columnNames = "name")})
public class ElWarTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @OneToMany(mappedBy = "ewTeam", fetch = FetchType.LAZY, targetEntity = Player.class)
    private List<Player> players = new ArrayList<>();


    //region CONSTRUCTOR SET GET
    public ElWarTeam() {
    }


    public ElWarTeam(String name) {
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

    public static final class ElWarTeamBuilder {
        private Long id;
        private String name;

        private List<Player> players;

        private ElWarTeamBuilder() {

        }

        public static ElWarTeamBuilder anEwteamBuilder() {
            return new ElWarTeamBuilder();
        }

        public ElWarTeamBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ElWarTeamBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ElWarTeam build() {
            ElWarTeam elWarTeam = new ElWarTeam();
            elWarTeam.setId(id);
            elWarTeam.setName(name);
            return elWarTeam;
        }
    }

    //endregion
}
