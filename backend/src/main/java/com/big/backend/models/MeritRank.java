package com.big.backend.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "merit_rank")
public class MeritRank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Size(min = 2)
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "meritRank", fetch = FetchType.LAZY, targetEntity = Player.class)
//    @JsonManagedReference
    private List<Player> players = new ArrayList<>();


    //region CONSTRUCTOR
    public MeritRank() {
    }

    public MeritRank(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    //endregion

    //region GET SET AND TO STRING

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

//    public List<Player> getPlayers() {
//        return players;
//    }

//    public void setPlayers(List<Player> players) {
//        this.players = players;
//    }

    @Override
    public String toString() {
        return "MeritRank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", players=" + players +
                '}';
    }

    //endregion

    //region GENERATE

    public static final class MeritRankBuilder {
        private Long id;
        private String name;
        private List<Player> players;


        private MeritRankBuilder() {
        }

        public static MeritRank.MeritRankBuilder anMeritRankBuilder() {
            return new MeritRank.MeritRankBuilder();
        }

        public MeritRank.MeritRankBuilder withId(Long id){
            this.id = id;
            return this;
        }

        public MeritRank.MeritRankBuilder withName(String name){
            this.name = name;
            return this;
        }

        public MeritRank build(){
            MeritRank meritRank = new MeritRank();
            meritRank.setId(id);
            meritRank.setName(name);
            return meritRank;
        }

    }

    //endregion

}
