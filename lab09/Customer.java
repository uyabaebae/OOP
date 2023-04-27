public class Customer {
    private String firstName;
    private String lastName;
    private CheckingAccount acct;
    
    public Customer(){
        this("", "", null);
    }
    public Customer(String firstName, String lastName){
        this(firstName, lastName, null);
    }
    public Customer(String firstName, String lastName, CheckingAccount acct){
        this.firstName = firstName;
        this.lastName = lastName;
        this.acct = acct;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setAcct(CheckingAccount acct){
        this.acct = acct;
    }
    public CheckingAccount getAcct(){
        return acct;
    }
    @Override
    public String toString(){
        String text = "";
        if (acct == null){
        text += firstName + " " + lastName + " doesn’t have account.";
        return(text);
    }
        else{
            String txt = "";
            txt += "The " + firstName + " account has " + acct.balance + " baht and " + acct.getCredit() + " credits.";
            return txt;
        }
    }
    public boolean equals(Customer c){
        return (c.firstName.equals(this.firstName)) & (c.lastName.equals(this.lastName));
    }
}
