package de.exxcellent.challenge.parser.api;

import de.exxcellent.challenge.enumerated.DataSources;

import java.util.Collection;
import java.util.List;

public interface Parser {

    List<Row> readData(String filePath);

    DataSources getDataSource();

    <T> Collection<T> readAndConvert(String filePath, Class<T> clazz);


}
