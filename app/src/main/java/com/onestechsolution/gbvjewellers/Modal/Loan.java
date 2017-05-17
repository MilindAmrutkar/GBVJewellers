package com.onestechsolution.gbvjewellers.Modal;

/**
 * Created by Admin on 5/12/2017.
 */

public class Loan {
    private String uniqueLoanId;
    private String customerName;
    private String customerPhoto;
    private String customerContactNumber;
    private double amount;
    private String description;
    private int noOfTypesOfItems;
    private double percentage;

    public Loan(String uniqueLoanId, String customerName, String customerPhoto, String customerContactNumber, double amount) {
        this.uniqueLoanId = uniqueLoanId;
        this.customerName = customerName;
        this.customerPhoto = customerPhoto;
        this.customerContactNumber = customerContactNumber;
        this.amount = amount;
    }

    public Loan() {
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    private int item1Count, item2Count, item3Count, item4Count, item5Count, item6Count, item7Count, item8Count;
    private double item1Weight, item2Weight, item3Weight, item4Weight, item5Weight, item6Weight, item7Weight, item8Weight;
    private String item1Type, item2Type, item3Type, item4Type, item5Type, item6Type, item7Type, item8Type;
    private String item1PhotoPath, item2PhotoPath, item3PhotoPath, item4PhotoPath, item5PhotoPath, item6PhotoPath, item7PhotoPath, item8PhotoPath;

    public String getUniqueLoanId() {
        return uniqueLoanId;
    }

    public void setUniqueLoanId(String uniqueLoanId) {
        this.uniqueLoanId = uniqueLoanId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhoto() {
        return customerPhoto;
    }

    public void setCustomerPhoto(String customerPhoto) {
        this.customerPhoto = customerPhoto;
    }

    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerContactNumber(String customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNoOfTypesOfItems() {
        return noOfTypesOfItems;
    }

    public void setNoOfTypesOfItems(int noOfTypesOfItems) {
        this.noOfTypesOfItems = noOfTypesOfItems;
    }

    public int getItem1Count() {
        return item1Count;
    }

    public void setItem1Count(int item1Count) {
        this.item1Count = item1Count;
    }

    public int getItem2Count() {
        return item2Count;
    }

    public void setItem2Count(int item2Count) {
        this.item2Count = item2Count;
    }

    public int getItem3Count() {
        return item3Count;
    }

    public void setItem3Count(int item3Count) {
        this.item3Count = item3Count;
    }

    public int getItem4Count() {
        return item4Count;
    }

    public void setItem4Count(int item4Count) {
        this.item4Count = item4Count;
    }

    public int getItem5Count() {
        return item5Count;
    }

    public void setItem5Count(int item5Count) {
        this.item5Count = item5Count;
    }

    public int getItem6Count() {
        return item6Count;
    }

    public void setItem6Count(int item6Count) {
        this.item6Count = item6Count;
    }

    public int getItem7Count() {
        return item7Count;
    }

    public void setItem7Count(int item7Count) {
        this.item7Count = item7Count;
    }

    public int getItem8Count() {
        return item8Count;
    }

    public void setItem8Count(int item8Count) {
        this.item8Count = item8Count;
    }

    public double getItem1Weight() {
        return item1Weight;
    }

    public void setItem1Weight(double item1Weight) {
        this.item1Weight = item1Weight;
    }

    public double getItem2Weight() {
        return item2Weight;
    }

    public void setItem2Weight(double item2Weight) {
        this.item2Weight = item2Weight;
    }

    public double getItem3Weight() {
        return item3Weight;
    }

    public void setItem3Weight(double item3Weight) {
        this.item3Weight = item3Weight;
    }

    public double getItem4Weight() {
        return item4Weight;
    }

    public void setItem4Weight(double item4Weight) {
        this.item4Weight = item4Weight;
    }

    public double getItem5Weight() {
        return item5Weight;
    }

    public void setItem5Weight(double item5Weight) {
        this.item5Weight = item5Weight;
    }

    public double getItem6Weight() {
        return item6Weight;
    }

    public void setItem6Weight(double item6Weight) {
        this.item6Weight = item6Weight;
    }

    public double getItem7Weight() {
        return item7Weight;
    }

    public void setItem7Weight(double item7Weight) {
        this.item7Weight = item7Weight;
    }

    public double getItem8Weight() {
        return item8Weight;
    }

    public void setItem8Weight(double item8Weight) {
        this.item8Weight = item8Weight;
    }

    public String getItem1Type() {
        return item1Type;
    }

    public void setItem1Type(String item1Type) {
        this.item1Type = item1Type;
    }

    public String getItem2Type() {
        return item2Type;
    }

    public void setItem2Type(String item2Type) {
        this.item2Type = item2Type;
    }

    public String getItem3Type() {
        return item3Type;
    }

    public void setItem3Type(String item3Type) {
        this.item3Type = item3Type;
    }

    public String getItem4Type() {
        return item4Type;
    }

    public void setItem4Type(String item4Type) {
        this.item4Type = item4Type;
    }

    public String getItem5Type() {
        return item5Type;
    }

    public void setItem5Type(String item5Type) {
        this.item5Type = item5Type;
    }

    public String getItem6Type() {
        return item6Type;
    }

    public void setItem6Type(String item6Type) {
        this.item6Type = item6Type;
    }

    public String getItem7Type() {
        return item7Type;
    }

    public void setItem7Type(String item7Type) {
        this.item7Type = item7Type;
    }

    public String getItem8Type() {
        return item8Type;
    }

    public void setItem8Type(String item8Type) {
        this.item8Type = item8Type;
    }

    public String getItem1PhotoPath() {
        return item1PhotoPath;
    }

    public void setItem1PhotoPath(String item1PhotoPath) {
        this.item1PhotoPath = item1PhotoPath;
    }

    public String getItem2PhotoPath() {
        return item2PhotoPath;
    }

    public void setItem2PhotoPath(String item2PhotoPath) {
        this.item2PhotoPath = item2PhotoPath;
    }

    public String getItem3PhotoPath() {
        return item3PhotoPath;
    }

    public void setItem3PhotoPath(String item3PhotoPath) {
        this.item3PhotoPath = item3PhotoPath;
    }

    public String getItem4PhotoPath() {
        return item4PhotoPath;
    }

    public void setItem4PhotoPath(String item4PhotoPath) {
        this.item4PhotoPath = item4PhotoPath;
    }

    public String getItem5PhotoPath() {
        return item5PhotoPath;
    }

    public void setItem5PhotoPath(String item5PhotoPath) {
        this.item5PhotoPath = item5PhotoPath;
    }

    public String getItem6PhotoPath() {
        return item6PhotoPath;
    }

    public void setItem6PhotoPath(String item6PhotoPath) {
        this.item6PhotoPath = item6PhotoPath;
    }

    public String getItem7PhotoPath() {
        return item7PhotoPath;
    }

    public void setItem7PhotoPath(String item7PhotoPath) {
        this.item7PhotoPath = item7PhotoPath;
    }

    public String getItem8PhotoPath() {
        return item8PhotoPath;
    }

    public void setItem8PhotoPath(String item8PhotoPath) {
        this.item8PhotoPath = item8PhotoPath;
    }

     public String checkValue()
     {



       return null;
     }
}
