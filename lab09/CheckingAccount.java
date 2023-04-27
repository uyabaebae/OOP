public class CheckingAccount extends Account{
    private double credit;
    
    public CheckingAccount(){
        super(0, "");
        credit = 0;
    }
    
    public CheckingAccount(double balance, String name, double credit){
        super(balance, name);
        this.credit = credit;
    }
    public void setCredit(double credit){
        if (credit > 0){
            this.credit = credit;
        }
        else{
            System.out.println("Input number must be a positive integer.");
        }
    }
    public double getCredit(){
        return credit;
    }
    @Override
    public void withdraw(double a) throws WithdrawException{
        if (a > 0){
            balance -= a;
            if (balance >= 0){
                String text = "";
                text += (a + " baht is withdrawn from " + name);
                text += (" and your credit balance is " + credit + ".");
                System.out.println(text);
            }
            else if (balance < 0){
                balance += credit;
                if (balance >= 0){
                String text = "";
                text += (a + " baht is withdrawn from " + name);
                text += (" and your credit balance is " + credit + ".");
                balance = 0;
                System.out.println(text);
                }
        else{
                    balance += a;
                    throw new WithdrawException("Account " + super.name + " has not enough money." );
                }
            }
        }  
    }
    public void withdraw(String a) throws WithdrawException{
        double ton = Double.valueOf(a);
        if (ton > 0){
            balance -= ton;
            if (balance >= 0){
                String text = "";
                text += (ton + " baht is withdrawn from " + name);
                text += (" and your credit balance is " + credit + ".");
                System.out.println(text);
            }
            else if (balance < 0){
                balance += credit;
                if (balance >= 0){
                String text = "";
                text += (ton + " baht is withdrawn from " + name);
                text += (" and your credit balance is " + credit + ".");
                balance = 0;
                System.out.println(text);
                }
                else{
                    throw new WithdrawException("Account " + super.name + " has not enough money." );
                }
            }
        }  
    }
    @Override
    public String toString(){
        String txt = "";
        txt += "The " + name + " account has " + balance + " baht and " + credit + " credits.";
        return txt;
    }
}
