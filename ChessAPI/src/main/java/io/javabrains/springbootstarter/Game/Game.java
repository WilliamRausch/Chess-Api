package io.javabrains.springbootstarter.Game;

import io.javabrains.springbootstarter.user.Player;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Game {
    @Id
    private String id;

    @ManyToOne
    private Player player1;

    public Game() {

    }

    public Game(String id, String player1Id) {
        this.id = id;
        this.player1 = new Player(player1Id, "");

    }
    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
