package server.news;

import java.io.InputStream;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NewsSimulator {

	private NewsDB db;

	private Random rand = new Random();

	private News currentNews;

	@PostConstruct
	public void init() throws Exception {
		try (InputStream in = this.getClass().getResourceAsStream("/newsDB.json")) {
			ObjectMapper mapper = new ObjectMapper();
			db = mapper.readValue(in, NewsDB.class);
		}
	}

	public void updateCurrentNews() {
		List<News> newsList = db.getNewsList();
		int index = rand.nextInt(newsList.size());
		currentNews = newsList.get(index);
	}

	public News getCurrentNews() {
		return currentNews;
	}

}
