import java.sql.*;

public class BankAdmin extends BankImp{
    public void delAcc() throws SQLException {
        System.out.println("Enter the accNumber for delete");
        int da=in.nextInt();
        String sql="delete from accCreation where accNumber="+da;
        Connection con = DriverManager.getConnection(url, userName, password);
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.executeUpdate();
        con.close();
        System.out.println("Account delete successfully");
    }
}
