import java.sql.*;

public class BankEmployee extends BankImp{
public void viewCustomerDetails() throws SQLException {
    System.out.println("Enter the cusId ");
    int vcd= in.nextInt();
    String qu="select * from bankcustomer where cusId="+vcd;
    Connection con = DriverManager.getConnection(url, userName, password);
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(qu);
    rs.next();
    int o=rs.getInt(1);
    String p= rs.getString(2);
    String q= rs.getString(3);
    String r= rs.getString(4);
    String s= rs.getString(5);
    System.out.println();
    System.out.println(o+"  "+p+"  "+q+"    "+r+"    "+s);
}
}
