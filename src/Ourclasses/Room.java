package Ourclasses;

import Databases.DbActions;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Room {
   //***********************************
   private int number;
   private String type;
   private double price ;
   private String status;
    Service serv = new Service();
//*************************************** 

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Service getServ() {
        return serv;
    }

    public void setServ(Service serv) {
        this.serv = serv;
    }

   
    
    
    //============================================**************************==============================
    public static void Add(int roomNo, String roomType, double price, String roomStatus){ //For Rooms
       // file.write(roomNo + " " + roomType + " " + price + " " + roomStatus + "\n");
          try{
                
                ResultSet rs = DbActions.getDate( "SELECT * FROM room  WHERE id ="+roomNo+" " );
                if(rs.next())
                {
                   JOptionPane.showMessageDialog(null, "This room Is Already Exist");
                   
                }
                else{
                    DbActions.setData(" INSERT INTO room VALUES (  " +roomNo+ " ,'"+roomType+"'  ,"+price+" , '"+roomStatus+"' ) ", "Room Is Added" );
                   
                }
        }
             catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);

                }
            
     
        
        }
   //*******************************************************************************************
    public static void Update(int checkedId, int roomNo, String roomType, double price, String roomStatus){
         //ourDate.set(i,roomNo + " " + roomType + " " + price + " " + roomStatus);
        try {
              DbActions.setData( "UPDATE room SET id= " +roomNo+ " ,type= '"+roomType+"',price= "+price+"  ,status= '"+roomStatus+"' WHERE id= " +checkedId+" " , "Room Update Successfully" );
              
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
            }
        
        }
    //*******************************************************************************************
    public static  ResultSet Get(){
           // return all valuse in the table 
             ResultSet rs = null;
            try{
                  rs= DbActions.getDate("SELECT * FROM room WHERE 1");
            
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return rs;

        }
    //*******************************************************************************************
    public static void Remove(int id){

        try{
              DbActions.setData(" DELETE FROM room  WHERE id = "+id+" ", " ROOM Deleted ");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
         }
    //*******************************************************************************************    
        
    
    
    
}
