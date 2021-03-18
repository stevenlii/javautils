package com.code;

/**
 * Manages the Antarctica election process. 
 *
 * @author Lyndon While
 * @version 1.0 2020
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Election {
	// the list of candidates
	private ArrayList<Candidate> candidates;
	// the list of voting papers
	private ArrayList<VotingPaper> papers;
	// the file of election information
	private FileIO file;

	/**
	 * Constructor for objects of class Election.
	 * Creates the three field objects.
	 */
	public Election(String filename) {
		file = new FileIO(filename);
		candidates = new ArrayList<Candidate>();
		papers = new ArrayList<VotingPaper>();
	}

	/**
	 * Constructor for objects of class Election with default files.
	 * It uses k to select from the sample input files.
	 */
	public Election(int k) {
		this("election" + k + ".txt");
	}

	/**
	 * Returns the candidates list.
	 */
	public ArrayList<Candidate> getCandidates() {
		return candidates;
	}

	/**
	 * Returns the papers list.
	 */
	public ArrayList<VotingPaper> getPapers() {
		return papers;
	}

	/**
	 * Returns the read-in file contents.
	 */
	public ArrayList<String> getFile() {
		return file.getLines();
	}

	/**
	 * Use the file information to initialise the other two fields.
	 * Reads the candidates, then discards exactly one blank line, then reads the voting papers.
	 * See the sample input files for examples of the format.
	 */
	public void processFile() {
		ArrayList<String> lines = getFile();
		if (lines.size() == 0) {
			return;
		}
		int linesTotal = lines.size();
		int blankLineNum = 0;
		for (int i = 0; i < linesTotal; i++) {
			if (lines.get(i).isEmpty()) {
				blankLineNum++;
				if (blankLineNum == 1) {
					continue;
				}
			}
			if (blankLineNum == 0) {
				Candidate candidate = new Candidate(lines.get(i));
				candidates.add(candidate);
				continue;
			}

			VotingPaper votingPaper = new VotingPaper(lines.get(i));
			papers.add(votingPaper);
		}

	}

	/**
	 * Adds each formal vote to each candidate, both numbers of votes and numbers of wins.
	 * Returns the number of informal votes.
	 */
	public int conductCount() {
		int papersTotal = papers.size();
		int candidatesTotal = candidates.size();
		int informalVotesCount = 0;
		for (int i = 0; i < papersTotal; i++) {
			VotingPaper paper = papers.get(i);
			if (!paper.isFormal(candidatesTotal)) {
				informalVotesCount++;
				continue;
			}
			paper.updateVoteCounts(candidates);
			paper.updateWinCounts(candidates);
		}
		return informalVotesCount;
	}

	/**
	 * Returns and prints a summary of the election result. 
	 * See the sample output files for the required format. 
	 */
	public String getStandings() {
		int candidatesTotal = candidates.size();
		StringBuffer outputResultBuffer = new StringBuffer("");
		for (int i = 0; i < candidatesTotal; i++) {
			outputResultBuffer.append(candidates.get(i).getStanding());
				outputResultBuffer.append("\n");

		}
		return outputResultBuffer.toString();
	}

	/**
	 * Returns the winner of the election. 
	 * Selects the candidate with the highest number of votes; if multiple 
	 * candidates are equal, selects the one with the highest number of wins. 
	*/
	public Candidate winner() {
		int hightesVotes = -1;
		for (int i = 0; i < candidates.size(); i++) {
			if (hightesVotes < candidates.get(i).getNoOfVotes()) {
				hightesVotes = candidates.get(i).getNoOfVotes();
			} 
		}
		if (hightesVotes == -1) {
			return null;
		}
		List<Candidate> candidatesHasSameHighestVote = new ArrayList<Candidate>();
		for (int i = 0; i < candidates.size(); i++) {
			if (hightesVotes == candidates.get(i).getNoOfVotes()) {
				candidatesHasSameHighestVote.add(candidates.get(i));
			} 
		}
		int hightesWins = -1;
		if (candidatesHasSameHighestVote.size() > 1) {
			Candidate candidateHasHightesWins = null;
			for (int i = 0; i < candidatesHasSameHighestVote.size(); i++) {
				if (hightesWins < candidatesHasSameHighestVote.get(i).getNoOfWins()) {
					candidateHasHightesWins = candidatesHasSameHighestVote.get(i);
				} 
			}
			return candidateHasHightesWins;
		}else {
			return candidatesHasSameHighestVote.get(0);
		}
	}
}