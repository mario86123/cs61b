package creatures;

import huglife.*;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;


public class TestClorus {

    @Test
    public void testBasics() {
        Clorus c1 = new Clorus();
        Clorus c2 = new Clorus(2);
        assertEquals(1, c1.energy(), 0.01);
        assertEquals(2, c2.energy(), 0.01);
        c1.move();
        assertEquals(0.97, c1.energy(), 0.01);
    }

    @Test
    public void testReplicate() {
        Clorus c1 = new Clorus();
        Clorus c2 = c1.replicate();
        assertEquals(0.5, c1.energy(), 0.01);
        assertEquals(0.5, c2.energy(), 0.01);
    }

    @Test
    public void testAttack() {
        Clorus c1 = new Clorus();
        Clorus c2 = new Clorus(2);
        Plip p1 = new Plip();
        c1.attack(c2);
        assertEquals(3, c1.energy(), 0.01);
        c1.attack(p1);
        assertEquals(4, c1.energy(), 0.01);
    }

    @Test
    public void testChoose() {
        Clorus c = new Clorus(1.2);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        Action actual = c.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);

        c = new Clorus(1.2);
        HashMap<Direction, Occupant> surPlip = new HashMap<Direction, Occupant>();
        surPlip.put(Direction.TOP, new Impassible());
        surPlip.put(Direction.BOTTOM, new Impassible());
        surPlip.put(Direction.LEFT, new Impassible());
        surPlip.put(Direction.RIGHT, new Plip(2));

        actual = c.chooseAction(surPlip);
        expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);

        c = new Clorus(1.2);
        HashMap<Direction, Occupant> onePlip = new HashMap<Direction, Occupant>();
        onePlip.put(Direction.TOP, new Plip(1));
        onePlip.put(Direction.BOTTOM, new Empty());
        onePlip.put(Direction.LEFT, new Impassible());
        onePlip.put(Direction.RIGHT, new Empty());

        actual = c.chooseAction(onePlip);
        expected = new Action(Action.ActionType.ATTACK, Direction.TOP);

        assertEquals(expected, actual);

//        c = new Clorus(1.2);
//        HashMap<Direction, Occupant> twoPlip = new HashMap<Direction, Occupant>();
//        twoPlip.put(Direction.TOP, new Empty());
//        twoPlip.put(Direction.BOTTOM, new Plip(1));
//        twoPlip.put(Direction.LEFT, new Plip(1));
//        twoPlip.put(Direction.RIGHT, new Impassible());
//
//        actual = c.chooseAction(twoPlip);
//        expected = new Action(Action.ActionType.ATTACK);
//
//        assertEquals(expected, actual);

        c = new Clorus(1);
        HashMap<Direction, Occupant> eNotSmallerOne = new HashMap<Direction, Occupant>();
        eNotSmallerOne.put(Direction.TOP, new Empty());
        eNotSmallerOne.put(Direction.BOTTOM, new Impassible());
        eNotSmallerOne.put(Direction.LEFT, new Impassible());
        eNotSmallerOne.put(Direction.RIGHT, new Clorus(1.2));

        actual = c.chooseAction(eNotSmallerOne);
        expected = new Action(Action.ActionType.REPLICATE, Direction.TOP);

        assertEquals(expected, actual);

        c = new Clorus(0.8);
        HashMap<Direction, Occupant> allEmpty = new HashMap<Direction, Occupant>();
        allEmpty.put(Direction.TOP, new Clorus(1.2));
        allEmpty.put(Direction.BOTTOM, new Impassible());
        allEmpty.put(Direction.LEFT, new Empty());
        allEmpty.put(Direction.RIGHT, new Impassible());

        actual = c.chooseAction(allEmpty);
        expected = new Action(Action.ActionType.MOVE, Direction.LEFT);

        assertEquals(expected, actual);
    }
}
