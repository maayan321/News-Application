package server.subscribe;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
public class SubscribeController {

	@Autowired
	private SubscribeService service;

	@RequestMapping("/subscribe")
	public ResponseEntity<SubscribeResult> subscribe(HttpSession session, @RequestBody String email) {
		SubscribeResult result = service.subscribe(session.getId(), email);
		return ResponseEntity.ok().body(result);
	}
}
