/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fantsyteam;

import java.util.Comparator;

/**
 *
 * @author Ekam
 */
public class Player implements Cloneable {

    private static int idCount = 0;

    private int id;
    private int type;
    private int cost;
    private int point;
    private boolean included;

    public Player(int type, int cost, int point) {
        this.id = ++idCount;
        this.type = type;
        this.cost = cost;
        this.point = point;
    }

    public Player(String type, String cost, String point) {
        this.id = ++idCount;
        this.type = Integer.parseInt(type.trim());
        this.cost = Integer.parseInt(cost.trim());
        this.point = Integer.parseInt(point.trim());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player{id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", cost=").append(cost);
        sb.append(", point=").append(point);
//        sb.append(", included=").append(included);
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean isIncluded() {
        return included;
    }

    public void setIncluded(boolean included) {
        this.included = included;
    }

    @Override
    public Player clone() throws CloneNotSupportedException {
        return (Player) super.clone();
    }
}
