package server.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class WeatherController {

	@Autowired
	private WeatherService service;

	@RequestMapping("/weather/current")
	public ResponseEntity<Weather> getCurrentWeather() {
		Weather weather = service.getCurrentWeather();
		return ResponseEntity.ok().body(weather);
	}

	@RequestMapping("/weather/forecast")
	public ResponseEntity<WeatherForecast> getWeather(@RequestParam(defaultValue = "7") int days) {
		WeatherForecast forecast = service.getWeatherForecast(days);
		return ResponseEntity.ok().body(forecast);
	}
}
