/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fantsyteam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ekam
 */
public class FantsyTeam {

    /**
     * @param args the command line arguments
     */
    public static int steps = 1;

    public static void main(String[] args) {

        String fileLocation = "src/player_info.csv";

        Team team = inputTeamDetails(fileLocation);
        System.out.println("Total number of players = " + team.getPlayers().size());

        System.out.println("Finding best team... Please wait & Enjoy some coffee...");

        findBestTeamKP(team, 0);

        if (Team.bestTeam != null) {
            ArrayList<Player> selected = Team.bestTeam.getSelectedPlayers();

            System.out.println("Budget Required = " + Team.bestTeam.getTeamCost());
            System.out.println("MAX Points = " + Team.bestTeam.getTeamTotal());

            for (Player p : selected) {
                System.out.println(p);
            }
        } else {
            System.out.println("NO TEAM POSSIBLE");
        }
    }

    public static Team inputTeamDetails(String fileLocation) {
        Team team = new Team();
        try {
            Scanner sc = new Scanner(new FileInputStream(fileLocation));
            ArrayList<Player> players = new ArrayList<>();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] row = line.split(",");

                Player p = new Player(row[0], row[1], row[2]);
                players.add(p);
            }

            team.addPlayers(players);
            team.setSelected(new int[players.size()]);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FantsyTeam.class.getName()).log(Level.SEVERE, null, ex);
        }

        return team;
    }

    public static int findBestTeamKP(Team team, int index) {

        // When team is already full;
        if (index > team.getPlayers().size() - 1) {
            return -5;
        }

        if (team.getLineup().overbudget()) {
            return -3;
        }

        if (team.getLineup().overflow()) {
            return -2;
        }

        if (team.getLineup().isFull()) {
            int points = team.getTeamTotal();
            if (points > Team.maxPoints) {
                Team.maxPoints = points;
                Team.bestTeam = team;
            }
            return points;
        }

        Team newTeam = team.clone();

        newTeam.selectPlayer(index);

        return Math.max(findBestTeamKP(team, index + 1),
                findBestTeamKP(newTeam, index + 1));
    }

}
