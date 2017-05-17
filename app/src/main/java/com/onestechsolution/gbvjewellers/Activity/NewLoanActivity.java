package com.onestechsolution.gbvjewellers.Activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import com.onestechsolution.gbvjewellers.Asynctask.SendLoanDetails;
import com.onestechsolution.gbvjewellers.GenerateUniqueId;
import com.onestechsolution.gbvjewellers.Modal.Loan;
import com.onestechsolution.gbvjewellers.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class NewLoanActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "NewLoanActivity";
    Spinner spnrPercentage, spnrNoOfItemTypes;
    Spinner spnrItem1, spnrItem2, spnrItem3, spnrItem4, spnrItem5, spnrItem6, spnrItem7, spnrItem8;
    Spinner spnrItem1Count, spnrItem2Count, spnrItem3Count, spnrItem4Count, spnrItem5Count, spnrItem6Count, spnrItem7Count, spnrItem8Count;
    TextView tvUUId;
    EditText etName, etContact, etAmount, etDescription;
    EditText etItem1Wt1, etItem2Wt2, etItem3Wt3, etItem4Wt4, etItem5Wt5, etItem6Wt6, etItem7Wt7, etItem8Wt8;

    String percentage, totalItemTypes;
    String item1Type, item2Type, item3Type, item4Type, item5Type, item6Type, item7Type, item8Type;
    String item1Count, item2Count, item3Count, item4Count, item5Count, item6Count, item7Count, item8Count;

    ImageView ivItem1, ivItem2, ivItem3, ivItem4, ivItem5, ivItem6, ivItem7, ivItem8;
    ImageView ivCustomerPhoto;
    ImageView currentImageView;
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    public static final int MEDIA_TYPE_IMAGE = 1;

    private static final String IMAGE_DIRECTORY_NAME = "GBVLoans";

    String custImgPath, imgPath1, imgPath2, imgPath3, imgPath4, imgPath5, imgPath6, imgPath7, imgPath8;

    private Uri fileUri;
    private Loan loan;

    GenerateUniqueId generateUniqueId;
    String uniqueId;
    LinearLayout llItem1, llItem2, llItem3, llItem4, llItem5, llItem6, llItem7, llItem8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_new);

        loan = new Loan();

        //Method to add references (xml to java)
        addingReferences();

        generateUniqueId = new GenerateUniqueId();

        //Method to set Listeners
        settingListeners();

        uniqueId = generateUniqueId.generateUUId();
        tvUUId.setText(uniqueId);

        List<String> categories = new ArrayList<String>();
        categories.add("Ring");
        categories.add("Chain");
        categories.add("Necklace");
        categories.add("Earrings");
        categories.add("Bracelets");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //values of categories such as Ring, Chain, Necklace, etc are set on spinners
        spnrItem1.setAdapter(dataAdapter);
        spnrItem2.setAdapter(dataAdapter);
        spnrItem3.setAdapter(dataAdapter);
        spnrItem4.setAdapter(dataAdapter);
        spnrItem5.setAdapter(dataAdapter);
        spnrItem6.setAdapter(dataAdapter);
        spnrItem7.setAdapter(dataAdapter);
        spnrItem8.setAdapter(dataAdapter);

        List<String> percentages = new ArrayList<String>();
        percentages.add("1.0");
        percentages.add("1.5");
        percentages.add("2.0");
        percentages.add("2.5");

        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, percentages);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //values of percentages are set on spinners
        spnrPercentage.setAdapter(dataAdapter);

        String[] noOfItems = {"1", "2", "3", "4", "5", "6", "7", "8"};

        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, noOfItems);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //values of 1 to 10 are set on spinner
        spnrNoOfItemTypes.setAdapter(dataAdapter);

        String[] itemCounts = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};

        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemCounts);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Values of item counts are set on spinner
        spnrItem1Count.setAdapter(dataAdapter);
        spnrItem2Count.setAdapter(dataAdapter);
        spnrItem3Count.setAdapter(dataAdapter);
        spnrItem4Count.setAdapter(dataAdapter);
        spnrItem5Count.setAdapter(dataAdapter);
        spnrItem6Count.setAdapter(dataAdapter);
        spnrItem7Count.setAdapter(dataAdapter);
        spnrItem8Count.setAdapter(dataAdapter);

    }

    public void addingReferences() {
        tvUUId = (TextView) findViewById(R.id.tv_uuid_loan_activity);
        etName = (EditText) findViewById(R.id.et_name_loan_activity);
        ivCustomerPhoto = (ImageView) findViewById(R.id.iv_customer_photo_loan_activity);
        etContact = (EditText) findViewById(R.id.et_contact_loan_activity);
        etAmount = (EditText) findViewById(R.id.et_amount_loan_activity);
        spnrPercentage = (Spinner) findViewById(R.id.spnr_percentage_loan_activity);
        spnrNoOfItemTypes = (Spinner) findViewById(R.id.spnr_noOfItems_loan_activity);

        etDescription = (EditText) findViewById(R.id.et_description_loan_activity);

        //Item Weights
        etItem1Wt1 = (EditText) findViewById(R.id.et_item1_weight_loan_activity);
        etItem2Wt2 = (EditText) findViewById(R.id.et_item2_weight_loan_activity);
        etItem3Wt3 = (EditText) findViewById(R.id.et_item3_weight_loan_activity);
        etItem4Wt4 = (EditText) findViewById(R.id.et_item4_weight_loan_activity);
        etItem5Wt5 = (EditText) findViewById(R.id.et_item5_weight_loan_activity);
        etItem6Wt6 = (EditText) findViewById(R.id.et_item6_weight_loan_activity);
        etItem7Wt7 = (EditText) findViewById(R.id.et_item7_weight_loan_activity);
        etItem8Wt8 = (EditText) findViewById(R.id.et_item8_weight_loan_activity);

        //Item Images
        ivItem1 = (ImageView) findViewById(R.id.iv_item1_loan_activity);
        ivItem2 = (ImageView) findViewById(R.id.iv_item2_loan_activity);
        ivItem3 = (ImageView) findViewById(R.id.iv_item3_loan_activity);
        ivItem4 = (ImageView) findViewById(R.id.iv_item4_loan_activity);
        ivItem5 = (ImageView) findViewById(R.id.iv_item5_loan_activity);
        ivItem6 = (ImageView) findViewById(R.id.iv_item6_loan_activity);
        ivItem7 = (ImageView) findViewById(R.id.iv_item7_loan_activity);
        ivItem8 = (ImageView) findViewById(R.id.iv_item8_loan_activity);

        //Item Types
        spnrItem1 = (Spinner) findViewById(R.id.spnr_item1_itemlist_loan_activity);
        spnrItem2 = (Spinner) findViewById(R.id.spnr_item2_itemlist_loan_activity);
        spnrItem3 = (Spinner) findViewById(R.id.spnr_item3_itemlist_loan_activity);
        spnrItem4 = (Spinner) findViewById(R.id.spnr_item4_itemlist_loan_activity);
        spnrItem5 = (Spinner) findViewById(R.id.spnr_item5_itemlist_loan_activity);
        spnrItem6 = (Spinner) findViewById(R.id.spnr_item6_itemlist_loan_activity);
        spnrItem7 = (Spinner) findViewById(R.id.spnr_item7_itemlist_loan_activity);
        spnrItem8 = (Spinner) findViewById(R.id.spnr_item8_itemlist_loan_activity);

        //Item Count
        spnrItem1Count = (Spinner) findViewById(R.id.spnr_item1_type_count_loan_activity);
        spnrItem2Count = (Spinner) findViewById(R.id.spnr_item2_type_count_loan_activity);
        spnrItem3Count = (Spinner) findViewById(R.id.spnr_item3_type_count_loan_activity);
        spnrItem4Count = (Spinner) findViewById(R.id.spnr_item4_type_count_loan_activity);
        spnrItem5Count = (Spinner) findViewById(R.id.spnr_item5_type_count_loan_activity);
        spnrItem6Count = (Spinner) findViewById(R.id.spnr_item6_type_count_loan_activity);
        spnrItem7Count = (Spinner) findViewById(R.id.spnr_item7_type_count_loan_activity);
        spnrItem8Count = (Spinner) findViewById(R.id.spnr_item8_type_count_loan_activity);

        //References of LinearLayouts are made
        llItem1 = (LinearLayout) findViewById(R.id.ll_item1_loan_activity);
        llItem2 = (LinearLayout) findViewById(R.id.ll_item2_loan_activity);
        llItem3 = (LinearLayout) findViewById(R.id.ll_item3_loan_activity);
        llItem4 = (LinearLayout) findViewById(R.id.ll_item4_loan_activity);
        llItem5 = (LinearLayout) findViewById(R.id.ll_item5_loan_activity);
        llItem6 = (LinearLayout) findViewById(R.id.ll_item6_loan_activity);
        llItem7 = (LinearLayout) findViewById(R.id.ll_item7_loan_activity);
        llItem8 = (LinearLayout) findViewById(R.id.ll_item8_loan_activity);
    }

    private void settingListeners() {
        spnrPercentage.setOnItemSelectedListener(this);
        spnrNoOfItemTypes.setOnItemSelectedListener(this);
        spnrItem1.setOnItemSelectedListener(this);
        spnrItem2.setOnItemSelectedListener(this);
        spnrItem3.setOnItemSelectedListener(this);
        spnrItem4.setOnItemSelectedListener(this);
        spnrItem5.setOnItemSelectedListener(this);
        spnrItem6.setOnItemSelectedListener(this);
        spnrItem7.setOnItemSelectedListener(this);
        spnrItem8.setOnItemSelectedListener(this);
        spnrItem1Count.setOnItemSelectedListener(this);
        spnrItem2Count.setOnItemSelectedListener(this);
        spnrItem3Count.setOnItemSelectedListener(this);
        spnrItem4Count.setOnItemSelectedListener(this);
        spnrItem5Count.setOnItemSelectedListener(this);
        spnrItem6Count.setOnItemSelectedListener(this);
        spnrItem7Count.setOnItemSelectedListener(this);
        spnrItem8Count.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

       /* List<LinearLayout> listOfLtemsLayout = new ArrayList<LinearLayout>();
        listOfLtemsLayout.add(llItem1);
        listOfLtemsLayout.add(llItem2);
        listOfLtemsLayout.add(llItem3);
        listOfLtemsLayout.add(llItem4);
        listOfLtemsLayout.add(llItem5);
        listOfLtemsLayout.add(llItem6);
        listOfLtemsLayout.add(llItem7);
        listOfLtemsLayout.add(llItem8);*/

        Spinner spinner = (Spinner) parent;
        if (spinner.getId() == R.id.spnr_item1_itemlist_loan_activity) {
           // parent.getSelectedItem();
            item1Type = parent.getItemAtPosition(position).toString();
        } else if (spinner.getId() == R.id.spnr_item2_itemlist_loan_activity) {
            item2Type = parent.getItemAtPosition(position).toString();
        } else if (spinner.getId() == R.id.spnr_item3_itemlist_loan_activity) {
            item3Type = parent.getItemAtPosition(position).toString();
        } else if (spinner.getId() == R.id.spnr_item4_itemlist_loan_activity) {
            item4Type = parent.getItemAtPosition(position).toString();
        } else if (spinner.getId() == R.id.spnr_item5_itemlist_loan_activity) {
            item5Type = parent.getItemAtPosition(position).toString();
        } else if (spinner.getId() == R.id.spnr_item6_itemlist_loan_activity) {
            item6Type = parent.getItemAtPosition(position).toString();
        } else if (spinner.getId() == R.id.spnr_item7_itemlist_loan_activity) {
            item7Type = parent.getItemAtPosition(position).toString();
        } else if (spinner.getId() == R.id.spnr_item8_itemlist_loan_activity) {
            item8Type = parent.getItemAtPosition(position).toString();
        } else if (spinner.getId() == R.id.spnr_noOfItems_loan_activity) {
            String noOfItems = parent.getItemAtPosition(position).toString();
            totalItemTypes = noOfItems;
            Log.i(TAG, "onItemSelected: totalItemTypes: " + totalItemTypes);

            /*int itemchoice = Integer.parseInt(spnrNoOfItemTypes.getSelectedItem().toString());
            if(itemchoice!=0)
            {
                for (int i = 0; i < listOfLtemsLayout.size(); i++) {
                    if(i<=itemchoice)
                    {
                        listOfLtemsLayout.get(i).setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        listOfLtemsLayout.get(i).setVisibility(View.GONE);
                    }


                }

            }*/


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
            percentage = parent.getItemAtPosition(position).toString();
            Log.i(TAG, "onItemSelected: Percentage: " + percentage);
            Toast.makeText(this, "Percentage: " + percentage, Toast.LENGTH_SHORT).show();
        } else if (spinner.getId() == R.id.spnr_item1_type_count_loan_activity) {
            item1Count = parent.getItemAtPosition(position).toString();
            Log.i(TAG, "onItemSelected: Spinner item1Count: " + item1Count);
        } else if (spinner.getId() == R.id.spnr_item2_type_count_loan_activity) {
            item2Count = parent.getItemAtPosition(position).toString();
            Log.i(TAG, "onItemSelected: Spinner item2Count: " + item2Count);
        } else if (spinner.getId() == R.id.spnr_item3_type_count_loan_activity) {
            item3Count = parent.getItemAtPosition(position).toString();
            Log.i(TAG, "onItemSelected: Spinner item3Count: " + item3Count);
        } else if (spinner.getId() == R.id.spnr_item4_type_count_loan_activity) {
            item4Count = parent.getItemAtPosition(position).toString();
            Log.i(TAG, "onItemSelected: Spinner item4Count: " + item4Count);
        } else if (spinner.getId() == R.id.spnr_item5_type_count_loan_activity) {
            item5Count = parent.getItemAtPosition(position).toString();
            Log.i(TAG, "onItemSelected: Spinner item5Count: " + item5Count);
        } else if (spinner.getId() == R.id.spnr_item6_type_count_loan_activity) {
            item6Count = parent.getItemAtPosition(position).toString();
            Log.i(TAG, "onItemSelected: Spinner item6Count: " + item6Count);
        } else if (spinner.getId() == R.id.spnr_item7_type_count_loan_activity) {
            item7Count = parent.getItemAtPosition(position).toString();
            Log.i(TAG, "onItemSelected: Spinner item7Count: " + item7Count);
        } else if (spinner.getId() == R.id.spnr_item8_type_count_loan_activity) {
            item8Count = parent.getItemAtPosition(position).toString();
            Log.i(TAG, "onItemSelected: Spinner item8Count: " + item8Count);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void captureImage(View view) {
        if (!isDeviceSupportCamera()) {
            Toast.makeText(getApplicationContext(),
                    "Sorry! Your device doesn't support camera",
                    Toast.LENGTH_LONG).show();
            // will close the app if the device does't have camera
            finish();
        } else {
            if (view.equals(findViewById(R.id.iv_customer_photo_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_customer_photo_loan_activity);
            } else if (view.equals(findViewById(R.id.iv_item1_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_item1_loan_activity);
            } else if (view.equals(findViewById(R.id.iv_item2_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_item2_loan_activity);
            } else if (view.equals(findViewById(R.id.iv_item3_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_item3_loan_activity);
            } else if (view.equals(findViewById(R.id.iv_item4_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_item4_loan_activity);
            } else if (view.equals(findViewById(R.id.iv_item5_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_item5_loan_activity);
            } else if (view.equals(findViewById(R.id.iv_item6_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_item6_loan_activity);
            } else if (view.equals(findViewById(R.id.iv_item7_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_item7_loan_activity);
            } else if (view.equals(findViewById(R.id.iv_item8_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_item8_loan_activity);
            } else if (view.equals(findViewById(R.id.iv_customer_photo_loan_activity))) {
                currentImageView = (ImageView) view.findViewById(R.id.iv_customer_photo_loan_activity);
            }


            Log.i(TAG, "captureImage: currentImageView: " + currentImageView);
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
            Log.i(TAG, "captureImage: fileUri: "+fileUri);
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
                if (currentImageView.equals(ivCustomerPhoto)) {
                    custImgPath = fileUri.getPath();
                    previewCapturedImage();
                } else if (currentImageView.equals(ivItem1)) {
                    ivItem1.setImageResource(R.drawable.saved_48);
                    imgPath1 = fileUri.getPath();
                    Log.i(TAG, "onActivityResult: imgPath1: " + imgPath1);
                } else if (currentImageView == ivItem2) {
                    ivItem2.setImageResource(R.drawable.saved_48);
                    imgPath2 = fileUri.getPath();
                    Log.i(TAG, "onActivityResult: imgPath2: " + imgPath2);
                } else if (currentImageView == ivItem3) {
                    ivItem3.setImageResource(R.drawable.saved_48);
                    imgPath3 = fileUri.getPath();
                    Log.i(TAG, "onActivityResult: imgPath3: " + imgPath3);
                } else if (currentImageView == ivItem4) {
                    ivItem4.setImageResource(R.drawable.saved_48);
                    imgPath4 = fileUri.getPath();
                    Log.i(TAG, "onActivityResult: imgPath4: " + imgPath4);
                } else if (currentImageView == ivItem5) {
                    ivItem5.setImageResource(R.drawable.saved_48);
                    imgPath5 = fileUri.getPath();
                    Log.i(TAG, "onActivityResult: imgPath5: " + imgPath5);
                } else if (currentImageView == ivItem6) {
                    ivItem6.setImageResource(R.drawable.saved_48);
                    imgPath6 = fileUri.getPath();
                    Log.i(TAG, "onActivityResult: imgPath6: " + imgPath6);
                } else if (currentImageView == ivItem7) {
                    ivItem7.setImageResource(R.drawable.saved_48);
                    imgPath7 = fileUri.getPath();
                    Log.i(TAG, "onActivityResult: imgPath7: " + imgPath7);

                } else if (currentImageView == ivItem8) {
                    ivItem8.setImageResource(R.drawable.saved_48);
                    imgPath8 = fileUri.getPath();
                    Log.i(TAG, "onActivityResult: imgPath8: " + imgPath8);
                }

            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(),
                        "Image capture cancelled",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Sorry! Failed to capture image"
                        , Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void previewCapturedImage() {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();

            options.inSampleSize = 8;
            final Bitmap bitmap = BitmapFactory.decodeFile(fileUri.getPath(), options);
            ivCustomerPhoto.setImageBitmap(bitmap);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState: fileUri: "+fileUri);
        outState.putParcelable("file_uri", fileUri);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState: fileUri: "+fileUri);
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
        Log.i(TAG, "getOutputMediaFile: timeStamp: "+timeStamp);
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "GBG_" + timeStamp + ".jpg");
            Log.i(TAG, "getOutputMediaFile: mediaFile: "+mediaFile);
        } else {
            return null;
        }
        return mediaFile;
    }

    private void getFieldValues() {
        String uniqueId = tvUUId.getText().toString();
        String name = etName.getText().toString();
        String contact = etContact.getText().toString();
        String amount = etAmount.getText().toString();
        String percentage = this.percentage;
        String totalItemTypes = this.totalItemTypes;
        String itemWeight1 = etItem1Wt1.getText().toString();
        String itemWeight2 = etItem2Wt2.getText().toString();
        String itemWeight3 = etItem3Wt3.getText().toString();
        String itemWeight4 = etItem4Wt4.getText().toString();
        String itemWeight5 = etItem5Wt5.getText().toString();
        String itemWeight6 = etItem6Wt6.getText().toString();
        String itemWeight7 = etItem7Wt7.getText().toString();
        String itemWeight8 = etItem8Wt8.getText().toString();
        String description = etDescription.getText().toString();

        loan.checkValue();

        if (uniqueId != null && !uniqueId.isEmpty()) {
            loan.setUniqueLoanId(uniqueId);
        } else
            Toast.makeText(this, "Unique id not generated. Please contact support", Toast.LENGTH_SHORT).show();

        if (name != null && !name.isEmpty()) {
            loan.setCustomerName(name);
        } else {
            Toast.makeText(this, "Please enter customer name", Toast.LENGTH_SHORT).show();
        }

        if (contact != null && !contact.isEmpty()) {
            loan.setCustomerContactNumber(contact);
        } else {
            Toast.makeText(this, "Please enter customer contact number", Toast.LENGTH_SHORT).show();
        }

        if (amount != null && !amount.isEmpty()) {
            loan.setAmount(Double.parseDouble(amount));
        } else {
            Toast.makeText(this, "Please enter amount", Toast.LENGTH_SHORT).show();
        }

        loan.setPercentage(Double.parseDouble(percentage));
        loan.setNoOfTypesOfItems(Integer.parseInt(totalItemTypes));
        loan.setDescription(description);
        loan.setCustomerPhoto(custImgPath);

        if (itemWeight1 != null && !itemWeight1.isEmpty()
                && item1Count != null && !item1Count.isEmpty()
                && imgPath1 != null && !imgPath1.isEmpty()
                && item1Type != null && !item1Type.isEmpty()) {
            loan.setItem1Count(Integer.parseInt(item1Count));
            loan.setItem1Weight(Double.parseDouble(itemWeight1));
            loan.setItem1PhotoPath(imgPath1);
            loan.setItem1Type(item1Type);
        } else {
            Toast.makeText(this, "Please input all the values for the first item", Toast.LENGTH_SHORT).show();
        }

        if (llItem2.getVisibility() == View.VISIBLE) {
            if (itemWeight2 != null && !itemWeight2.isEmpty()
                    && item2Count != null && !item2Count.isEmpty()
                    && imgPath2 != null && !imgPath2.isEmpty()
                    && item2Type != null && !item2Type.isEmpty()) {
                loan.setItem2Count(Integer.parseInt(item2Count));
                loan.setItem2Weight(Double.parseDouble(itemWeight2));
                loan.setItem2PhotoPath(imgPath2);
                loan.setItem2Type(item2Type);
            } else {
                Toast.makeText(this, "Please input all the values for the second item", Toast.LENGTH_SHORT).show();
            }
        }

        if(llItem3.getVisibility() == View.VISIBLE) {
            if (itemWeight3 != null && !itemWeight3.isEmpty()
                    && item3Count != null && !item3Count.isEmpty()
                    && imgPath3 != null && !imgPath3.isEmpty()
                    && item3Type != null && !item3Type.isEmpty()) {
                loan.setItem3Count(Integer.parseInt(item3Count));
                loan.setItem3Weight(Double.parseDouble(itemWeight3));
                loan.setItem3PhotoPath(imgPath3);
                loan.setItem3Type(item3Type);
            } else {
                Toast.makeText(this, "Please input all the values for the third item", Toast.LENGTH_SHORT).show();
            }
        }

        if(llItem4.getVisibility() == View.VISIBLE) {
            if (itemWeight4 != null && !itemWeight4.isEmpty()
                    && item4Count != null && !item4Count.isEmpty()
                    && imgPath4 != null && !imgPath4.isEmpty()
                    && item4Type != null && !item4Type.isEmpty()) {
                loan.setItem4Count(Integer.parseInt(item4Count));
                loan.setItem4Weight(Double.parseDouble(itemWeight4));
                loan.setItem4PhotoPath(imgPath4);
                loan.setItem4Type(item4Type);
            } else {
                Toast.makeText(this, "Please input all the values for the fourth item", Toast.LENGTH_SHORT).show();
            }
        }

        if(llItem5.getVisibility() == View.VISIBLE) {
            if (itemWeight5 != null && !itemWeight5.isEmpty()
                    && item5Count != null && !item5Count.isEmpty()
                    && imgPath5 != null && !imgPath5.isEmpty()
                    && item5Type != null && !item5Type.isEmpty()) {
                loan.setItem5Count(Integer.parseInt(item5Count));
                loan.setItem5Weight(Double.parseDouble(itemWeight5));
                loan.setItem5PhotoPath(imgPath5);
                loan.setItem5Type(item5Type);
            } else {
                Toast.makeText(this, "Please input all the values for the fifth item", Toast.LENGTH_SHORT).show();
            }
        }

        if(llItem6.getVisibility() == View.VISIBLE) {
            if (itemWeight6 != null && !itemWeight6.isEmpty()
                    && item6Count != null && !item6Count.isEmpty()
                    && imgPath6 != null && !imgPath6.isEmpty()
                    && item6Type != null && !item6Type.isEmpty()) {
                loan.setItem6Count(Integer.parseInt(item6Count));
                loan.setItem6Weight(Double.parseDouble(itemWeight6));
                loan.setItem6PhotoPath(imgPath6);
                loan.setItem6Type(item6Type);
            } else {
                Toast.makeText(this, "Please input all the values for the sixth item", Toast.LENGTH_SHORT).show();
            }

        }

        if(llItem7.getVisibility() == View.VISIBLE) {
            if (itemWeight7 != null && !itemWeight7.isEmpty()
                    && item7Count != null && !item7Count.isEmpty()
                    && imgPath7 != null && !imgPath7.isEmpty()
                    && item7Type != null && !item7Type.isEmpty()) {
                loan.setItem7Count(Integer.parseInt(item7Count));
                loan.setItem7Weight(Double.parseDouble(itemWeight7));
                loan.setItem7PhotoPath(imgPath7);
                loan.setItem7Type(item7Type);
            } else {
                Toast.makeText(this, "Please input all the values for the seventh item", Toast.LENGTH_SHORT).show();
            }
        }


        if(llItem8.getVisibility() == View.VISIBLE) {
            if (itemWeight8 != null && !itemWeight8.isEmpty()
                    && item8Count != null && !item8Count.isEmpty()
                    && imgPath8 != null && !imgPath8.isEmpty()
                    && item8Type != null && !item8Type.isEmpty()) {
                loan.setItem8Count(Integer.parseInt(item8Count));
                loan.setItem8Weight(Double.parseDouble(itemWeight8));
                loan.setItem8PhotoPath(imgPath8);
                loan.setItem8Type(item8Type);
            } else {
                Toast.makeText(this, "Please input all the values for the eighth item", Toast.LENGTH_SHORT).show();
            }
        }


        Toast.makeText(this, "Values: \n" +
                        "uniqueId: " + loan.getUniqueLoanId() +"\n"+
                        " name: " + loan.getCustomerName() +"\n"+
                        " contact: " + loan.getCustomerContactNumber() +"\n"+
                        " amount: "+ loan.getAmount() +"\n"+
                        " percentage: "+loan.getPercentage() +"\n"+
                        " totalItemtypes: "+loan.getNoOfTypesOfItems() +"\n"+
                        " description: "+loan.getDescription() +"\n"+
                        " itemWeight1: "+loan.getItem1Weight()+"\n" +
                        " photoPath1: "+loan.getItem1PhotoPath() +"\n"+
                        " item1Type: "+loan.getItem1Type()+"\n"+
                        " item1Count: "+loan.getItem1Count() +"\n"+
                        " itemWeight2: "+loan.getItem2Weight()+"\n" +
                        " photoPath2: "+loan.getItem2PhotoPath() +"\n"+
                        " item2Type: "+loan.getItem2Type()+"\n"+
                        " item2Count: "+loan.getItem2Count() +"\n"+
                        " itemWeight3: "+loan.getItem3Weight() +"\n"+
                        " photoPath3: "+loan.getItem3PhotoPath() +"\n"+
                        " item3Type: "+loan.getItem3Type()+"\n"+
                        " item3Count: "+loan.getItem3Count() +"\n"+
                        " itemWeight4: "+loan.getItem4Weight() +"\n"+
                        " photoPath4: "+loan.getItem4PhotoPath() +"\n"+
                        " item4Type: "+loan.getItem4Type()+"\n"+
                        " item4Count: "+loan.getItem4Count() +"\n"+
                        " itemWeight5: "+loan.getItem5Weight() +"\n"+
                        " photoPath5: "+loan.getItem5PhotoPath() +"\n"+
                        " item5Type: "+loan.getItem5Type()+"\n"+
                        " item5Count: "+loan.getItem5Count() +"\n"+
                        " itemWeight6: "+loan.getItem6Weight() +"\n"+
                        " photoPath6: "+loan.getItem6PhotoPath() +"\n"+
                        " item6Type: "+loan.getItem6Type()+"\n"+
                        " item6Count: "+loan.getItem6Count() +"\n"+
                        " itemWeight7: "+loan.getItem7Weight() +"\n"+
                        " photoPath7: "+loan.getItem7PhotoPath() +"\n"+
                        " item7Type: "+loan.getItem7Type()+"\n"+
                        " item7Count: "+loan.getItem7Count() +"\n"+
                        " itemWeight8: "+loan.getItem8Weight() +"\n"+
                        " photoPath8: "+loan.getItem8PhotoPath() +"\n"+
                        " item8Type: "+loan.getItem8Type()+"\n"+
                        " item8Count: "+loan.getItem8Count(),
                Toast.LENGTH_SHORT).show();

    }

    public void onSave(View view) {
        getFieldValues();


    }

    public void onUpload(View view) {
        getFieldValues();
        String loginId = "admin";
        String password = "admin";
        new SendLoanDetails(this, loan).execute(loginId, password);
    }
}
