package server.subscribe;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class SubscribeService {

	private Map<String, String> subscriptions = new ConcurrentHashMap<>();

	public SubscribeResult subscribe(String sessionId, String email) {
		SubscribeResult result = new SubscribeResult();
		String currentEmail = subscriptions.get(sessionId);
		if (currentEmail == null) {
			subscriptions.put(sessionId, email);
			result.setSuccesful(true);
		} else {
			result.setSuccesful(false);
			result.setErrorMessage("You are already subscribed with the email " + currentEmail);
		}
		System.out.println(subscriptions);
		return result;
	}

}
