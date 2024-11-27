package lab08;

public class Program {
    
    public static void main(String[] args) {
        String banner = """
        
 ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄               ▄  ▄▄▄▄▄▄▄▄▄▄▄                     
▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌             ▐░▌▐░░░░░░░░░░░▌                    
 ▀▀▀▀▀█░█▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌ ▐░▌           ▐░▌ ▐░█▀▀▀▀▀▀▀█░▌                    
      ▐░▌    ▐░▌       ▐░▌  ▐░▌         ▐░▌  ▐░▌       ▐░▌                    
      ▐░▌    ▐░█▄▄▄▄▄▄▄█░▌   ▐░▌       ▐░▌   ▐░█▄▄▄▄▄▄▄█░▌                    
      ▐░▌    ▐░░░░░░░░░░░▌    ▐░▌     ▐░▌    ▐░░░░░░░░░░░▌                    
      ▐░▌    ▐░█▀▀▀▀▀▀▀█░▌     ▐░▌   ▐░▌     ▐░█▀▀▀▀▀▀▀█░▌                    
      ▐░▌    ▐░▌       ▐░▌      ▐░▌ ▐░▌      ▐░▌       ▐░▌                    
 ▄▄▄▄▄█░▌    ▐░▌       ▐░▌       ▐░▐░▌       ▐░▌       ▐░▌                    
▐░░░░░░░▌    ▐░▌       ▐░▌        ▐░▌        ▐░▌       ▐░▌                    
 ▀▀▀▀▀▀▀      ▀         ▀          ▀          ▀         ▀                     
                                                                              
 ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄  ▄               ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄         
▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░▌             ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░▌        
▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌ ▐░▌           ▐░▌  ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌       
▐░▌       ▐░▌▐░▌       ▐░▌  ▐░▌         ▐░▌       ▐░▌     ▐░▌       ▐░▌       
▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄█░▌   ▐░▌       ▐░▌        ▐░▌     ▐░▌       ▐░▌       
▐░▌       ▐░▌▐░░░░░░░░░░░▌    ▐░▌     ▐░▌         ▐░▌     ▐░▌       ▐░▌       
▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀█░▌     ▐░▌   ▐░▌          ▐░▌     ▐░▌       ▐░▌       
▐░▌       ▐░▌▐░▌       ▐░▌      ▐░▌ ▐░▌           ▐░▌     ▐░▌       ▐░▌       
▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌       ▐░▐░▌        ▄▄▄▄█░█▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌       
▐░░░░░░░░░░▌ ▐░▌       ▐░▌        ▐░▌        ▐░░░░░░░░░░░▌▐░░░░░░░░░░▌        
 ▀▀▀▀▀▀▀▀▀▀   ▀         ▀          ▀          ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀         
                                                                              
 ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄  ▄         ▄  ▄            ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄ 
▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░▌          ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░▌       ▐░▌▐░▌          ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ 
▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌          ▐░▌          ▐░▌          
▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌▐░▌   ▄   ▐░▌▐░▌          ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ 
▐░░░░░░░░░░▌ ▐░▌       ▐░▌▐░▌  ▐░▌  ▐░▌▐░▌          ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
▐░█▀▀▀▀▀▀▀█░▌▐░▌       ▐░▌▐░▌ ▐░▌░▌ ▐░▌▐░▌          ▐░█▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀█░▌
▐░▌       ▐░▌▐░▌       ▐░▌▐░▌▐░▌ ▐░▌▐░▌▐░▌          ▐░▌                    ▐░▌
▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌▐░▌░▌   ▐░▐░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄█░▌
▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░░▌     ▐░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
 ▀▀▀▀▀▀▀▀▀▀   ▀▀▀▀▀▀▀▀▀▀▀  ▀▀       ▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀ 
                """;
        String dashes = "\n------------------------------------------------------------------------\n"; 
        
        System.out.println(dashes);
        System.out.println(banner);
        System.out.println(dashes);

        Account lab8 = new Account(1, "David Bowles", 1000.00);
        Account myAccount = new Account(1, "David not so rich", 100.00);
        int k = 100;

        lab8.getDetails();
        lab8.Deposit(400.00);
        lab8.Withdraw(200.00);
        lab8.getDetails();

        System.out.println(dashes);
        
        processAccount(myAccount);
        myAccount.getDetails();

        System.out.println(dashes);

        incInt(k);
        int x = incInt(k);
        System.out.println(k);
        System.out.println(x);
    }

    private static int incInt(int x) {
        return x++;
    }

    static void processAccount(Account acc) {
        acc.addInterest();
    }
}