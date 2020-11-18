/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fantsyteam;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ekam
 */

/*
Type Codes;
1 -> WK
2 -> Bat
3 -> AR (AllRounder)
4 -> Baller
 */
public class Lineup implements Cloneable {

    // Lineup role range 
    public static final int WK_MIN = 1;
    public static final int WK_MAX = 3;
    public static final int BAT_MIN = 3;
    public static final int BAT_MAX = 5;
    public static final int AR_MIN = 2;
    public static final int AR_MAX = 4;
    public static final int BAL_MIN = 3;
    public static final int BAL_MAX = 5;
    public static final int TEAM_SIZE = 11;
    public static final int MAX_BUDGET = 100;

    private int wk;
    private int bat;
    private int ar;
    private int bal;
    private int budget;
    private int points;

    public int getBudget() {
        return budget;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    void addPlayer(Player player) {
        budget += player.getCost();
        points += player.getPoint();
        switch (player.getType()) {
            case 1:
                wk++;
                break;
            case 2:
                bat++;
                break;
            case 3:
                ar++;
                break;
            case 4:
                bal++;
                break;
        }
    }

    public int playerCount() {
        return wk + bat + ar + bal;
    }

    public boolean isFull() {
        return (playerCount() == TEAM_SIZE)
                && (wk >= WK_MIN)
                && (wk <= WK_MAX)
                && (bat >= BAT_MIN)
                && (bat <= BAT_MAX)
                && (ar >= AR_MIN)
                && (ar <= AR_MAX)
                && (bal >= BAL_MIN)
                && (bal <= BAL_MAX);

    }

    public boolean overflow() {

        return (playerCount() > TEAM_SIZE)
                || (wk > WK_MAX)
                || (bat > BAT_MAX)
                || (ar > AR_MAX)
                || (bal > BAL_MAX);
    }

    public boolean overbudget() {
        return (budget > MAX_BUDGET);
    }

    public Lineup clone() {
        try {
            return (Lineup) super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
