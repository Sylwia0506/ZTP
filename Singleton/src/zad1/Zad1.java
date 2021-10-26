package zad1;


public class Zad1 { //Teste Class

    public static void main(String[] args) {

        IConnection s1 = Database.getConnection();
        IConnection s2 = Database.getConnection();
        IConnection s3 = Database.getConnection();
        IConnection s4 = Database.getConnection();
        
   
        System.out.println(s1.get(0));
        
        s1.set(0, 'a');
        s2.set(1, 'b');
        System.out.println(s3.get(0));
        System.out.println(s4.get(1));
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

    }
    
}
