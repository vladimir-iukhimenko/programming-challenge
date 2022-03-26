package de.exxcellent.challenge.parser.api;

import java.util.List;

public interface Parser {

    List<Row> readData(String filePath);


}
