package Ourclasses;

import Databases.DbActions;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

/**
 *
 * @author Norhan Tarek
 */
public class Service {

    private String serv_name ;
    private int serv_num;
    private  double  serv_price ;
    private  String serv_status;
   //=============================== getter and setter ===========================

    public String getServ_name() {
        return serv_name;
    }

    public void setServ_name(String serv_name) {
        this.serv_name = serv_name;
    }

    public int getServ_num() {
        return serv_num;
    }

    public void setServ_num(int serv_num) {
        this.serv_num = serv_num;
    }

    public double getServ_price() {
        return serv_price;
    }

    public void setServ_price(double serv_price) {
        this.serv_price = serv_price;
    }

    public String getServ_status() {
        return serv_status;
    }

    public void setServ_status(String serv_status) {
        this.serv_status = serv_status;
    }

    
    
    //*******************************************************************************************
     public static void Add(int serviceNo, String serviceName, double price, String serviceStatus){ //For Services
        try{
                String Query  =" SELECT * FROM service WHERE  id = "+serviceNo+" ";
                ResultSet rs = DbActions.getDate(Query);
                if(rs.next())
                {
                   JOptionPane.showMessageDialog(null, "This Service Number Is Already Exist");
                }
                else{
                    DbActions.setData(" INSERT INTO service VALUES (" +serviceNo+ " ,'"+serviceName+"'  ,"+price+" , '"+serviceStatus+"') ", "Service Added Successfully" ); 
                }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
    //*******************************************************************************************
     public static void Remove(int id){
       
        try{
              DbActions.setData(" DELETE FROM service WHERE id = "+id+" ", " Services Deleted ");

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
   //*******************************************************************************************
     public static void Update (int checkedId, int serviceNo, String serviceName, double price, String serviceStatus){
      try {
          DbActions.setData("UPDATE service SET id="+serviceNo+" ,name='"+serviceName+ "',price="+price+",status= '"+serviceStatus+"' WHERE id = "+ checkedId+" "," Services updated Successfully" );
           }
      catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
            }     
    }
    //*******************************************************************************************
       public static ResultSet Get(){
           // return all valuse in the table 
             ResultSet rs = null;
            try{
                  rs= DbActions.getDate("SELECT * FROM service WHERE 1");
            
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return rs;
        
    }
    //*******************************************************************************************
      
    
    
}
