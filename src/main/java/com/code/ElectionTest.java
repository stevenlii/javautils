package com.code;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
* This class provides unit test cases for the Election class.
* @author Lyndon While
* @version 1.0
*/
public class ElectionTest
{
    private Election e4;
    private double epsilon = 10e-4; // precision required from doubles


    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        e4  = new Election(1);
    }


    @Test
    public void testElection()
    {
        assertTrue  ("candidates shouldn't be null",     e4.getCandidates() != null);
        assertEquals("candidates should have size 0", 0, e4.getCandidates().size());
        assertTrue  ("papers shouldn't be null",         e4.getPapers() != null);
        assertEquals("papers should have size 0",     0, e4.getPapers().size());
        assertTrue  ("file shouldn't be null",           e4.getFile() != null);
        assertEquals("file contains 17 lines",       17, e4.getFile().size());
    }


    @Test
    public void testprocessFile()
    {
        e4.processFile();
        assertTrue  ("candidates shouldn't be null",     e4.getCandidates() != null);
        assertEquals("candidates should have size 4", 4, e4.getCandidates().size());
        assertTrue  ("Candidate 0 is Einstein",          e4.getCandidates().get(0).getName().equals("Einstein"));
        assertTrue  ("Candidate 1 is Newton",            e4.getCandidates().get(1).getName().equals("Newton"));
        assertTrue  ("Candidate 2 is Darwin",            e4.getCandidates().get(2).getName().equals("Darwin"));
        assertTrue  ("Candidate 3 is Galileo",           e4.getCandidates().get(3).getName().equals("Galileo"));
        for (int k = 0; k < 4; k++)
        {
            assertEquals("no one has any votes",   0, e4.getCandidates().get(k).getNoOfVotes());
            assertEquals("no one has any wins",  0.0, e4.getCandidates().get(k).getNoOfWins(), epsilon);
        }
        assertTrue  ("papers shouldn't be null",       e4.getPapers() != null);
        assertEquals("papers should have size 12", 12, e4.getPapers().size());
        assertEquals("Paper 0 has 4 marks",         4, e4.getPapers().get(0).getMarks().size());
        assertEquals("Paper 3 has 0 marks",         0, e4.getPapers().get(3).getMarks().size());
        assertEquals("Paper 7 has 1 mark",          1, e4.getPapers().get(7).getMarks().size());
        assertEquals("Paper 10 has 5 marks",        5, e4.getPapers().get(10).getMarks().size());
        assertTrue  ("file shouldn't be null",         e4.getFile() != null);
        assertEquals("file contains 17 lines",     17, e4.getFile().size());
    }


    @Test
    public void testconductCount()
    {
        e4.processFile();
        assertEquals("there are 7 informal papers",  7, e4.conductCount());
        assertTrue  ("candidates shouldn't be null",     e4.getCandidates() != null);
        assertEquals("candidates should have size 4", 4, e4.getCandidates().size());
        assertTrue  ("Candidate 0 is Einstein",          e4.getCandidates().get(0).getName().equals("Einstein"));
        assertTrue  ("Candidate 1 is Newton",            e4.getCandidates().get(1).getName().equals("Newton"));
        assertTrue  ("Candidate 2 is Darwin",            e4.getCandidates().get(2).getName().equals("Darwin"));
        assertTrue  ("Candidate 3 is Galileo",           e4.getCandidates().get(3).getName().equals("Galileo"));
        
        assertEquals("0 has 8 votes",   8,    e4.getCandidates().get(0).getNoOfVotes());
        assertEquals("1 has 2 votes",   2,    e4.getCandidates().get(1).getNoOfVotes());
        assertEquals("2 has 7 votes",   7,    e4.getCandidates().get(2).getNoOfVotes());
        assertEquals("3 has 3 votes",   3,    e4.getCandidates().get(3).getNoOfVotes());
        assertEquals("0 has 2.75 wins", 2.75, e4.getCandidates().get(0).getNoOfWins(), epsilon);
        assertEquals("1 has 0.25 wins", 0.25, e4.getCandidates().get(1).getNoOfWins(), epsilon);
        assertEquals("2 has 1.75 wins", 1.75, e4.getCandidates().get(2).getNoOfWins(), epsilon);
        assertEquals("3 has 0.25 wins", 0.25, e4.getCandidates().get(3).getNoOfWins(), epsilon);
        
        assertTrue  ("papers shouldn't be null",       e4.getPapers() != null);
        assertEquals("papers should have size 12", 12, e4.getPapers().size());
        assertEquals("Paper 0 has 4 marks",         4, e4.getPapers().get(0).getMarks().size());
        assertEquals("Paper 3 has 0 marks",         0, e4.getPapers().get(3).getMarks().size());
        assertEquals("Paper 7 has 1 mark",          1, e4.getPapers().get(7).getMarks().size());
        assertEquals("Paper 10 has 5 marks",        5, e4.getPapers().get(10).getMarks().size());
        assertTrue  ("file shouldn't be null",         e4.getFile() != null);
        assertEquals("file contains 17 lines",     17, e4.getFile().size());
    }


    @Test
    public void testgetStandings()
    {
        e4.processFile();
        assertEquals("there are 7 informal papers", 7, e4.conductCount());
        String s = "Einstein got 8 votes and 3 wins\n" +
                   "Newton got 2 votes and 0 wins\n"   +
                   "Darwin got 7 votes and 2 wins\n"   +
                   "Galileo got 3 votes and 0 wins\n";
        assertTrue  ("wrong String returned", e4.getStandings().equals(s));
    }
    
    @Test
    public void testwinner()
    {
        Candidate c;
        e4.processFile();
        assertEquals("there are 7 informal papers", 7, e4.conductCount());
        c = e4.winner();
        assertTrue  ("you returned null",              c != null);
        assertTrue  ("the winner was Einstein",        c.getName().equals("Einstein"));
        assertEquals("the winner has 8 votes",   8,    c.getNoOfVotes());
        assertEquals("the winner has 2.75 wins", 2.75, c.getNoOfWins(), epsilon);
        
        e4.getCandidates().get(1).addToCount(8); // Newton up to 10 votes
        e4.getCandidates().get(2).addToCount(3); // Darwin up to 10 votes
        c = e4.winner();
        System.out.println(c);
        assertTrue  ("you returned null",              c != null);
        assertTrue  ("the winner was Darwin",          c.getName().equals("Darwin"));
        assertEquals("the winner has 10 votes", 10,    c.getNoOfVotes());
        assertEquals("the winner has 1.75 wins", 1.75, c.getNoOfWins(), epsilon);
    }
}
