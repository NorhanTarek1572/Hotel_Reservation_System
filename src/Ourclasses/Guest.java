
package Ourclasses;

import Databases.DbActions;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Guest {
   //================================
    private String name ;
    private int id ;
    private String mobile ;
    private String gender ;
    private String check_in;
    private String check_out;
    private double total_price ;// service price + room price 
    private int num_of_days ;
  
    Room room =new Room();
    
//=============================== getter and setter ===========================

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getNum_of_days() {
        return num_of_days;
    }

    public void setNum_of_days(int num_of_days) {
        this.num_of_days = num_of_days;
    }

 

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    
    
//======================================================================
    
    
    public static void Add(String name, String mobile, String gender, int id, String checkInDate, String roomType, int roomNo, double price){ //For Guests
      // add new guest and update the room status  to booked
      
      
       try{
                String Query  ="SELECT * FROM gues` WHERE id ="+id+"";
                ResultSet rs = DbActions.getDate(Query);
                if(rs.next())
                {
                   JOptionPane.showMessageDialog(null, "This Guest Is Already Exist");
                   
                }
                else{
                 
                 String Q ="INSERT INTO guest VALUES ('"+name+"','"+mobile+"','"+gender+"',"+id+",'"+checkInDate+"','"+roomType+"', "+roomNo+", "+price+")" ;   
                  DbActions.setData(Q, "Room Booked Successfully");
                   
                }
        }
             catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);

                }
            
     
    }
    //*******************************************************************************************
    public static ResultSet Get(){
           // return all valuse in  guest table
             ResultSet rs = null;
            try{
                  rs= DbActions.getDate("SELECT * FROM guest WHERE 1");
            
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return rs;
    }
    //*******************************************************************************************
    public static void deleteGuest(int id){
       try{
              DbActions.setData(" DELETE FROM guest WHERE id = "+id+" ", " Guest Deleted ");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    //*******************************************************************************************
    public static ResultSet getselected(int id){
        ResultSet rs = DbActions.getDate("select * from guest where id = " + id+ "");
        return rs;
    }
    //*******************************************************************************************
    
}
