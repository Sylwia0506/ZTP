public class TableDataFloat implements TableData {

    private double data;
    public TableDataFloat() {
        data = rnd.nextFloat();
    }

    public String toString() {
        return Double.toString(data);
    }
}
