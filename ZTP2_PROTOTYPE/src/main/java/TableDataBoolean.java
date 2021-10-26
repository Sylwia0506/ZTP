public class TableDataBoolean implements TableData {
    private boolean data;
    public TableDataBoolean() {
    }

    public String toString() {
        return Boolean.toString(data);
    }

    public TableData copy() {
        TableDataBoolean obj = null;
        try {
            obj = (TableDataBoolean) super.clone();
            obj.data = rnd.nextBoolean();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}

