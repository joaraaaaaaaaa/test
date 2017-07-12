package com.test.gitapi.vo;

public class VerificationVO {
	private boolean verified;
	private String reason;
	private String signature;
	private String payload;
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	@Override
	public String toString() {
		return "VerificationVO [verified=" + verified + ", reason=" + reason + ", signature=" + signature + ", payload="
				+ payload + "]";
	}
	
}
