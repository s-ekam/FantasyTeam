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

    private int selected[];

    public Team() {
        players = new ArrayList<>();
        lineup = new Lineup();
    }

    void selectPlayer(int index) {
        Player p = players.get(index);
        selected[index] = 1;
//        p.setIncluded(true);
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
        ArrayList<Player> selectedList = new ArrayList<>();
        for (int i = 0; i < selected.length; i++) {
            if (selected[i] == 1) {
                selectedList.add(players.get(i));
            }
        }
        return selectedList;
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

    public int[] getSelected() {
        return selected;
    }

    public void setSelected(int[] selected) {
        this.selected = selected;
    }

    @Override
    public Team clone() {
        Team team = null;
        try {
            team = (Team) super.clone();
//            ArrayList<Player> playerClone = new ArrayList<Player>();
//            for (Player p : this.players) {
//                playerClone.add(p.clone());
//            }
//            team.players = playerClone;
            team.lineup = (Lineup) this.lineup.clone();
//            team.selected = this.selected.clone();
            team.selected = new int[this.selected.length];
            System.arraycopy(this.selected, 0, team.selected, 0, this.selected.length);
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return team;
    }

}
