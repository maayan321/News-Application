package server.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

	@Autowired
	private NewsSimulator simulator;

	public News getNews() {
		simulator.updateCurrentNews();
		News currentNews = simulator.getCurrentNews();
		return currentNews;
	}

	public String getArticle() {
		News currentNews = simulator.getCurrentNews();
		List<String> article = currentNews.getArticle();
		StringBuilder builder = new StringBuilder();
		for (String line : article) {
			if (builder.length() > 0) {
				builder.append("<p>");
			}
			builder.append(line);
		}
		return builder.toString();
	}

}
