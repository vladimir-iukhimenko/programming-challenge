package de.exxcellent.challenge.parser.impl;

import de.exxcellent.challenge.enumerated.DataSources;
import de.exxcellent.challenge.exception.ReadFileException;
import de.exxcellent.challenge.parser.api.AbstractParser;
import de.exxcellent.challenge.parser.api.Row;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CsvParser extends AbstractParser {

    @Override
    public DataSources getDataSource() {
        return DataSources.CSV;
    }

    @Override
    public List<Row> readData(String filePath) {
        var result = new ArrayList<Row>();
        try (var reader = new BufferedReader(new InputStreamReader(getFileAsStream(filePath)))) {
            var header = reader.readLine();
            var columnNames = getFormattedColumnNames(Arrays.stream(header.split(",")).collect(Collectors.toList()));
            var line = reader.readLine();
            while (line != null) {
                var rowValues = Arrays.stream(line.split(",")).collect(Collectors.toList());
                var row = new Row();
                row.addAllColumn(IntStream
                        .range(0, columnNames.size())
                        .boxed()
                        .map(index -> new Row.Pair(columnNames.get(index), rowValues.get(index)))
                        .collect(Collectors.toList()));
                result.add(row);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Apply convention how column should be named
    private List<String> getFormattedColumnNames(Collection<String> columnNames) {
        return columnNames
                .stream()
                .map( it ->
                        it.replaceAll("\\s+", "_").toLowerCase()
                )
                .collect(Collectors.toList());
    }

    private InputStream getFileAsStream(String filePath) {
        Objects.requireNonNull(filePath, "fileName must not be null!");
        return Optional.ofNullable(getClass().getResourceAsStream(filePath)).orElseThrow(() -> new ReadFileException("Could not found file under filepath"));
    }
}
