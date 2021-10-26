public class TableDataInt implements TableData {
    private int data;
    public TableDataInt() {
    }

    public String toString() {
        return Integer.toString(data);
    }

    public TableData makeCopy() {
        TableDataInt obj = null;
        try {
            obj = (TableDataInt) super.clone();
            obj.data = rnd.nextInt(100);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
