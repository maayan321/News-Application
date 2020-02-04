package server.sports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportsService {

	@Autowired
	private SportsSimulator simulator;

	public MatchResult getCurrentMatchResult() {
		simulator.updateResult();
		return simulator.getCurrentMatchResult();
	}

}
