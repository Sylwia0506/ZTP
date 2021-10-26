public abstract class TableHeader {
    String type;
    public TableHeader() {
    }

    public String toString() {
       return type;
    }

    public abstract TableData createTableData();
}

class TableHeaderInt extends TableHeader {
    public TableHeaderInt() {
        type = "INT";
    }

    @Override
    public TableData createTableData() {
        return new TableDataInt();
    }
}
class TableHeaderDouble extends TableHeader {
    public TableHeaderDouble() {
        type = "DOUBLE";
    }

    @Override
    public TableData createTableData() {
        return new TableDataDouble();
    }
}
class TableHeaderFloat extends TableHeader {
    public TableHeaderFloat() {
        type = "FLOAT";
    }

    @Override
    public TableData createTableData() {
        return new TableDataDouble();
    }
}

class TableHeaderChar extends TableHeader {
    public TableHeaderChar() {
        type = "CHAR";
    }

    @Override
    public TableData createTableData() {
        return new TableDataChar();
    }
}

class TableHeaderBoolean extends TableHeader {
    public TableHeaderBoolean() {
        type = "BOOLEAN";
    }

    @Override
    public TableData createTableData() {
        return new TableDataBoolean();
    }
}

