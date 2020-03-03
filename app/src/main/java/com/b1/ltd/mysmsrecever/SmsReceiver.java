package com.b1.ltd.mysmsrecever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {

    String msgFrom="";
    String msgBody="";
    String timeStamp="";

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle data=intent.getExtras();
        Object[] pdusData= (Object[]) data.get("pdus");

        for (int i=0; i<pdusData.length;i++){
            SmsMessage message=SmsMessage.createFromPdu((byte[]) pdusData[i]);
            msgFrom=message.getDisplayOriginatingAddress();
            msgBody=msgBody+message.getMessageBody();
            timeStamp=message.getTimestampMillis() +"";
        }

        MainActivity.tvMessage.setText("From"+msgFrom +"\n" +"Message"+"\n"+msgBody+"\n"+timeStamp);

        Log.d(MainActivity.TAG,"I can receive Message here.... ");

        Toast.makeText(context,"I can receive Message here....",Toast.LENGTH_LONG).show();
    }
}
