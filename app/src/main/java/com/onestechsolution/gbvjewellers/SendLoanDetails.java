package com.onestechsolution.gbvjewellers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by PSGanesh on 5/6/17.
 */

public class SendLoanDetails extends AsyncTask<String, String, String> {
    private Context context;
    private String loginId, password;
    ArrayList<String> loanDetails = new ArrayList<>();

    public SendLoanDetails(Context context, ArrayList<String> loanDetails) {
        this.context = context;
        this.loanDetails = loanDetails;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String[] params) {

        try {
            loginId =  params[0];
            password =  params[1];

            String uniqueId = loanDetails.get(0);
            String name = loanDetails.get(1);
            String contact = loanDetails.get(2);
            String amount = loanDetails.get(3);
            String percentage = loanDetails.get(4);
            String totalItems = loanDetails.get(5);
            String itemWeight1 = loanDetails.get(6);
            String itemWeight2 = loanDetails.get(7);
            String itemWeight3 = loanDetails.get(8);
            String itemWeight4 = loanDetails.get(9);
            String itemWeight5 = loanDetails.get(10);
            String itemWeight6 = loanDetails.get(11);
            String itemWeight7 = loanDetails.get(12);
            String itemWeight8 = loanDetails.get(13);
            String description = loanDetails.get(14);


            Log.i(TAG, "doInBackground: username: "+loginId+" password: "+password);
            //String link = "http://myphpmysqlweb.hostei.com/loginpost.php";
            String link = "http://onestechsolution.com/loginpost.php";
            String data = URLEncoder.encode("username", "UTF-8") + "=" +
                    URLEncoder.encode(loginId, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" +
                    URLEncoder.encode(password, "UTF-8");
            data += "&" + URLEncoder.encode("uniqueId", "UTF-8") + "=" +
                    URLEncoder.encode(uniqueId, "UTF-8");
            data += "&" + URLEncoder.encode("name", "UTF-8") + "=" +
                    URLEncoder.encode(name, "UTF-8");
            data += "&" + URLEncoder.encode("contact", "UTF-8") + "=" +
                    URLEncoder.encode(contact, "UTF-8");
            data += "&" +URLEncoder.encode("amount", "UTF-8") + "=" +
                    URLEncoder.encode(amount, "UTF-8");
            data += "&" + URLEncoder.encode("percentage", "UTF-8") + "=" +
                    URLEncoder.encode(percentage, "UTF-8");
            data += "&" + URLEncoder.encode("totalItems", "UTF-8") + "=" +
                    URLEncoder.encode(totalItems, "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight1", "UTF-8") + "=" +
                    URLEncoder.encode(itemWeight1, "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight2", "UTF-8") + "=" +
                    URLEncoder.encode(itemWeight2, "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight3", "UTF-8") + "=" +
                    URLEncoder.encode(itemWeight3, "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight4", "UTF-8") + "=" +
                    URLEncoder.encode(itemWeight4, "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight5", "UTF-8") + "=" +
                    URLEncoder.encode(itemWeight5, "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight6", "UTF-8") + "=" +
                    URLEncoder.encode(itemWeight6, "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight7", "UTF-8") + "=" +
                    URLEncoder.encode(itemWeight7, "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight8", "UTF-8") + "=" +
                    URLEncoder.encode(itemWeight8, "UTF-8");
            data += "&" + URLEncoder.encode("description", "UTF-8") + "=" +
                    URLEncoder.encode(description, "UTF-8");

            URL url = new URL(link);
            URLConnection conn = url.openConnection();

            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

            wr.write(data);
            wr.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = reader.readLine()) !=null) {
                sb.append(line);
                break;
            }
            Log.i(TAG, "doInBackground: Response: "+sb.toString());
            return sb.toString();

        } catch(Exception e) {
            return new String("Exception: "+e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result) {

    }
}


