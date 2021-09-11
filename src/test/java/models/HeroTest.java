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
    public void newHero_instantiatesWithCorrectName_true() throws Exception{
        Hero hero = new Hero("ray", 28, "intellectual-animist","truth");
        assertEquals("", hero.getName());
    }

    @Test
    public void newHero_instantiatesWithCorrectAge_true() throws Exception{
        Hero hero = new Hero("ray", 28, "intellectual-animist","truth");
        assertEquals(28, hero.getAge());
    }

    @Test
    public void newHero_instantiatesWithCorrectPower() throws Exception{
        Hero hero = new Hero("ray", 28, "intellectual-animist","truth");
        assertEquals("intellectual-animist", hero.getPower());
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}