public class TableDataDouble implements TableData {
    private double data;
    public TableDataDouble() {
    }

    public String toString() {
        return Double.toString(data);
    }

    public TableData makeCopy() {
        TableDataDouble obj = null;
        try {
            obj = (TableDataDouble) super.clone();
            obj.data = rnd.nextDouble();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}

