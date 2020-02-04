package server.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class NewsController {

	@Autowired
	private NewsService service;

	@RequestMapping("/news/teaser")
	public ResponseEntity<News> getNews() {
		News news = service.getNews();
		return ResponseEntity.ok().body(news);
	}

	@RequestMapping("/news/article")
	public ResponseEntity<String> getArticle() {
		String article = service.getArticle();
		return ResponseEntity.ok().body(article);
	}
}
