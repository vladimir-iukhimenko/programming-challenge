package de.exxcellent.challenge.dto;

import de.exxcellent.challenge.enumerated.DataSources;

public class Request {
    private DataSources dataSource;
    private String filePath;

    public Request(DataSources dataSource, String filePath) {
        this.dataSource = dataSource;
        this.filePath = filePath;
    }

    public DataSources getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSources dataSource) {
        this.dataSource = dataSource;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
