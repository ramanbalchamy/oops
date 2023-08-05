import java.sql.*;
import java.util.Scanner;
public class BankImp implements Bank{   //com.mysql.jdbc.Driver--driver class
       String st= String.valueOf(java.time.LocalDate.now());
     static Scanner in=new Scanner(System.in);
     static String url = "jdbc:mysql://localhost:3306/bankmanagement";
     static String userName = "root";
    static String password = "Raman@123";
    @Override
    public String login() throws SQLException {
            System.out.println("Enter the userName");
            String userInput1 = in.next();
            System.out.println("Enter your password");
            String userInput2 = in.next();
            String query = "select userName,password,role  from bankempadmin where userName='" + userInput1 + "' ";
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            String x =rs.getString(1);
            String y=rs.getString(2);
            String z=rs.getString(3);
        if (x.equals(userInput1) && y.equals(userInput2)){
            System.out.print("login successfully !! your role is  "+z);
            return  z;
        }else
        {System.out.println("Doesn't match Details...signUp please");
            return null;
        }

    }

    @Override
    public  void signup() throws SQLException {
                String sql = "INSERT INTO bankempadmin ( userName,password,role) VALUES (?,?,?)";
                System.out.println("Enter your new user Name");
                String name = in.next();
                System.out.println("Enter the password");
                String pass = in.next();
                System.out.println("Enter role");
                String role = in.next();
                Connection con = DriverManager.getConnection(url, userName, password);
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.setString(2, pass);
                stmt.setString(3, role);
                stmt.executeUpdate();
                con.close();
            }
    @Override
    public   void deposit() throws SQLException {
        String ty="deposit";
        System.out.println("Enter the Account Number");
        int an=in.nextInt();
        System.out.println("Enter the amount");
        int amt=in.nextInt();
        String sql = "INSERT INTO transHistory ( transType,fk_accNo,transAmount,date) VALUES (?,?,?,?)";
        String query="select accBalance from accCreation where accNumber='"+an+"'";
        String query1="update accCreation set accBalance=("+(fetchAmt(an)+amt)+") where accNumber='"+an+"'";
        Connection con = DriverManager.getConnection(url, userName, password);
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1,ty);
        stmt.setInt(2,an);
        stmt.setInt(3,amt);
        stmt.setString(4,st);
        stmt.executeUpdate();
        Statement st = con.createStatement();
        st.executeUpdate(query1);
        ResultSet rs = st.executeQuery(query);
        rs.next();
        System.out.println("Deposited successfully");
        con.close();

    }

    @Override
    public void withdrawal() throws SQLException {
        String ty="withdrawal";
        System.out.println("Enter the Account Number");
        int an=in.nextInt();
        System.out.println("Enter the amount");
        int amt=in.nextInt();
        String sql = "INSERT INTO transHistory ( transType,fk_accNo,transAmount,date) VALUES (?,?,?,?)";
        String query="select accBalance from accCreation where accNumber='"+an+"'";
        String query1="update accCreation set accBalance=("+(fetchAmt(an)-amt)+") where accNumber='"+an+"'";
        Connection con = DriverManager.getConnection(url, userName, password);
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1,ty);
        stmt.setInt(2,an);
        stmt.setInt(3,amt);
        stmt.setString(4,st);
        stmt.executeUpdate();
        Statement st = con.createStatement();
        st.executeUpdate(query1);
        ResultSet rs = st.executeQuery(query);
        rs.next();
        System.out.println("Withdrawal successfully");
        con.close();

    }

    @Override
    public  void accountCreation() throws SQLException {
        System.out.println("Enter the cusId for acc creation");
        int cid=in.nextInt();
        System.out.println("Enter the ifsc for bankDetails");
        int ifsc=in.nextInt();
        String sql = "INSERT INTO accCreation ( accType,accBalance,fk_ifsc,fk_cusId,accHolderName,bankName) VALUES (?,?,?,?,?,?)";
        String query = "select cusName,mobNumber,address,gender  from bankcustomer where cusId='" +cid+"'";
        String query1 = "select bankName,branch  from bankDetails where ifsc='" +ifsc+"'";
        Connection con = DriverManager.getConnection(url, userName, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();

        String a=rs.getString(1);
        String b=rs.getString(2);
        String c=rs.getString(3);
        String d=rs.getString(4);
        ResultSet rs1 = st.executeQuery(query1);
        rs1.next();
        String e=rs1.getString(1);
        String  f=rs1.getString(2);
        System.out.println("Customer details  "+a+"  "+b+"   "+c+"   "+d);
        System.out.println("Bank Details   "+e+"   "+f);
        System.out.println();
        System.out.println("Enter the account Type");
        String at=in.next();
        System.out.println("Enter the Initial Amount");
        int amt= in.nextInt();
        System.out.println("Enter the accountHolderName");
        String name=in.next();
        System.out.println("Enter the bankName");
        String bn=in.next();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1,at);
        stmt.setInt(2,amt);
        stmt.setInt(3,ifsc);
        stmt.setInt(4,cid);
        stmt.setString(5,name);
        stmt.setString(6,bn);
        stmt.executeUpdate();
        con.close();
        System.out.println("Account created successfully");
    }

    @Override
    public void transfer() throws SQLException {
        String ta="Debited Account ->";
        System.out.println("Enter 1 account Number ");
        int ac1= in.nextInt();
        System.out.println("Enter 2 account Number ");
        int ac2= in.nextInt();
        System.out.println("Enter amount want transaction");
        int amt=in.nextInt();
        String sql = "INSERT INTO transHistory ( transType,fk_accNo,transAmount,toAccno,date) VALUES (?,?,?,?,?)";
        String query="select accBalance from accCreation where accNumber='"+ac1+"'";
        String query1="select accBalance from accCreation where accNumber='"+ac2+"'";
        String qry="update accCreation set accBalance=("+(fetchAmt(ac1)-amt)+") where accNumber='"+ac1+"'";
        String qry1="update accCreation set accBalance=("+(fetchAmt(ac2)+amt)+") where accNumber='"+ac2+"'";
        Connection con = DriverManager.getConnection(url, userName, password);
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1,ta);
        stmt.setInt(2,ac1);
        stmt.setInt(3,amt);
        stmt.setInt(4,ac2);
        stmt.setString(5,st);
        stmt.executeUpdate();
        Statement st = con.createStatement();
        Statement st1 = con.createStatement();
        st.executeUpdate(qry);
        st1.executeUpdate(qry1);
        ResultSet rs = st.executeQuery(query);
        ResultSet rs1 = st1.executeQuery(query1);
        rs.next();
        rs1.next();
        System.out.println("transfer successfully");
        con.close();


    }
    public static int fetchAmt(int amt) throws SQLException {
        String query="select accBalance from accCreation where accNumber='"+amt+"'";
        Connection con = DriverManager.getConnection(url,userName,password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        int balance =rs.getInt(1);
        con.close();
        return balance;
    }

    public  void moneyStatement() throws SQLException {
        System.out.println("Enter the AccNumber");
        int msa= in.nextInt();
        String qu="select transType,transAmount,toAccno,date from transHistory where fk_accNo="+msa;
        Connection con = DriverManager.getConnection(url, userName, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(qu);
        while (rs.next()) {
            String p = rs.getString(1);
            int q = rs.getInt(2);
            int r = rs.getInt(3);
            String s = rs.getString(4);
            System.out.println(p + "  " + q + "   " + r + "   " + s);

        }
    }
}
