public class TableDataBoolean implements TableData {
    private boolean data;
    public TableDataBoolean() {
        data = rnd.nextBoolean();
    }

    public String toString() {
        return Boolean.toString(data);
    }
}
