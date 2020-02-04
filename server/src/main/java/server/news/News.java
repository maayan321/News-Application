package server.news;

import java.util.List;

public class News {

	private String teaser;
	private List<String> article;

	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public List<String> getArticle() {
		return article;
	}

	public void setArticle(List<String> article) {
		this.article = article;
	}

}
