package lab;

public class Order {
    private Item item;
    private String paymentType;
    private int amountRemaining;
    private boolean isPaid;
    private boolean isValidCredit; // Variable name corrected to isValidCredit
    private String monthlyPayment; // Temporary storage for monthly payment amount

    public Order(Item item, String paymentType, int amountRemaining) {
        this.item = item;
        this.paymentType = paymentType;
        this.amountRemaining = amountRemaining;
        this.isPaid = false;
        this.isValidCredit = true; // By default, credit payment is assumed to be valid
    }

    // Getters and Setters
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getAmountRemaining() {
        return amountRemaining;
    }

    public void setAmountRemaining(int amountRemaining) {
        this.amountRemaining = amountRemaining;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isValidCredit() {
        return isValidCredit;
    }

    public void setValidCredit(boolean validCredit) {
        isValidCredit = validCredit;
    }
    
    public void setMonthlyPayment(String monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getMonthlyPayment() {
        return monthlyPayment;
    }
}
