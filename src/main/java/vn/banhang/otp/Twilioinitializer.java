package vn.banhang.otp;

import com.twilio.Twilio;

public class Twilioinitializer 
{
	
	private final Twilioproperties twilioproperties;
	
	public Twilioinitializer(Twilioproperties twilioproperties)
	{
		this.twilioproperties=twilioproperties;
		Twilio.init(twilioproperties.getAccountSid(), twilioproperties.getAuthToken());
		System.out.println("twilio intialized with account: "+ twilioproperties.getAccountSid());
	}
}
