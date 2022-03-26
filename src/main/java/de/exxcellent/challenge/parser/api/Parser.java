package de.exxcellent.challenge.parser.api;

import de.exxcellent.challenge.enumerated.DataSources;

import java.util.List;

public interface Parser {

    List<Row> readData(String filePath);

    DataSources getDataSource();


}
