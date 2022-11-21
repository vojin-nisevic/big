package com.big.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alliance_rank")
public class AllianceRank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;

    @Size(min = 2)
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String description;

    @OneToMany(mappedBy = "allianceRank", fetch = FetchType.LAZY)
//    @JsonManagedReference
    private List<Player> players = new ArrayList<>();

    //region DATA GENERATE

    public static final class AllianceRankBuilder{

        private int id;
        private String name;
        private String description;
        private List<Player> players;

        private AllianceRankBuilder() {

        }

        public static AllianceRank.AllianceRankBuilder anAllianceRankBuilder(){
            return new AllianceRank.AllianceRankBuilder();
        }

        public AllianceRank.AllianceRankBuilder withId(int id){
            this.id = id;
            return this;
        }

        public AllianceRank.AllianceRankBuilder withName(String name){
            this.name = name;
            return this;
        }

        public AllianceRank.AllianceRankBuilder withDescription(String description){
            this.description = description;
            return this;
        }

        public AllianceRank build(){
            AllianceRank allianceRank = new AllianceRank();
            allianceRank.setId(id);
            allianceRank.setName(name);
            allianceRank.setDescription(description);
            allianceRank.setPlayers(players);
            return allianceRank;
        }
    }

    //endregion

    //region CONSTRUCT ETC


    public AllianceRank() {
    }

    public AllianceRank(int id, String name, String description, List<Player> players) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.players = players;
    }

    @Override
    public String toString() {
        return "AllianceRank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Player> getPlayers() {
//        return players;
//    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    //endregion

}
