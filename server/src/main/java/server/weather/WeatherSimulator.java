package server.weather;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class WeatherSimulator {

	private Random rand = new Random();

	public Weather generateWeather(int dayOffset) {
		Weather weather = new Weather();
		String day = getDay(dayOffset);
		weather.setDay(day);
		WeatherConditions weatherConditions = getWeatherConditions();
		weather.setConditions(weatherConditions);
		int degrees = getDegrees(weatherConditions);
		weather.setDegrees(degrees);
		return weather;
	}

	private String getDay(int dayOffset) {
		LocalDate today = LocalDate.now();
		LocalDate targetDate = today.plusDays(dayOffset);
		return targetDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	}

	private WeatherConditions getWeatherConditions() {
		WeatherConditions[] weatherConditions = WeatherConditions.values();
		int num = weatherConditions.length;
		int index = rand.nextInt(num);
		return weatherConditions[index];
	}

	private int getDegrees(WeatherConditions weatherConditions) {
		int min = 0;
		switch (weatherConditions) {
		case SUNNY:
			min = 25;
			break;
		case PARTLY_CLOUDY:
			min = 20;
			break;
		case CLOUDY:
			min = 15;
			break;
		case RAIN:
			min = 10;
			break;
		}
		return min + rand.nextInt(5);
	}

}
