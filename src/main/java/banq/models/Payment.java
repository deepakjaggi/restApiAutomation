package banq.models;

public class Payment {

	private int paymentNumber;
	private double amount;
	private double interest;
	private double total;
	
	public Payment() {		
		
	}
	public Payment(int paymentNumber, double amount, double interest, double total) {		
		this.paymentNumber = paymentNumber;
		this.amount = amount;
		this.interest = interest;
		this.total = total;
	}
	
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getPaymentNumber() {
		return paymentNumber;
	}
	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}


	@Override
	public String toString() {
		return "Payment [paymentNumber=" + paymentNumber + ", amount=" + amount + ", interest=" + interest + ", total="
				+ total + "]";
	}

}
