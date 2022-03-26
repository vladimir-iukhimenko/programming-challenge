package de.exxcellent.challenge.parser.api;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Row {
    private Map<String, String> rowData;

    public Row() {
        this.rowData = new HashMap<>();
    }

    public void addColumn(String columnName, String value) {
        rowData.put(columnName, value);
    }

    public void addColumn(Pair data) {
        rowData.put(data.getColumnName(), data.getValue());
    }

    public void addAllColumn(Collection<Pair> data) {
        data.forEach(this::addColumn);
    }

    public String getValue(String columnName) {
        return rowData.get(columnName);
    }

    public static class Pair {
        private String columnName;
        private String value;

        public Pair() {
        }

        public Pair(String columnName, String value) {
            this.columnName = columnName;
            this.value = value;
        }

        public String getColumnName() {
            return columnName;
        }

        public String getValue() {
            return value;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
