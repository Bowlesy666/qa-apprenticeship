package lab03;

public class Program {
    public static void main(String[] args) {
        Account account1 = new Account(1, 100.00 , "David Bowles");

        try {
            account1.getDetails();
            account1.Withdraw(50.00);
            account1.getDetails();
            account1.Withdraw(60.00);
            account1.getDetails();
        } catch (IllegalArgumentException exceptionString) {
            System.out.println("\n\t*** " + exceptionString.getMessage() + "     ***\n");
        } finally {
            account1.close();
        }
    }

    // private static void log(String msg){
    //     File file = new File("log.txt");
    //     FileWriter fr = new FileWriter(file, true);
    //     BufferedWriter br = new BufferedWriter(fr);
    //     br.write(msg + "\r\n");
    //     br.close();
    //     fr.close();
    // }
}
