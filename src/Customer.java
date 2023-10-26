public class Customer {
    // Full name of the customer
    public String fullName;
    // Phone number of the customer
    public String phoneNumber;
    // Type of service. First bool is voice, second is internet. True = is present
    public boolean[] service = new boolean[2];
    // Type of payment. True = subscription | False = credit
    public boolean paymentType;
    // State of the account. If the payment type is subscription, it is always negative otherwise only positive
    public double account;
    Customer(){
        fullName = "";
        phoneNumber = "";
        account = 0;
    }
}
