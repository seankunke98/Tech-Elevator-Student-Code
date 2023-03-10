package com.techelevator.message_board.model;

import java.math.BigDecimal;

public class TransferDTO {

	private int userFrom;
	private int userTo;
	private BigDecimal amount;
	private String transferType;

	public TransferDTO(int fromUserId, int toUserId, BigDecimal amount, String transferType) {
		validateTransferType(transferType);
		this.userFrom = fromUserId;
		this.userTo = toUserId;
		this.amount = amount;
		this.transferType = transferType;
	}

	public long getUserFrom() {
		return userFrom;
	}
	
	public void setUserFrom(int userFrom) {
		this.userFrom = userFrom;
	}

	public long getUserTo() {
		return userTo;
	}

	public void setUserTo(int userTo) {
		this.userTo = userTo;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTransferType() {
		return transferType;
	}
	
	public void setTransferType(String transferType) {
		validateTransferType(transferType);
		this.transferType = transferType;
	}

	private void validateTransferType(String transferType) {
		if(!TransferType.isValid(transferType)) {
			throw new IllegalArgumentException(transferType+" is not a valid transferType");
		}
	}
}
