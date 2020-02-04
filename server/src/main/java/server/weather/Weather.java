package server.weather;

public class Weather {

	private String day;
	private int degrees;
	private WeatherConditions conditions;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getDegrees() {
		return degrees;
	}

	public void setDegrees(int degrees) {
		this.degrees = degrees;
	}

	public WeatherConditions getConditions() {
		return conditions;
	}

	public void setConditions(WeatherConditions conditions) {
		this.conditions = conditions;
	}
}
