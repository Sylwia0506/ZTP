package zad1;


interface IConnection { 
    char get(int index); 
    void set(int index, char c); 
    int length(); 
}

class Database { 
    private char[] tab;
    private Database(){
        tab = new char[100]; 
    };
    private static Database bd = null;
    
    public static IConnection getConnection() { 
        return Connection.getInstance();
    } 
    public static Database getInstance() {
        if (bd == null) {
            return bd = new Database();
        }
        return bd;
    }
    
    private static class Connection implements IConnection { 
        private Database db;        
        private static int index = 0;
        private static Connection[] connection;

    private Connection (Database db) {
        this.db = db;
    }
    private Connection () {
        db = Database.getInstance();
    }
    
    public static IConnection getInstance(){    
        if (connection == null) {
            //Multitons: there exists only three of them returned by the getInstance method 
            connection = new Connection[]{ new Connection(),new Connection(),new Connection() };
        }
        //round-robin fasion
        index = (index + 1) % connection.length;
        return connection[index]; 
    } 
    public char get(int index) { 
      return db.tab[index]; 
    } 
    public void set(int index, char c) {
      db.tab[index] = c; 
    }
    public int length() { 
      return db.tab.length; 
    } 
  } 
} 
