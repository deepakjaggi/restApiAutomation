package banqSoft;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import banq.defination.BanqService;
import banq.models.Payment;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPaymentCaluclations {
	BanqService banqService;
	MockFile mockFile = new MockFile();
	List<Payment> paymentStructExpected = new ArrayList<Payment>();

	@Before
	public void Setup() {
		banqService = mock(BanqService.class);
	}

	// Verify get loan Types Service 1
	@Test
	public void tc001_VerifyGetLoanTypes() {
		when(banqService.GetLoanTypes()).thenReturn(mockFile.getAllLoansList());
		assertEquals(banqService.GetLoanTypes().size(), 2, "Number of records are equal");
		assertEquals(banqService.GetLoanTypes().get(0).getLoanText(), "HomeLoan");
		assertEquals(banqService.GetLoanTypes().get(0).getLoanType(), 1);
		assertEquals(banqService.GetLoanTypes().get(1).getLoanText(), "Car Loan");
		assertEquals(banqService.GetLoanTypes().get(1).getLoanType(), 2);
//		Added Sample Comment Master fast forward 1
//		Added Sample Comment Master fast forward 1
//		Added Sample Comment Master fast forward 1
//		Added Sample Comment Master fast forward 1
//		Added Sample Comment Master fast forward 2
		

	}

	// Verify get loan Types Service 2
	@Test
	public void tc002_VerifyGetInterestForHomeLoan() {
		when(banqService.GetInterest(1)).thenReturn(mockFile.getInterestRate("Home Loan"));
		assertEquals(banqService.GetInterest(1), 3.14);
	}

	@Test
	public void tc003_VerifyGetInterestForCar() {
		when(banqService.GetInterest(2)).thenReturn(mockFile.getInterestRate("Car Loan"));
		assertEquals(banqService.GetInterest(2), 6.00);
	}

	// Verify return payment service 3
	@Test
	public void tc004_VerifyReturnPaymentServiceCorrectCaluclations() {
		paymentStructExpected = mockFile.getExpectedPaymentStructture();
		when(banqService.ReturnPayments(1000.00, 1, 3.14))
				.thenReturn(mockFile.returnPaymentsCalculationsFor3DigitAmount());
		// Logic for compare 2 lists
		List<Payment> paymentStruct = new ArrayList<Payment>();
		paymentStruct = banqService.ReturnPayments(1000.00, 1, 3.14);
		if (paymentStruct.toString().equalsIgnoreCase(paymentStructExpected.toString())) {
			assertEquals(true, true, "paymenbt Structure is Correct");
		} else {
			assertEquals(true, false, "paymenbt Structure is Not Correct");
		}
	}

	// Verify return payment service 4
	@Test
	public void tc004_VerifyReturnPaymentServiceNotCorrectCaluclations() {
		paymentStructExpected = mockFile.getNotExpectedPaymentStructture();
		when(banqService.ReturnPayments(1000.00, 1, 3.14))
				.thenReturn(mockFile.returnPaymentsCalculationsFor3DigitAmount());
		// Logic for compare 2 lists
		List<Payment> paymentStruct = new ArrayList<Payment>();
		paymentStruct = banqService.ReturnPayments(1000.00, 1, 3.14);
		if (paymentStruct.toString().equalsIgnoreCase(paymentStructExpected.toString())) {
			assertEquals(true, true, "paymenbt Structure is Correct");
		} else {
			assertEquals(true, false, "paymenbt Structure is Not Correct");
		}

	}

}
