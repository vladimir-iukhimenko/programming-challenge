package de.exxcellent.challenge.service.impl;

import de.exxcellent.challenge.domain.FootballTeam;
import de.exxcellent.challenge.service.FootballTeamService;

import java.util.Collection;
import java.util.Comparator;

public class FootballTeamServiceImpl implements FootballTeamService {


    @Override
    public FootballTeam findTeamWithSmallestDistance(Collection<FootballTeam> teams) {
        return teams.stream().min(Comparator.comparing(FootballTeam::getGoalsDistance)).get();
    }
}
