import java.sql.*;
import java.util.Scanner;

public class BankCustomer extends BankImp  {
    static Scanner in=new Scanner(System.in);
    public  void addCustomerDetails() throws SQLException {
        while (true) {
            System.out.println("1 for break 2 for continue");
            int n=in.nextInt();
            if (n==1) break;
            if (n==2) {
                String url = "jdbc:mysql://localhost:3306/bankmanagement";
                String userName = "root";
                String password = "Raman@123";
                String sql = "INSERT INTO bankcustomer ( cusName,mobNumber,address,gender) VALUES (?,?, ?,?)";
                System.out.println("Enter your customer Name");
                String name = in.next();
                System.out.println("Enter the mobileNumber");
                String mono = in.next();
                System.out.println("Enter address");
                String ad = in.next();
                System.out.println("Enter your gender");
                String gn = in.next();
                Connection con = DriverManager.getConnection(url, userName, password);
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.setString(2, mono);
                stmt.setString(3, ad);
                stmt.setString(4, gn);
                stmt.executeUpdate();
                con.close();
            }
        }
    }

}
