package database;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private String usuario = "root";
    private String senha = "root";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "dbcoracaopet";
    
    public Connection getConnection(){
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + bd + "?serverTimezone=UTC", usuario, senha);
            
            System.out.println("Conexão executada com sucesso.");
            
            return c;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
