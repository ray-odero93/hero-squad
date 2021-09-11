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


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}