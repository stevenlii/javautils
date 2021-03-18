package com.code;
/**
 * Represents a candidate in the Antarctica election process.
 *
 * @author Lyndon While
 * @version 1.0 2020
 */
public class Candidate
{
    // their name
    private String name;
    // their number of votes
    private int noOfVotes;
    // their number of first places 
    private double noOfWins;

    /**
     * Constructor for objects of class Candidate.
     */
    public Candidate(String name)
    {
       this.name = name;
    }

    /**
     * Returns the candidate's name.
     */
    public String getName()
    {
       return name;
    }

    /**
     * Returns the number of votes obtained by the candidate.
     */
    public int getNoOfVotes()
    {
       return noOfVotes;
    }

    /**
     * Returns the number of wins obtained by the candidate.
     */
    public double getNoOfWins()
    {
       return noOfWins;
    }
    
    /**
     * Adds n votes to the candidate. 
     */
    public void addToCount(int n)
    {
    	noOfVotes += n;
    }
    
    /**
     * Adds n wins to the candidate. 
     */
    public void addToWins(double n)
    {
    	noOfWins += n;
    }

    /**
     * Returns a string reporting the candidate's result, 
     * rounding the number of wins to the nearest integer. 
     * See the sample output files for the required format. 
     */
    public String getStanding()
    {
       long noOfWinsLong = Math.round(noOfWins);
       return name +" got " + noOfVotes +" votes and "+ noOfWinsLong +" wins";
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Candidate [name=");
		builder.append(name);
		builder.append(", noOfVotes=");
		builder.append(noOfVotes);
		builder.append(", noOfWins=");
		builder.append(noOfWins);
		builder.append("]");
		return builder.toString();
	}

}
