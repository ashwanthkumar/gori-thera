package in.ashwanthkumar;

import org.apache.hadoop.hbase.client.Result;

import java.util.Map;

public class Record {
    private String string;
    private Versioned<String> versionedString;

    private Map<String, String> map;
    private Versioned<Map<String, String>> versionedMap;

    private Result hbaseRow;

    public Result getHBaseRow() {
        return hbaseRow;
    }

    public void setHBaseRow(Result hbaseRow) {
        this.hbaseRow = hbaseRow;
    }
}
