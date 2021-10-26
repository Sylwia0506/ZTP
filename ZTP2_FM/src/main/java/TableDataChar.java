public class TableDataChar implements TableData {

    private char data;
    public TableDataChar() {
        data = (char) ('a' + rnd.nextInt(26));
    }

    public String toString() {
        return Character.toString(data);
    }
}
