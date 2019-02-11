package banq.defination;

import java.util.List;

import banq.models.LoanType;
import banq.models.Payment;

public interface BanqService {
	public List<Payment> ReturnPayments(double TotalAmount, int NumberOfYears, double Interest);
	public double GetInterest(int LoanType);
	public List<LoanType> GetLoanTypes();
}
