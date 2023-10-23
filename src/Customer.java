public class Customer {
    // Full name of the customer
    private final String fullName;
    // Phone number of the customer
    private final int phoneNumber;
    // Type of service. First bool is voice, second is internet.
    private boolean[] service = new boolean[2];
    // Type of payment. True = subscription | False = credit
    private final boolean paymentType;
    // State of the account. If the payment type is subscription, it is always negative otherwise only positive
    private final double account;

    Customer(String fullName, int phoneNumber, boolean[] service, boolean paymentType, double account){
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.service = service;
        this.paymentType = paymentType;
        this.account = account;
    }
}
