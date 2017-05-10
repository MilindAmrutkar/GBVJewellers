package com.onestechsolution.gbvjewellers.Activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.onestechsolution.gbvjewellers.GenerateUniqueId;
import com.onestechsolution.gbvjewellers.R;
import com.onestechsolution.gbvjewellers.SendLoanDetails;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LoanActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "LoanActivity";
    Spinner spnrPercentage, spnrNoOfItems;
    Spinner spnrItem1, spnrItem2, spnrItem3, spnrItem4, spnrItem5, spnrItem6, spnrItem7, spnrItem8;
    TextView tvUUId;
    EditText etName, etContact, etAmount, etDescription;
    EditText etItem1Wt1, etItem2Wt2, etItem3Wt3, etItem4Wt4, etItem5Wt5, etItem6Wt6, etItem7Wt7, etItem8Wt8;
    String percentage, totalItems;
    ImageView ivItem1, ivItem2, ivItem3, ivItem4, ivItem5, ivItem6, ivItem7, ivItem8;
    ImageView currentImageView;
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    public static final int MEDIA_TYPE_IMAGE = 1;

    private static final String IMAGE_DIRECTORY_NAME = "GBV Jewellers";

    String imgPath1, imgPath2, imgPath3, imgPath4, imgPath5, imgPath6, imgPath7, imgPath8;

    private Uri fileUri;


    GenerateUniqueId generateUniqueId;
    String uniqueId;
    LinearLayout llItem1, llItem2, llItem3, llItem4, llItem5, llItem6, llItem7, llItem8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);
        spnrPercentage = (Spinner) findViewById(R.id.spnr_percentage_loan_activity);
        spnrNoOfItems = (Spinner) findViewById(R.id.spnr_noOfItems_loan_activity);
        etName = (EditText) findViewById(R.id.et_name_loan_activity);
        etContact = (EditText) findViewById(R.id.et_contact_loan_activity);
        etAmount = (EditText) findViewById(R.id.et_amount_loan_activity);
        etDescription = (EditText) findViewById(R.id.et_description_loan_activity);
        etItem1Wt1 = (EditText) findViewById(R.id.et_item1_weight_loan_activity);
        etItem2Wt2 = (EditText) findViewById(R.id.et_item2_weight_loan_activity);
        etItem3Wt3 = (EditText) findViewById(R.id.et_item3_weight_loan_activity);
        etItem4Wt4 = (EditText) findViewById(R.id.et_item4_weight_loan_activity);
        etItem5Wt5 = (EditText) findViewById(R.id.et_item5_weight_loan_activity);
        etItem6Wt6 = (EditText) findViewById(R.id.et_item6_weight_loan_activity);
        etItem7Wt7 = (EditText) findViewById(R.id.et_item7_weight_loan_activity);
        etItem8Wt8 = (EditText) findViewById(R.id.et_item8_weight_loan_activity);

        ivItem1 = (ImageView) findViewById(R.id.iv_item1_loan_activity);
        ivItem2 = (ImageView) findViewById(R.id.iv_item2_loan_activity);
        ivItem3 = (ImageView) findViewById(R.id.iv_item3_loan_activity);
        ivItem4 = (ImageView) findViewById(R.id.iv_item4_loan_activity);
        ivItem5 = (ImageView) findViewById(R.id.iv_item5_loan_activity);
        ivItem6 = (ImageView) findViewById(R.id.iv_item6_loan_activity);
        ivItem7 = (ImageView) findViewById(R.id.iv_item7_loan_activity);
        ivItem8 = (ImageView) findViewById(R.id.iv_item8_loan_activity);

        llItem1 = (LinearLayout) findViewById(R.id.ll_item1_loan_activity);
        llItem2 = (LinearLayout) findViewById(R.id.ll_item2_loan_activity);
        llItem3 = (LinearLayout) findViewById(R.id.ll_item3_loan_activity);
        llItem4 = (LinearLayout) findViewById(R.id.ll_item4_loan_activity);
        llItem5 = (LinearLayout) findViewById(R.id.ll_item5_loan_activity);
        llItem6 = (LinearLayout) findViewById(R.id.ll_item6_loan_activity);
        llItem7 = (LinearLayout) findViewById(R.id.ll_item7_loan_activity);
        llItem8 = (LinearLayout) findViewById(R.id.ll_item8_loan_activity);


        tvUUId = (TextView) findViewById(R.id.tv_uuid_loan_activity);

        generateUniqueId = new GenerateUniqueId();

        spnrItem1 = (Spinner) findViewById(R.id.spnr_item1_itemlist_loan_activity);
        spnrItem2 = (Spinner) findViewById(R.id.spnr_item2_itemlist_loan_activity);
        spnrItem3 = (Spinner) findViewById(R.id.spnr_item3_itemlist_loan_activity);
        spnrItem4 = (Spinner) findViewById(R.id.spnr_item4_itemlist_loan_activity);
        spnrItem5 = (Spinner) findViewById(R.id.spnr_item5_itemlist_loan_activity);
        spnrItem6 = (Spinner) findViewById(R.id.spnr_item6_itemlist_loan_activity);
        spnrItem7 = (Spinner) findViewById(R.id.spnr_item7_itemlist_loan_activity);
        spnrItem8 = (Spinner) findViewById(R.id.spnr_item8_itemlist_loan_activity);


        spnrPercentage.setOnItemSelectedListener(this);
        spnrNoOfItems.setOnItemSelectedListener(this);
        spnrItem1.setOnItemSelectedListener(this);
        spnrItem2.setOnItemSelectedListener(this);
        spnrItem3.setOnItemSelectedListener(this);
        spnrItem4.setOnItemSelectedListener(this);
        spnrItem5.setOnItemSelectedListener(this);
        spnrItem6.setOnItemSelectedListener(this);
        spnrItem7.setOnItemSelectedListener(this);
        spnrItem8.setOnItemSelectedListener(this);

        uniqueId = generateUniqueId.generateUUId();
        tvUUId.setText(uniqueId);

        List<String> percentages = new ArrayList<String>();
        percentages.add("1.0");
        percentages.add("1.5");
        percentages.add("2.0");
        percentages.add("2.5");

        List<String> categories = new ArrayList<String>();
        categories.add("Ring");
        categories.add("Chain");
        categories.add("Necklace");
        categories.add("Earrings");
        categories.add("Bracelets");

        String[] noOfItems = {"1", "2", "3", "4", "5", "6", "7", "8"};

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnrItem1.setAdapter(dataAdapter);
        spnrItem2.setAdapter(dataAdapter);
        spnrItem3.setAdapter(dataAdapter);
        spnrItem4.setAdapter(dataAdapter);
        spnrItem5.setAdapter(dataAdapter);
        spnrItem6.setAdapter(dataAdapter);
        spnrItem7.setAdapter(dataAdapter);
        spnrItem8.setAdapter(dataAdapter);

        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, percentages);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnrPercentage.setAdapter(dataAdapter);

        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, noOfItems);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnrNoOfItems.setAdapter(dataAdapter);

    }


    public void setlistener()
    {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spinner = (Spinner) parent;
        if (spinner.getId() == R.id.spnr_item1_itemlist_loan_activity) {
            String item = parent.getItemAtPosition(position).toString();

            Toast.makeText(this, "Selected: " + item, Toast.LENGTH_SHORT).show();
        } else if (spinner.getId() == R.id.spnr_noOfItems_loan_activity) {
            String noOfItems = parent.getItemAtPosition(position).toString();
            totalItems = noOfItems;
            Log.i(TAG, "onItemSelected: noOfItems: " + noOfItems);
            if (noOfItems.equalsIgnoreCase("1")) {
                llItem1.setVisibility(View.VISIBLE);
                llItem2.setVisibility(View.GONE);
                llItem3.setVisibility(View.GONE);
                llItem4.setVisibility(View.GONE);
                llItem5.setVisibility(View.GONE);
                llItem6.setVisibility(View.GONE);
                llItem7.setVisibility(View.GONE);
                llItem8.setVisibility(View.GONE);
            }
            if (noOfItems.equalsIgnoreCase("2")) {
                llItem2.setVisibility(View.VISIBLE);
                llItem3.setVisibility(View.GONE);
                llItem4.setVisibility(View.GONE);
                llItem5.setVisibility(View.GONE);
                llItem6.setVisibility(View.GONE);
                llItem7.setVisibility(View.GONE);
                llItem8.setVisibility(View.GONE);
            } else if (noOfItems.equalsIgnoreCase("3")) {
                llItem2.setVisibility(View.VISIBLE);
                llItem3.setVisibility(View.VISIBLE);
                llItem4.setVisibility(View.GONE);
                llItem5.setVisibility(View.GONE);
                llItem6.setVisibility(View.GONE);
                llItem7.setVisibility(View.GONE);
                llItem8.setVisibility(View.GONE);
            } else if (noOfItems.equalsIgnoreCase("4")) {
                llItem2.setVisibility(View.VISIBLE);
                llItem3.setVisibility(View.VISIBLE);
                llItem4.setVisibility(View.VISIBLE);
                llItem5.setVisibility(View.GONE);
                llItem6.setVisibility(View.GONE);
                llItem7.setVisibility(View.GONE);
                llItem8.setVisibility(View.GONE);
            } else if (noOfItems.equalsIgnoreCase("5")) {
                llItem2.setVisibility(View.VISIBLE);
                llItem3.setVisibility(View.VISIBLE);
                llItem4.setVisibility(View.VISIBLE);
                llItem5.setVisibility(View.VISIBLE);
                llItem6.setVisibility(View.GONE);
                llItem7.setVisibility(View.GONE);
                llItem8.setVisibility(View.GONE);
            } else if (noOfItems.equalsIgnoreCase("6")) {
                llItem2.setVisibility(View.VISIBLE);
                llItem3.setVisibility(View.VISIBLE);
                llItem4.setVisibility(View.VISIBLE);
                llItem5.setVisibility(View.VISIBLE);
                llItem6.setVisibility(View.VISIBLE);
                llItem7.setVisibility(View.GONE);
                llItem8.setVisibility(View.GONE);
            } else if (noOfItems.equalsIgnoreCase("7")) {
                llItem2.setVisibility(View.VISIBLE);
                llItem3.setVisibility(View.VISIBLE);
                llItem4.setVisibility(View.VISIBLE);
                llItem5.setVisibility(View.VISIBLE);
                llItem6.setVisibility(View.VISIBLE);
                llItem7.setVisibility(View.VISIBLE);
                llItem8.setVisibility(View.GONE);
            } else if (noOfItems.equalsIgnoreCase("8")) {
                llItem2.setVisibility(View.VISIBLE);
                llItem3.setVisibility(View.VISIBLE);
                llItem4.setVisibility(View.VISIBLE);
                llItem5.setVisibility(View.VISIBLE);
                llItem6.setVisibility(View.VISIBLE);
                llItem7.setVisibility(View.VISIBLE);
                llItem8.setVisibility(View.VISIBLE);
            }
        } else if (spinner.getId() == R.id.spnr_percentage_loan_activity) {
            String percentage = parent.getItemAtPosition(position).toString();
            this.percentage = percentage;
            Log.i(TAG, "onItemSelected: Percentage: " + percentage);
            Toast.makeText(this, "Percentage: " + percentage, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onSave(View view) {


        String uniqueId = tvUUId.getText().toString();
        String name = etName.getText().toString();
        String contact = etContact.getText().toString();
        String amount = etAmount.getText().toString();
        //percentage
        //totalItems
        String itemWeight1 = etItem1Wt1.getText().toString();
        String itemWeight2 = etItem2Wt2.getText().toString();
        String itemWeight3 = etItem3Wt3.getText().toString();
        String itemWeight4 = etItem4Wt4.getText().toString();
        String itemWeight5 = etItem5Wt5.getText().toString();
        String itemWeight6 = etItem6Wt6.getText().toString();
        String itemWeight7 = etItem7Wt7.getText().toString();
        String itemWeight8 = etItem8Wt8.getText().toString();

        String description = etDescription.getText().toString();

        if (checkInput(uniqueId, name, contact, amount, percentage, totalItems, itemWeight1, itemWeight2, itemWeight3,
                itemWeight4, itemWeight5, itemWeight6, itemWeight7, itemWeight8, description)) {
            insertToDatabase(uniqueId, name, contact, amount, percentage, totalItems, itemWeight1, itemWeight2, itemWeight3,
                    itemWeight4, itemWeight5, itemWeight6, itemWeight7, itemWeight8, description);
        }
    }

    public boolean checkInput(String uniqueId, String name, String contact, String amount, String percentage, String totalItems, String itemWeight1, String itemWeight2,
                              String itemWeight3, String itemWeight4, String itemWeight5, String itemWeight6, String itemWeight7, String itemWeight8, String description) {
        Log.i(TAG, "checkInput: uniqueId: "+uniqueId+" name: "+name+" amount: "+amount+" percentage: "+percentage
        + " totalItems: "+totalItems+" itemWeight1: "+itemWeight1+" itemWeight2: "+itemWeight2
                +" itemWeight3: "+itemWeight3+" itemWeight4: "+itemWeight4
                +" itemWeight5: "+itemWeight5+" itemWeight6: "+itemWeight6
                +" itemWeight7: "+itemWeight7+" itemWeight8: "+itemWeight8);
        if (uniqueId != null && !uniqueId.isEmpty() && name != null && !name.isEmpty()
                && contact!=null && !contact.isEmpty() && amount!=null && !amount.isEmpty()
                && percentage!=null && !percentage.isEmpty() && totalItems!=null && !totalItems.isEmpty()
                ) {
            Toast.makeText(this, "Values are: \n " +
                    "uniqueId: " + uniqueId + "\n " +
                    "name: " + name + "\n" +
                    "contact: " + contact + "\n" +
                    "amount: " + amount + "\n" +
                    "percentage: " + percentage + "\n" +
                    "totalItems: " + totalItems + "\n" +
                    "itemWeight1: " + itemWeight1 + "\n" +
                    "itemWeight2: " + itemWeight2 + "\n" +
                    "itemWeight3: " + itemWeight3 + "\n" +
                    "itemWeight4: " + itemWeight4 + "\n" +
                    "itemWeight5: " + itemWeight5 + "\n" +
                    "itemWeight6: " + itemWeight6 + "\n" +
                    "itemWeight7: " + itemWeight7 + "\n" +
                    "itemWeight8: " + itemWeight8 + "\n" +
                    "description: " + description, Toast.LENGTH_LONG).show();

            return true;
        } else {
            Toast.makeText(this, "Please input all the fields", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    private void insertToDatabase(String uniqueId, String name, String contact, String amount, String percentage, String totalItems, String itemWeight1, String itemWeight2,
                                  String itemWeight3, String itemWeight4, String itemWeight5, String itemWeight6, String itemWeight7, String itemWeight8, String description) {
        ArrayList<String> loanDetails = new ArrayList<>();
        loanDetails.add(uniqueId);
        loanDetails.add(name);
        loanDetails.add(contact);
        loanDetails.add(amount);
        loanDetails.add(percentage);
        loanDetails.add(totalItems);
        loanDetails.add(itemWeight1);
        loanDetails.add(itemWeight2);
        loanDetails.add(itemWeight3);
        loanDetails.add(itemWeight4);
        loanDetails.add(itemWeight5);
        loanDetails.add(itemWeight6);
        loanDetails.add(itemWeight7);
        loanDetails.add(itemWeight8);
        loanDetails.add(description);
        String loginId = "admin";
        String password = "admin";
        new SendLoanDetails(this,loanDetails).execute(loginId, password);
    }

    public void captureImage(View view) {
        if (!isDeviceSupportCamera()) {
            Toast.makeText(getApplicationContext(),
                    "Sorry! Your device doesn't support camera",
                    Toast.LENGTH_LONG).show();
            // will close the app if the device does't have camera
            finish();
        } else {
            if(view.equals(findViewById(R.id.iv_item1_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_item1_loan_activity);
            } else if (view.equals(findViewById(R.id.iv_item2_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_item2_loan_activity);
            } else if(view.equals(findViewById(R.id.iv_item3_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_item3_loan_activity);
            } else if(view.equals(findViewById(R.id.iv_item4_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_item4_loan_activity);
            } else if(view.equals(findViewById(R.id.iv_item5_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_item5_loan_activity);
            } else if(view.equals(findViewById(R.id.iv_item6_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_item6_loan_activity);
            } else if(view.equals(findViewById(R.id.iv_item7_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_item7_loan_activity);
            } else if(view.equals(findViewById(R.id.iv_item8_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_item8_loan_activity);
            }


            Log.i(TAG, "captureImage: currentImageView: "+currentImageView);
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
            startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
        }


    }

    private boolean isDeviceSupportCamera() {
        if (getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(getApplicationContext(),
                        "Captured Successfully", Toast.LENGTH_SHORT).show();
                if(currentImageView.equals(ivItem1)) {
                    ivItem1.setImageResource(R.drawable.saved_48);
                    imgPath1 = fileUri.getPath();
                    Log.i(TAG, "onActivityResult: imgPath1: "+imgPath1);
                } else if(currentImageView == ivItem2) {
                    ivItem2.setImageResource(R.drawable.saved_48);
                    imgPath2 = fileUri.getPath();
                    Log.i(TAG, "onActivityResult: imgPath2: "+imgPath2);
                } else if(currentImageView == ivItem3) {
                    ivItem3.setImageResource(R.drawable.saved_48);
                    imgPath3 = fileUri.getPath();
                    Log.i(TAG, "onActivityResult: imgPath3: "+imgPath3);
                } else if(currentImageView == ivItem4) {
                    ivItem4.setImageResource(R.drawable.saved_48);
                    imgPath4 = fileUri.getPath();
                    Log.i(TAG, "onActivityResult: imgPath4: "+imgPath4);
                } else if(currentImageView == ivItem5) {
                    ivItem5.setImageResource(R.drawable.saved_48);
                    imgPath5 = fileUri.getPath();
                    Log.i(TAG, "onActivityResult: imgPath5: "+imgPath5);
                } else if(currentImageView == ivItem6) {
                    ivItem6.setImageResource(R.drawable.saved_48);
                    imgPath6 = fileUri.getPath();
                    Log.i(TAG, "onActivityResult: imgPath6: "+imgPath6);
                } else if(currentImageView == ivItem7) {
                    ivItem7.setImageResource(R.drawable.saved_48);
                    imgPath7 = fileUri.getPath();
                    Log.i(TAG, "onActivityResult: imgPath7: "+imgPath7);

                } else if(currentImageView == ivItem8) {
                    ivItem8.setImageResource(R.drawable.saved_48);
                    imgPath8 = fileUri.getPath();
                    Log.i(TAG, "onActivityResult: imgPath8: "+imgPath8);
                }


            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(),
                        "User cancelled image capture",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Sorry! Failed to capture image"
                        , Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("file_uri", fileUri);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        fileUri = savedInstanceState.getParcelable("file_uri");
    }


    //Helper methods
    public Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    private static File getOutputMediaFile(int type) {
        File mediaStorageDir = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                IMAGE_DIRECTORY_NAME);

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed to create "
                        + IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG_" + timeStamp + ".jpg");
        } else {
            return null;
        }
        return mediaFile;
    }
}
