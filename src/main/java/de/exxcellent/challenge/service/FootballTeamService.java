package de.exxcellent.challenge.service;

import de.exxcellent.challenge.domain.FootballTeam;

import java.util.Collection;

public interface FootballTeamService {

    FootballTeam findTeamWithSmallestDistance(Collection<FootballTeam> teams);
}
