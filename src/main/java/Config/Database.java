package Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
        private static Connection db;
        static {
            try {
                String Url = "jdbc:postgresql://localhost:5433/credit_simulation";
                String Username = "postgres";
                String Password = "kamal123";
                Class.forName("org.postgresql.Driver");
                db=DriverManager.getConnection(Url, Username, Password);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        public static Connection getconn(){
            return db;
        }
}
