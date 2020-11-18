/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fantsyteam;

import java.util.ArrayList;

/**
 *
 * @author Ekam
 */
public class Team implements Cloneable {

    static Team bestTeam;
    static int maxPoints = - 20;

    private ArrayList<Player> players;

    private Lineup lineup;

    public Team() {
        players = new ArrayList<>();
        lineup = new Lineup();
    }

    void selectPlayer(int index) {
        Player p = players.get(index);

        p.setIncluded(true);
        lineup.addPlayer(p);
    }

    void addPlayers(ArrayList<Player> players) {
        this.players.addAll(players);
    }

    int getTeamTotal() {
//        int sum = 0;
//
//        for (Player p : players) {
//            sum += p.getPoint();
//        }
//        return sum;
        return lineup.getPoints();
    }

    int getTeamCost() {
//        int sum = 0;
//
//        for (Player p : players) {
//            sum += p.getCost();
//        }
//
//        return sum;
        return lineup.getBudget();
    }

    public ArrayList<Player> getSelectedPlayers() {
        ArrayList<Player> selected = new ArrayList<>();
        for (Player x : players) {
            if (x.isIncluded()) {
                selected.add(x);
            }
        }
        return selected;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Lineup getLineup() {
        return lineup;
    }

    public void setLineup(Lineup lineup) {
        this.lineup = lineup;
    }

    @Override
    public Team clone() {
        Team team = null;
        try {
            team = (Team) super.clone();
            ArrayList<Player> playerClone = new ArrayList<Player>();
            for (Player p : this.players) {
                playerClone.add(p.clone());
            }
            team.players = playerClone;
            team.lineup = (Lineup) this.lineup.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return team;
    }

}
