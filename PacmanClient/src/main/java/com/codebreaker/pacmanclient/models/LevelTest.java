package com.codebreaker.pacmanclient.models;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pacmanlogic.*;
import java.util.Arrays;
import org.junit.Test;

public class LevelTest {
    @Test
    public void levels() {
        levels l = new levels();
        p.loselevels();
        assertEquals("The number of levels pacman", 2, p.getLevels());
    }

    @Test
    public void save() {
        save l = new save();
        p.losesave();
        assertEquals("save game pacman", 2, p.getSave());
    }

    @Test
    public void load() {
        load l = new load();
        p.load();
        assertEquals("Load Pacman Game", 2, p.getLoad())
    }
)
