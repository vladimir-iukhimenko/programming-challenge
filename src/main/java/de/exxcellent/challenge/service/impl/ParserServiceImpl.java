package de.exxcellent.challenge.service.impl;

import de.exxcellent.challenge.dto.Request;
import de.exxcellent.challenge.parser.ParserFactory;
import de.exxcellent.challenge.service.ParserService;

import java.util.Collection;

public class ParserServiceImpl implements ParserService {

    @Override
    public <T> Collection<T> parseData(Request request, Class<T> clazz) {
        return ParserFactory.resolveParser(request.getDataSource()).readAndConvert(request.getFilePath(), clazz);
    }
}
