package de.exxcellent.challenge;

import de.exxcellent.challenge.domain.FootballTeam;
import de.exxcellent.challenge.domain.WeatherData;
import de.exxcellent.challenge.dto.Request;
import de.exxcellent.challenge.enumerated.DataSources;
import de.exxcellent.challenge.service.FootballTeamService;
import de.exxcellent.challenge.service.ParserService;
import de.exxcellent.challenge.service.WeatherDataService;
import de.exxcellent.challenge.service.impl.FootballTeamServiceImpl;
import de.exxcellent.challenge.service.impl.ParserServiceImpl;
import de.exxcellent.challenge.service.impl.WeatherDataServiceImpl;


/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …


        ParserService parserService = new ParserServiceImpl();
        var footballTeamsData = parserService.parseData(new Request(DataSources.CSV, "/de/exxcellent/challenge/football.csv"), FootballTeam.class);
        var weatherData = parserService.parseData(new Request(DataSources.CSV, "/de/exxcellent/challenge/weather.csv"), WeatherData.class);

        FootballTeamService footballTeamService = new FootballTeamServiceImpl();
        WeatherDataService weatherDataService = new WeatherDataServiceImpl();

        String dayWithSmallestTempSpread = weatherDataService.findDayWithSmallestSpread(weatherData).getDay().toString();     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = footballTeamService.findTeamWithSmallestDistance(footballTeamsData).getTeam(); // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
