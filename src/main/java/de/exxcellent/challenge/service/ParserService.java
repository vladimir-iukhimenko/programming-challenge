package de.exxcellent.challenge.service;

import de.exxcellent.challenge.dto.Request;

import java.util.Collection;

public interface ParserService {

    <T> Collection<T> parseData(Request request, Class<T> clazz);
}
