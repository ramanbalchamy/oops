import java.sql.SQLException;

public interface Bank {
    public String login() throws SQLException;
    public void signup() throws SQLException;
    public void deposit() throws SQLException;
    public void withdrawal() throws SQLException;
    public void accountCreation() throws SQLException;
    public void transfer() throws SQLException;
    public void moneyStatement () throws SQLException;

}
