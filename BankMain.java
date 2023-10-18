import java.sql.SQLException;
import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) throws SQLException {
        Scanner in=new Scanner(System.in);
        BankEmployee bankEmployee=new BankEmployee();
        BankAdmin bankAdmin=new BankAdmin();
        BankCustomer bankCustomer=new BankCustomer();
        System.out.println("Pick the number for your's\n 1 BankAdmin\n 2 BankEmployee\n 3 BankCustomer\n");
        int n=in.nextInt();
        if (n==1) {
            while (true) {
                System.out.println(" 1 Continue\n 2 Break\n");
                int nn = in.nextInt();
                if (nn == 2) {
                    break;
                }
                if (nn == 1) {
                    System.out.println("Enter the function you want\n 1 signup\n 2 login\n");
                    int ne = in.nextInt();
                    switch (ne) {
                        case 1:
                            bankAdmin.signup();
                            break;
                        case 2:
                            bankAdmin.login();
                                while (true) {
                                    System.out.println(" 1 Continue\n 2 Break\n");
                                    int nnn = in.nextInt();
                                    if (nnn == 2) {
                                        break;
                                    }

                                 if(nnn==1) {
                                     System.out.println("Enter the function  1 accCreate\n 2 deposit\n" +
                                             " 3 withdrawal\n 4 transfer\n  5 deleteAcc\n 6 moneyStatement ");
                                     int av = in.nextInt();

                                     switch (av) {
                                         case 1:
                                             bankAdmin.accountCreation();
                                             break;
                                         case 2:
                                             bankAdmin.deposit();
                                             break;
                                         case 3:
                                             bankAdmin.withdrawal();
                                             break;
                                         case 4:
                                             bankAdmin.transfer();
                                             break;
                                         case 5:
                                             bankAdmin.delAcc();
                                             break;
                                         case 6:
                                             bankAdmin.moneyStatement();
                                             break;
                                     }
                                 }
                                }

                            break;
                    }
                }
            }
        }
        if (n==2) {
            while (true) {
                System.out.println(" 1 Continue\n 2 Break\n");
                int nn = in.nextInt();
                if (nn == 2) {
                    break;
                }
                if (nn == 1) {
                    System.out.println("Enter the function you want\n 1 signup\n 2 login\n");
                    int ne = in.nextInt();
                    switch (ne) {
                        case 1:
                            bankEmployee.signup();
                            break;
                        case 2:
                            bankEmployee.login();
                            while (true) {
                                System.out.println(" 1 Continue\n 2 Break\n");
                                int nnn = in.nextInt();
                                if (nnn == 2) {
                                    break;
                                }

                                if(nnn==1) {
                                    System.out.println("Enter the function  1 accCreate\n 2 deposit\n 3 withdrawal\n " +
                                            "4 transfer\n  5 viewcustDetails\n 6 moneyStatement ");
                                    int av = in.nextInt();

                                    switch (av) {
                                        case 1:
                                            bankEmployee.accountCreation();
                                            break;
                                        case 2:
                                            bankEmployee.deposit();
                                            break;
                                        case 3:
                                            bankEmployee.withdrawal();
                                            break;
                                        case 4:
                                            bankEmployee.transfer();
                                            break;
                                        case 5:
                                            bankEmployee.viewCustomerDetails();
                                            break;
                                        case 6:
                                            bankEmployee.moneyStatement();
                                            break;
					default : System.out.println("wrong detail");
                                    }
                                }
                            }
                            break;
                    }
                }
            }
        }
        if (n==3){
            System.out.println(" 1 moneyStatement\n 2 addCustomer");
            int vcs= in.nextInt();
            if (vcs==1){
            bankCustomer.moneyStatement();}
            if (vcs==2){
                bankCustomer.addCustomerDetails();
            }
        }

    }
}
