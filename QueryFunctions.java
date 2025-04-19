package Backend;

import Frontend.Login_ScreenController;
import PojoClass.pojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javafx.scene.input.KeyEvent;

public class QueryFunctions extends Myconnections {

    String url = "jdbc:mysql://localhost:3306/billing";
    String user = "root";
    String password = "724800";

    public void truncate() {
        try {
            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("truncate temp");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(PojoClass.pojo obj_pojo) {
        try {
            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("insert into temp(item_name,rate,qty,net_value,discount,discount_amount,gst,gst_amount,item_code,cus_name,cus_mobile,salse_man,dates) values(?,?,?,?,?,?,?,?,?,?,?,?,?);");
            ps.setString(1, obj_pojo.getItem_name());
            ps.setDouble(2, obj_pojo.getItem_rate());
            ps.setInt(3, obj_pojo.getQty());
            ps.setDouble(4, obj_pojo.getNet_value());
            ps.setDouble(5, obj_pojo.getDiscount());
            ps.setDouble(6, obj_pojo.getDiscount_amount());
            ps.setDouble(7, obj_pojo.getGst());
            ps.setDouble(8, obj_pojo.getGst_amount());
            ps.setInt(9, obj_pojo.getItem_code());
            ps.setString(10, obj_pojo.getCus_name());
            ps.setDouble(11, obj_pojo.getCus_mobile());
            ps.setString(12, obj_pojo.getSalse_man_name());
            ps.setString(13, obj_pojo.getDate());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PojoClass.pojo> salse_man_All() {
        ArrayList<PojoClass.pojo> list = new ArrayList();
        try {
            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("select * from salse_man");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PojoClass.pojo obj_pojo = new pojo();
                obj_pojo.setSalse_man_name(rs.getString("name"));
                obj_pojo.setId(rs.getInt("id"));
                list.add(obj_pojo);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public PojoClass.pojo select_one(PojoClass.pojo obj_pojo) {
        try {
            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("select name from salse_man where id=?");
            ps.setInt(1, obj_pojo.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                obj_pojo.setSalse_man_name(rs.getString("name"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj_pojo;
    }

    public PojoClass.pojo select_one_item(PojoClass.pojo obj_pojo) {
        ArrayList<PojoClass.pojo> list = new ArrayList<>();
        try {
            QueryFunctions connect = new QueryFunctions();

            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("select * from products where item_code=?");
            ps.setInt(1, obj_pojo.getItem_code());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                obj_pojo.setSno(rs.getInt("sno"));
                obj_pojo.setItem_name(rs.getString("item_name"));
                obj_pojo.setItem_rate(rs.getDouble("rate"));
                obj_pojo.setQty(rs.getInt("qty"));
                obj_pojo.setNet_value(rs.getDouble("net_value"));
                obj_pojo.setDiscount(rs.getDouble("discount"));
                obj_pojo.setDiscount_amount(rs.getDouble("disc_amount"));
                obj_pojo.setGst(rs.getDouble("gst"));
                obj_pojo.setGst_amount(rs.getDouble("gst_amount"));
                obj_pojo.setItem_code(rs.getInt("item_code"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj_pojo;
    }

    public ArrayList<PojoClass.pojo> select_All() {
        ArrayList<PojoClass.pojo> list = new ArrayList<>();
        try {

            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("select * from products");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PojoClass.pojo obj_pojo = new pojo();

                obj_pojo.setSno(rs.getInt("sno"));
                obj_pojo.setItem_name(rs.getString("item_name"));
                obj_pojo.setItem_rate(rs.getInt("rate"));
                obj_pojo.setQty(rs.getInt("qty"));
                obj_pojo.setNet_value(rs.getDouble("net_value"));
                obj_pojo.setDiscount(rs.getDouble("discount"));
                obj_pojo.setDiscount_amount(rs.getDouble("disc_amount"));
                obj_pojo.setGst(rs.getDouble("gst"));
                obj_pojo.setGst_amount(rs.getDouble("gst_amount"));
                obj_pojo.setItem_code(rs.getInt("item_code"));
                list.add(obj_pojo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void menu_delete(PojoClass.pojo obj_pojo) {
        try {
            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("delete from products where item_code=?");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert_salse_man(PojoClass.pojo obj_pojo) {
        try {
            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("insert into salse_man(name,id) values(?,?)");
            ps.setString(1, obj_pojo.getSalse_man_name());
            ps.setInt(2, obj_pojo.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update_salse_man(PojoClass.pojo obj_pojo) {
        try {
            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("update salse_man set name=?,id=? where id=?;");
            ps.setString(1, obj_pojo.getSalse_man_name());
            ps.setInt(2, obj_pojo.getId());
            ps.setInt(3, obj_pojo.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete_salse_man(PojoClass.pojo obj_pojo) {
        try {
            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("delete from salse_man where id=?;");
            ps.setInt(1, obj_pojo.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PojoClass.pojo> select_All_products() {
        ArrayList<PojoClass.pojo> list = new ArrayList<>();
        try {
            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("select item_name,rate,item_code from products;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PojoClass.pojo obj_pojo = new pojo();
                obj_pojo.setItem_name(rs.getString("item_name"));
                obj_pojo.setItem_rate(rs.getInt("rate"));
                obj_pojo.setItem_code(rs.getInt("item_code"));
                list.add(obj_pojo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert_products(PojoClass.pojo obj_pojo) {

        try {
            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("insert into products(item_name,rate,item_code) values(?,?,?);");
            ps.setString(1, obj_pojo.getItem_name());
            ps.setDouble(2, obj_pojo.getItem_rate());
            ps.setInt(3, obj_pojo.getItem_code());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update_products(PojoClass.pojo obj_pojo) {

        try {
            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("update products set item_name=?,rate=?,item_code=? where item_code=?;");
            ps.setString(1, obj_pojo.getItem_name());
            ps.setDouble(2, obj_pojo.getItem_rate());
            ps.setInt(3, obj_pojo.getItem_code());
            ps.setInt(4, obj_pojo.getItem_code());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete_products(PojoClass.pojo obj_pojo) {

        try {
            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("delete from products where item_code=?;");
            ps.setInt(1, obj_pojo.getItem_code());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PojoClass.pojo> report_select_All() {
        ArrayList<PojoClass.pojo> list = new ArrayList<>();
        try {

            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("select * from orginal;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PojoClass.pojo obj_pojo = new pojo();
                obj_pojo.setItem_name(rs.getString("item_name"));
                obj_pojo.setItem_rate(rs.getDouble("rate"));
                obj_pojo.setQty(rs.getInt("qty"));
                obj_pojo.setNet_value(rs.getDouble("net_value"));
                obj_pojo.setDiscount(rs.getDouble("discount"));
                obj_pojo.setDiscount_amount(rs.getDouble("discount_amount"));
                obj_pojo.setGst(rs.getDouble("gst"));
                obj_pojo.setGst_amount(rs.getDouble("gst_amount"));
                obj_pojo.setItem_code(rs.getInt("item_code"));
                obj_pojo.setCus_name(rs.getString("cus_name"));
                obj_pojo.setCus_mobile(rs.getLong("cus_mobile"));
                obj_pojo.setSalse_man_name(rs.getString("salse_man"));
                obj_pojo.setDate(rs.getString("dates"));
                list.add(obj_pojo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public PojoClass.pojo Total_Amount(PojoClass.pojo obj_pojo) {

        try {

            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("select sum(net_value) from orginal;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                obj_pojo.setNet_value(rs.getDouble("sum(net_value)"));
                obj_pojo.full_amount();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj_pojo;
        
    }
    public void Current_Day_Total_Amount() {

        try {
            String date = Login_ScreenController.date;
            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("select sum(net_value) from orginal where dates=?;");
            ps.setString(1, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PojoClass.pojo obj_pojo = new pojo();
                obj_pojo.setNet_value(rs.getDouble("sum(net_value)"));
                obj_pojo.tot_amount();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

    public ArrayList<PojoClass.pojo> From_Date_to_Date(PojoClass.pojo obj_pojo1) {
        ArrayList<PojoClass.pojo> list= new ArrayList<>();
        try {

            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("select * from orginal  where dates between ? and ?;");
            ps.setString(1, obj_pojo1.getStartDate());
            ps.setString(2, obj_pojo1.getEndDate());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PojoClass.pojo obj_pojo = new pojo();
                obj_pojo.setItem_name(rs.getString("item_name"));
                obj_pojo.setItem_rate(rs.getDouble("rate"));
                obj_pojo.setQty(rs.getInt("qty"));
                obj_pojo.setNet_value(rs.getDouble("net_value"));
                obj_pojo.setDiscount(rs.getDouble("discount"));
                obj_pojo.setDiscount_amount(rs.getDouble("discount_amount"));
                obj_pojo.setGst(rs.getDouble("gst"));
                obj_pojo.setGst_amount(rs.getDouble("gst_amount"));
                obj_pojo.setItem_code(rs.getInt("item_code"));
                obj_pojo.setCus_name(rs.getString("cus_name"));
                obj_pojo.setCus_mobile(rs.getLong("cus_mobile"));
                obj_pojo.setSalse_man_name(rs.getString("salse_man"));
                obj_pojo.setDate(rs.getString("dates"));
                list.add(obj_pojo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
        public PojoClass.pojo SumOf_From_Date_to_Date(PojoClass.pojo obj_pojo) {
            
            System.out.println(obj_pojo.getStartDate());
            System.out.println(obj_pojo.getEndDate());
        try {
            
            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("select sum(net_value) from orginal  where dates between ? and ?;");
            ps.setString(1, obj_pojo.getStartDate());
            ps.setString(2, obj_pojo.getEndDate());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                obj_pojo.setNet_value(rs.getDouble("sum(net_value)"));
                obj_pojo.date_to_date_amount();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
            System.out.println(obj_pojo.getNet_value());
        return obj_pojo;
    }

public ArrayList<PojoClass.pojo> Current_Date(PojoClass.pojo obj_pojo1) {
        ArrayList<PojoClass.pojo> list= new ArrayList<>();
        try {

            QueryFunctions connect = new QueryFunctions();
            Connection con = connect.mysql(url, user, password);
            PreparedStatement ps = con.prepareStatement("select * from orginal  where dates=?;");
            ps.setString(1, obj_pojo1.getDate());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PojoClass.pojo obj_pojo = new pojo();
                obj_pojo.setItem_name(rs.getString("item_name"));
                obj_pojo.setItem_rate(rs.getDouble("rate"));
                obj_pojo.setQty(rs.getInt("qty"));
                obj_pojo.setNet_value(rs.getDouble("net_value"));
                obj_pojo.setDiscount(rs.getDouble("discount"));
                obj_pojo.setDiscount_amount(rs.getDouble("discount_amount"));
                obj_pojo.setGst(rs.getDouble("gst"));
                obj_pojo.setGst_amount(rs.getDouble("gst_amount"));
                obj_pojo.setItem_code(rs.getInt("item_code"));
                obj_pojo.setCus_name(rs.getString("cus_name"));
                obj_pojo.setCus_mobile(rs.getLong("cus_mobile"));
                obj_pojo.setSalse_man_name(rs.getString("salse_man"));
                obj_pojo.setDate(rs.getString("dates"));
                list.add(obj_pojo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
