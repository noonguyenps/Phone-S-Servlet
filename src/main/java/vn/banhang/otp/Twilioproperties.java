package vn.banhang.otp;

public class Twilioproperties 
{
	
	private String accountSid = "ACaaf7a87271ec7d3a7e7d5e3dc0b39e39";
	private String authToken = "98b75c44189cce3a18c4e4819da8da28";
	private String fromNumber = "+14013994120";
	public String getAccountSid() 
	{
		return accountSid;
	}
	public void setAccountSid(String accountSid) 
	{
		this.accountSid = accountSid;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getFromNumber() {
		return fromNumber;
	}
	public void setFromNumber(String fromNumber) 
	{
		this.fromNumber = fromNumber;
	}
	public Twilioproperties() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
}
