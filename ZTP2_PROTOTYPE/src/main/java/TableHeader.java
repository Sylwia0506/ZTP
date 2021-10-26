public class TableHeader {
    String type;
    TableData tableData;

    public TableHeader(String type, TableData tableData) {
        this.tableData = tableData;
        this.type = type;
    }

    public TableData createTable() {
        return tableData.copy();
    }

    public String toString() {
        return type;
    }

}

