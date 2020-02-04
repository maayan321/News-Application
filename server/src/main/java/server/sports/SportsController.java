package server.sports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class SportsController {

	@Autowired
	private SportsService service;

	@RequestMapping("/sports/match")
	public ResponseEntity<MatchResult> getCurrentMatchResult() {
		MatchResult result = service.getCurrentMatchResult();
		return ResponseEntity.ok().body(result);
	}
}
