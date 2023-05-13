package Model;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Sms {

    // Find your Account Sid and Token at console.twilio.com
    public static final String ACCOUNT_SID = "ACb682d0f0321f73d2a147b3a80d246afe";
    public static final String AUTH_TOKEN = "c980cce1726d7d8a528c27da02aef77c";

    public void sendSms(String number){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(   new PhoneNumber(number),
                        new PhoneNumber("+12705149649"),
                        "Your credentials had been changed!"
                )
                .create();
    }
    public static void main(String[] args) {

        //System.out.println(message.getSid());
}
}
