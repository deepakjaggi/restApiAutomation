package servicesAutomation.models;

public class MakePaymentModel {
	public String senderMobileNumber;
	public String rxerMobileNumber;
	public String amount;
	public String errorCode;
	public String errorMessage;
	public String txnID;
	public String token;

	public String getSenderMobileNumber() {
		return senderMobileNumber;
	}

	public void setSenderMobileNumber(String senderMobileNumber) {
		this.senderMobileNumber = senderMobileNumber;
	}

	public String getRxerMobileNumber() {
		return rxerMobileNumber;
	}

	public void setRxerMobileNumber(String rxerMobileNumber) {
		this.rxerMobileNumber = rxerMobileNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getTxnID() {
		return txnID;
	}

	public void setTxnID(String txnID) {
		this.txnID = txnID;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "MakePaymentModel [senderMobileNumber=" + senderMobileNumber + ", rxerMobileNumber=" + rxerMobileNumber
				+ ", amount=" + amount + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", txnID="
				+ txnID + ", token=" + token + "]";		
	}

}
