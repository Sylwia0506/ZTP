public class TableDataChar implements TableData {
    private char data;
    public TableDataChar() {
    }

    public String toString() {
        return Character.toString(data);
    }

    public TableData copy() {
        TableDataChar obj = null;
        try {
            obj = (TableDataChar) super.clone();
            obj.data = (char) ('a' + rnd.nextInt(26));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}

