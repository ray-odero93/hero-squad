package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @Test
    public void newSquad_instantiatesCorrectly() {
        Squad squad = new Squad("Avengers", "Save the Universe", 14);
        assertTrue(squad instanceof Squad);
    }

    @Test
    public void newSquad_instantiatesWithValidName() {
        Squad squad = new Squad("Avengers", "Save the Universe", 14);
        assertEquals("Avengers", squad.getName());
    }

    @Test
    public void newSquad_instantiatesWithValidMission() {
        Squad squad = new Squad("Avengers", "Save the Universe", 14);
        assertEquals("Save the Universe", squad.getMission());
    }

    @Test
    public void newSquad_instantiatesWithValidParticipantsLimit() {
        Squad squad = new Squad("Avengers", "Save the Universe", 14);
        assertEquals(14, squad.getLimit());
    }

    @Test
    public void squadArray_instantiatesWithSquads_true() {
        Squad squad = new Squad("Avengers", "Save the Universe", 14);
        Squad otherSquad = new Squad("Justice League", "Kill DoomsDay", 8);

        assertTrue(squad.getInstances().contains(squad));
        assertTrue(Squad.getInstances().contains(otherSquad));
    }

    @Test
    public void squadArray_squadMembersValidlyAdded() {
        Squad squad = new Squad("Avengers", "Saving the Universe", 14);
        Hero hero = new Hero("ray", 28, "intellectual-anims", "cake");
        Hero otherHero = new Hero("purity", 25, "total killer-babe", "diamonds");

        squad.addSquadMembers(hero);
        assertEquals("ray", squad.getSquadMembers().get(0).getName());
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}