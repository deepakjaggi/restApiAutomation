package banqSoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import banq.models.LoanType;
import banq.models.Payment;

public class MockFile 
{
	public List<LoanType> getAllLoansList()
	{
		List<LoanType> listLoanType=new ArrayList<LoanType>();
		LoanType l=new LoanType();
		l.setLoanText("HomeLoan");
		l.setLoanType(1);
		listLoanType.add(l);
		l=null;
		l=new LoanType();
		l.setLoanText("Car Loan");
		l.setLoanType(2);
		listLoanType.add(l);
		return listLoanType;
	}
	public List<LoanType> getAllLoansListNotMatchingRecords()
	{
		List<LoanType> listLoanType=new ArrayList<LoanType>();
		LoanType l=new LoanType();
		l.setLoanText("HomeLoan");
		l.setLoanType(1);
		listLoanType.add(l);
		l=null;
		l=new LoanType();
		l.setLoanText("Car Loan");
		l.setLoanType(2);
		listLoanType.add(l);
		l=null;
		l=new LoanType();
		l.setLoanText("Topup Loan");
		l.setLoanType(2);
		listLoanType.add(l);
		return listLoanType;
	}
	public List<LoanType> getAllLoansListAsNull()
	{
		return null;
	}
	
	public double getInterestRate(String loanType)
	{
		if (loanType.equalsIgnoreCase("Car Loan"))
		{
			return 6.00;
		}
		if (loanType.equalsIgnoreCase("Home Loan"))
		{
			return 3.14;
		}
		return 0;		
	}
	
	public List<Payment> returnPaymentsCalculationsFor3DigitAmount()
	{
		Payment payment1=new Payment(1,83.33,2.62,85.95);
		Payment payment2=new Payment(2,83.55,2.40,85.95);
		Payment payment3=new Payment(3,83.77,2.18,85.95);
		Payment payment4=new Payment(4,83.99,1.96,85.95);
		Payment payment5=new Payment(5,84.21,1.74,85.95);
		Payment payment6=new Payment(6,84.43,1.52,85.95);
		Payment payment7=new Payment(7,84.65,1.30,85.95);
		Payment payment8=new Payment(8,84.87,1.08,85.95);
		Payment payment9=new Payment(9,85.09,0.86,85.95);
		Payment payment10=new Payment(10,85.32,0.63,85.95);
		Payment payment11=new Payment(11,85.54,0.41,85.95);
		Payment payment12=new Payment(12,71.25,0.19,85.95);
		return Arrays.asList(payment1,payment2,payment3,payment4,payment5,payment6,payment7,payment8,payment9,payment10,payment11,payment12);
	}
	
	public List<Payment> getExpectedPaymentStructture()
	{
		Payment payment1=new Payment(1,83.33,2.62,85.95);
		Payment payment2=new Payment(2,83.55,2.40,85.95);
		Payment payment3=new Payment(3,83.77,2.18,85.95);
		Payment payment4=new Payment(4,83.99,1.96,85.95);
		Payment payment5=new Payment(5,84.21,1.74,85.95);
		Payment payment6=new Payment(6,84.43,1.52,85.95);
		Payment payment7=new Payment(7,84.65,1.30,85.95);
		Payment payment8=new Payment(8,84.87,1.08,85.95);
		Payment payment9=new Payment(9,85.09,0.86,85.95);
		Payment payment10=new Payment(10,85.32,0.63,85.95);
		Payment payment11=new Payment(11,85.54,0.41,85.95);
		Payment payment12=new Payment(12,71.25,0.19,85.95);
		return Arrays.asList(payment1,payment2,payment3,payment4,payment5,payment6,payment7,payment8,payment9,payment10,payment11,payment12);
	}
	
	public List<Payment> getNotExpectedPaymentStructture()
	{
		Payment payment1=new Payment(1,83.33,2.62,86.95);
		Payment payment2=new Payment(2,83.55,2.40,85.95);
		Payment payment3=new Payment(3,83.77,2.18,85.95);
		Payment payment4=new Payment(4,83.99,1.96,85.95);
		Payment payment5=new Payment(5,84.21,1.74,85.95);
		Payment payment6=new Payment(6,84.43,1.52,85.95);
		Payment payment7=new Payment(7,84.65,1.30,85.95);
		Payment payment8=new Payment(8,84.87,1.08,85.95);
		Payment payment9=new Payment(9,85.09,0.86,85.95);
		Payment payment10=new Payment(10,85.32,0.63,85.95);
		Payment payment11=new Payment(11,85.54,0.41,85.95);
		Payment payment12=new Payment(12,71.25,0.19,85.95);
		return Arrays.asList(payment1,payment2,payment3,payment4,payment5,payment6,payment7,payment8,payment9,payment10,payment11,payment12);
	}
}
