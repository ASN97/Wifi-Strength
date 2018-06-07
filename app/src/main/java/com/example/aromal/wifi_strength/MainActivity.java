package com.example.aromal.wifi_strength;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView strength=(TextView) findViewById(R.id.strength);
        final TextView details=(TextView) findViewById(R.id.details);
        TextView comment=(TextView) findViewById(R.id.comment);
        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        if(wifiManager.isWifiEnabled()) {
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                if (wifiInfo != null) {
                    int dbm = wifiInfo.getRssi();
                     String result_strength = Integer.toString(dbm);
                    final String strengthindbm=result_strength+" dBm";

                    int ip = wifiInfo.getIpAddress();
                    String result_ip = Integer.toString(ip);

                    String mac = wifiInfo.getMacAddress();

                    String ssid = wifiInfo.getSSID();


                    String result_bssid = wifiInfo.getBSSID();

                    int link=wifiInfo.getLinkSpeed();
                    String result_link = Integer.toString(link);

                  final  String finale="IP Address:"+result_ip+"\nMAC Address:"+mac+"\nSSID:"+ssid+"\nBSSID:"+result_bssid+"\nLink SPeed:"+result_link+"\nConnetion Strength::"+result_strength;

                   /* t1.setText(finale);
                    if(dbm>-50)
                    {
                     t2.setText("Signal Strength:Excellent.");
                    }
                    else if(dbm>-60&&dbm<-50)
                    {

                        t2.setText("Signal Strength:Good.");

                    }

                    */
                     Button showstrength=(Button) (findViewById(R.id.checkstrength));
        showstrength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strength.setText("Wifi Strength="+strengthindbm);
            }
        });

                    Button checkall=(Button) (findViewById(R.id.showall));
                    checkall.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            details.setText(finale);
                        }
                    });




                    if(dbm>-50)
                    {
                        comment.setText("Signal Strength:Excellent.");
                    }
                    else if(dbm>-60&&dbm<-50)
                    {

                        comment.setText("Signal Strength:Good.");

                    }
                    else if(dbm>-80&&dbm<-60)
                    {

                        comment.setText("Signal Strength:Weak.");

                    }



                } else {
                    comment.setText("Some problem has occured");
                }

        }








    }
}
