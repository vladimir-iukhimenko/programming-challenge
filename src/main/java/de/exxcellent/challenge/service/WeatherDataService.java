package de.exxcellent.challenge.service;

import de.exxcellent.challenge.domain.WeatherData;

import java.util.Collection;

public interface WeatherDataService {

    WeatherData findDayWithSmallestSpread(Collection<WeatherData> days);
}
