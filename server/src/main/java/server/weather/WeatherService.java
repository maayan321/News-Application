package server.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

	@Autowired
	private WeatherSimulator simulator;

	public Weather getCurrentWeather() {
		return simulator.generateWeather(0);
	}

	public WeatherForecast getWeatherForecast(int days) {
		WeatherForecast forecast = new WeatherForecast();
		for (int i = 1; i <= days; i++) {
			forecast.add(simulator.generateWeather(i));
		}
		return forecast;
	}

}
