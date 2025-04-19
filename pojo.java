package PojoClass;

public class pojo {
    public int sno_count=10;
    private int sno;
    private String cus_name;
    private long cus_mobile;
    
    private String item_name;
    private double item_rate;
    private int qty;
    private double net_value;
    private double discount;
    private double discount_amount;
    private double gst;
    private double gst_amount;
    private int item_code;
    private int id;
    private String salse_man_name;
    
    private String date;
    private Double Total_amount;
    private String StartDate;
    private String EndDate;
    
    public static String amount;
    public static String full_amount;
    public void display(){
        System.out.println(this.id);
        System.out.println(this.salse_man_name);
    }
    
    public String getSalse_man_name() {
        return salse_man_name;
    }

    public void setSalse_man_name(String salse_man_name) {
        this.salse_man_name = salse_man_name;
    }
    
    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public long getCus_mobile() {
        return cus_mobile;
    }

    public void setCus_mobile(long cus_mobile) {
        this.cus_mobile = cus_mobile;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public double getItem_rate() {
        return item_rate;
    }

    public void setItem_rate(double item_rate) {
        this.item_rate = item_rate;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getNet_value() {
        return net_value;
    }

    public void setNet_value(double net_value) {
        this.net_value = net_value;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(double discount_amount) {
        this.discount_amount = discount_amount;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public double getGst_amount() {
        return gst_amount;
    }

    public void setGst_amount(double gst_amount) {
        this.gst_amount = gst_amount;
    }

    public int getItem_code() {
        return item_code;
    }

    public void setItem_code(int item_code) {
        this.item_code = item_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTotal_amount() {
        return Total_amount;
    }

    public void setTotal_amount(Double Total_amount) {
        this.Total_amount = Total_amount;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate_Entry) {
        this.StartDate = StartDate_Entry;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String EndDate_Entry) {
        this.EndDate = EndDate_Entry;
    }

    public void tot_amount(){
        amount = Double.toString(net_value);
    }
    public void full_amount(){
        full_amount=Double.toString(net_value);
    }
    public void date_to_date_amount(){
        System.out.println(net_value);
    }

   
    
}
