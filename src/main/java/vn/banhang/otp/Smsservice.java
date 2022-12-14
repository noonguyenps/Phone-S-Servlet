package vn.banhang.otp;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Smsservice 
{

	private final Twilioproperties twilioproperties;
	
	public Smsservice(Twilioproperties twilioproperties)
	{
		this.twilioproperties=twilioproperties;
	}
	
	//send message to number
	public String sendsms(Smsrequest smsrequest)
	{
     
		Message message=Message.creator(new PhoneNumber(smsrequest.getNumber()), new PhoneNumber(twilioproperties.getFromNumber()), smsrequest.getMessage()).create();
        return message.getStatus().toString();
       
	}
}
