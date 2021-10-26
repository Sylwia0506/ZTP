public class TableDataInt implements TableData {
    private int data;
    public TableDataInt() {
    }

    public String toString() {
        return Integer.toString(data);
    }

    public TableData copy() {
        TableDataInt obj = null;
        try {
            obj = (TableDataInt) super.clone();
            obj.data = rnd.nextInt(1000);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
