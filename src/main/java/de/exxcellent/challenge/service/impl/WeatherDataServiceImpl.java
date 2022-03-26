package de.exxcellent.challenge.service.impl;

import de.exxcellent.challenge.domain.WeatherData;
import de.exxcellent.challenge.service.WeatherDataService;

import java.util.Collection;
import java.util.Comparator;

public class WeatherDataServiceImpl implements WeatherDataService {


    @Override
    public WeatherData findDayWithSmallestSpread(Collection<WeatherData> days) {
        return days.stream().min(Comparator.comparingInt(WeatherData::getTemperatureSpread)).get();
    }
}
