package server.sports;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class SportsSimulator {

	private int homeScore;
	private int awayScore;

	private Random rand = new Random();

	public MatchResult getCurrentMatchResult() {
		MatchResult result = new MatchResult();
		result.setHomeTeam(homeScore);
		result.setAwayTeam(awayScore);
		return result;
	}

	public void updateResult() {
		if (homeScore >= 6 || awayScore >= 6) {
			homeScore = 0;
			awayScore = 0;
		} else if (rand.nextBoolean()) {
			homeScore++;
		} else {
			awayScore++;
		}
	}

}
