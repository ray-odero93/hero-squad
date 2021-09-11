package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void newHero_instantiatesCorrectly() throws Exception {
        Hero hero = new Hero("ray", 28, "intellectual-animist","truth");
        assertTrue(hero instanceof Hero);
    }

    @Test
    public void newHero_instantiatesWithCorrectContent_true() throws Exception{
        Hero hero = new Hero("ray", 28, "intellectual-animist","truth");
        assertEquals("", hero.getContent());
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}