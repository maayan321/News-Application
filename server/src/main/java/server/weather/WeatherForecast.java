package server.weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherForecast {

	List<Weather> forecast = new ArrayList<>();

	public List<Weather> getForecast() {
		return forecast;
	}

	public void setForecast(List<Weather> forecast) {
		this.forecast = forecast;
	}

	public void add(Weather weather) {
		forecast.add(weather);
	}

}
