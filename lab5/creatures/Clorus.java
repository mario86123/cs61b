package creatures;

import huglife.Action;
import huglife.Creature;
import huglife.Direction;
import huglife.Occupant;

import java.awt.*;
import java.util.Collection;
import java.util.Map;

public class Clorus extends Creature {

    public Clorus(double e) {
        super("clorus");
        energy = e;
    }

    public Clorus() {
        this(1);
    }

    public Color color() {
        return color(34, 0, 231);
    }

    public void move() {
        energy -= 0.03;
        if (energy < 0) {
            energy = 0;
        }
    }

    public void attack(Creature c) {
        energy += c.energy();
    }

    public Clorus replicate() {
        energy /= 2;
        return new Clorus(energy);
    }

    public void stay() {
        energy -= 0.01;
        if (energy < 0) {
            energy = 0;
        }
    }

    public Action chooseAction(Map<Direction, Occupant> neighbors){

    }

}
