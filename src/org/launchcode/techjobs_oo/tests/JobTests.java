package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTests {
    Job testJob1;
    Job testJob2;
    Job constructorTestJob;
    Job equalityTestJob1;
    Job equalityTestJob2;
    Job toStringTestJob1;
    Job toStringTestJob2;
    Job toStringTestJob3;

    @Before
    public void createTestJobClasses(){
        testJob1 = new Job();
        testJob2 = new Job();
        constructorTestJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        equalityTestJob1 = new Job("Red Bull Athlete", new Employer("Whipper"), new Location("Volcano"), new PositionType("Climber"), new CoreCompetency("Guts"));
        equalityTestJob2 = new Job("Red Bull Athlete", new Employer("Whipper"), new Location("Volcano"), new PositionType("Climber"), new CoreCompetency("Guts"));
        toStringTestJob1 = new Job("Red Bull Athlete", new Employer("Whipper"), new Location("Volcano"), new PositionType("Climber"), new CoreCompetency("Guts"));
        toStringTestJob2 = new Job("Red Bull Athlete", new Employer("Whipper"), new Location("Volcano"), new PositionType("Climber"), new CoreCompetency(""));
        toStringTestJob3 = new Job();
    }

    @Test
    public void emptyTest() {
        assertEquals(10,10,.001);
    }

    @Test
    public void testSettingJobId(){
        assertFalse(testJob1.getId()==testJob2.getId());
        assertEquals(1, testJob2.getId()-testJob1.getId(),.001);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertEquals(27, constructorTestJob.getId());
        assertEquals("Product tester", constructorTestJob.getName());
        assertEquals("ACME", constructorTestJob.getEmployer().getValue());
        assertEquals("Desert", constructorTestJob.getLocation().getValue());
        assertEquals("Quality control", constructorTestJob.getPositionType().getValue());
        assertEquals("Persistence", constructorTestJob.getCoreCompetency().getValue());
        assertTrue(constructorTestJob.getEmployer() instanceof Employer);
        assertTrue(constructorTestJob.getLocation() instanceof Location);
        assertTrue(constructorTestJob.getPositionType() instanceof PositionType);
        assertTrue(constructorTestJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(equalityTestJob1.equals(equalityTestJob2));
    }

    @Test
    public void testBlankLineBeforeAndAfterJobInformationForToString(){
        assertTrue(constructorTestJob.toString().startsWith("\n"));
        assertTrue(constructorTestJob.toString().endsWith("\n"));
    }

    @Test
    public void testJobInformationForToString(){
        assertEquals("\nID: 22\nName: Red Bull Athlete\nEmployer: Whipper\nLocation: Volcano\nPosition Type: Climber\nCore Competency: Guts\n",toStringTestJob1.toString());
    }

    @Test
    public void testEmptyFieldForToString(){
        assertEquals("\nID: 47\nName: Red Bull Athlete\nEmployer: Whipper\nLocation: Volcano\nPosition Type: Climber\nCore Competency: Data not available\n",toStringTestJob2.toString());
    }

    @Test
    public void testNoJobInformationForToString(){
        assertEquals("\nOOPS! This job does not seem to exist.\n",toStringTestJob3.toString());
    }


}
