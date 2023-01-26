import java.util.Scanner;

class Bank_account {
    String name;
    String user_name;
    String password;
    String account_no;
    int transaction = 0;
    float bal = 100000f; // balance
    String transHis = ""; // transaction history
    Scanner s = new Scanner(System.in);

    public void registration() {

        System.out.println("enter your name:");
        name = s.nextLine();
        System.out.println("enter your Username:");
        user_name = s.nextLine();
        System.out.println("enter your Password:");
        password = s.nextLine();
        System.out.println("enter your account number:");
        account_no = s.nextLine();
        System.out.println("***REGISTRATION COMPLETED***");

    }

    public boolean login() {

        boolean LOGIN = false;
        while (!LOGIN) {
            System.out.println("enter your user name:");
            String USERNAME = s.nextLine();
            if (USERNAME.equals(user_name)) {
                while (!LOGIN) {
                    System.out.println("enter password:");
                    String PASSWORD = s.nextLine();
                    if (PASSWORD.equals(password)) {
                        System.out.println("login successful!");
                        LOGIN = true;
                    } else {
                        System.out.println("incorrect");
                    }
                }
            } else
                System.out.println("username not found");
        }
        return LOGIN;
    }

    public void withdraw() {
        System.out.println("***enter amount to withdraw***");
        float AMOUNT = s.nextFloat();
        try {
            if (bal >= AMOUNT) {
                transaction++;
                bal -= AMOUNT;
                System.out.println("successful Withdraw");
                String str = AMOUNT + "Rs Withdraw\n";
                transHis = transHis.concat(str);
            } else {
                System.out.println("insufficient balance kindly note!");
            }
        } catch (Exception e) {

        }
    }

    public void deposit() {
        System.out.println("***enter amount to deposit***");
        float AMOUNT1 = s.nextFloat();
        try {
            if (AMOUNT1 <= 100000f) {
                transaction++;
                bal += AMOUNT1;
                System.out.println("successful deposit");
                String str = AMOUNT1 + "Rs Deposited\n";
                transHis = transHis.concat(str);
            } else {
                System.out.println("sorry... limit is 100000.00");
            }
        } catch (Exception e) {

        }
    }

    public void transfer() {
        System.out.println("enter thr receipant's name");
        String rece = s.nextLine();
        System.out.println("enter the amount to transfer");
        float AMOUNT2 = s.nextFloat();

        try {
            if (bal >= AMOUNT2) {
                if (AMOUNT2 <= 50000f) {
                    transaction++;
                    bal -= AMOUNT2;
                    System.out.println("Successful transaction to " + rece);
                    String str = AMOUNT2 + "Rs transfer to " + rece + "\n";
                    transHis = transHis.concat(str);
                } else {
                    System.out.println("sorry... limit is 500000.00");
                }
            } else {
                System.out.println("insufficient balance");
            }

        } catch (Exception e) {

        }
    }

    public void checkBalance() {
        System.out.println("\n" + bal + "Rs");
    }

    public void transHistory() {
        if (transaction == 0) {
            System.out.println("empty");

        } else
            System.out.println(transHis);
    }

}

public class ATM {

    public static int takeIntrgerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner s1 = new Scanner(System.in);
                input = s1.nextInt();
                flag = true;
                if (flag && input > limit || input < 1) {
                    System.out.println("choose the number between 1 to" + limit);
                    flag = false;

                }

            } catch (Exception e) {
                System.out.println("enter only the integer  value:");
                flag = false;
            }
        }
        ;
        return input;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("\n**** WELCOME TO ATM SYSTEM ****\n");
        System.out.println("1.REGISTER \n2.EXIT");
        System.out.println("enter your choice:");
        int ch = takeIntrgerInput(2);

        if (ch == 1) {
            Bank_account b = new Bank_account();
            b.registration();
            while (true) {
                System.out.println("\n1.LOGIN \n2.EXIT");
                System.out.println("enter your choice:");
                int c = takeIntrgerInput(2);
                if (c == 1) {
                    if (b.login()) {
                        System.out.println("\n\n **** welcome back " + b.name + "*****\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check balance \n5.History");
                            System.out.println("enter your choice:");
                            int c1 = takeIntrgerInput(6);
                            switch (c1) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }

}