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
    public void newHero_instantiatesWithCorrectName_string() throws Exception{
        Hero hero = new Hero("ray", 28, "intellectual-animist","truth");
        assertEquals("", hero.getName());
    }

    @Test
    public void newHero_instantiatesWithCorrectAge_true_integer() throws Exception{
        Hero hero = new Hero("ray", 28, "intellectual-animist","truth");
        assertEquals(28, hero.getAge());
    }

    @Test
    public void newHero_instantiatesWithCorrectPower_string() throws Exception{
        Hero hero = new Hero("ray", 28, "intellectual-animist","truth");
        assertEquals("intellectual-animist", hero.getPower());
    }

    @Test
    public void newHero_instantiatesWithCorrectWeakness_string() throws Exception{
        Hero hero = new Hero("ray", 28, "intellectual-animist","cake");
        assertEquals("cake", hero.getWeakness());
    }

    @Test
    public void heroArray_getAllInstances_true() {
        Hero hero = new Hero("ray", 28, "intellectual-animist","cake");
        Hero otherHero = new Hero("purity", 25, "total killer-babe","diamonds");
        assertTrue(Hero.getInstances().contains(hero));
        assertTrue(Hero.getInstances().contains(otherHero));
    }

    @Test
    public void heroArray_getById_integer() {
        Hero.clearInstances();
        Hero hero = new Hero("ray", 28, "intellectual-animist","cake");
        Hero anotherHero = new Hero("purity", 25, "total killer-babe","diamonds");
        Hero thirdHero = new Hero("avie", 21, "terminator gaijin","bulonium 204");

        assertEquals(3, thirdHero.getId());
    }

    @Test
    public void heroArray_findById_Id() {
        Hero.clearInstances();
        Hero hero = new Hero("ray", 28, "intellectual-animist","cake");
        Hero otherHero = new Hero("purity", 25, "total killer-babe","diamonds");
        assertEquals(2, Hero.findById(otherHero.getId()).getId());
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}