package Ourclasses;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
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
    final static  String pservices = "D:\\projects\\oop\\Hotel_Reservation_System_v2\\src\\OurFiles\\Services.txt";
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

    public static String getPservices() {
        return pservices;
    }
    
    
 //*********************************************************
     public static void Add(int serviceNo, String serviceName, double price, String serviceStatus){ //For Services
        try{
            FileWriter file = new FileWriter(pservices, true);
            file.write(serviceNo + " " + serviceName + " " + price + " " + serviceStatus + "\n");
            file.close();
            JOptionPane.showMessageDialog(null, "Service Added Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
    //***************************************************
     public static void Remove(int id){
        ArrayList<String> ourDate = new ArrayList<String>();
        File file = new File(pservices);
        String info = "";
        
        try{
            Scanner in = new Scanner(file);
            while (in.hasNext()){
                ourDate.add(in.nextLine());
            }
            
            String[] checkedDate = null;            
            for(int i=0;i<ourDate.size();i++)
            {
                info = ourDate.get(i);
                checkedDate = info.split("\\s");
                if(Integer.parseInt(checkedDate[0]) == id)
                    ourDate.remove(i);
            }
            
            FileWriter write = new FileWriter(pservices);
            for(int i=0;i<ourDate.size();i++)    
                write.write(ourDate.get(i)+"\n");
            write.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //**********************************************
     public static void Update (int checkedId, int serviceNo, String serviceName, double price, String serviceStatus){
        ArrayList<String> ourDate = new ArrayList<String>();
        File file = new File(pservices);
        String info = "";
        
        try{
            Scanner in = new Scanner(file);
            while (in.hasNext()){
                ourDate.add(in.nextLine());
            }
            
            String[] checkedDate = null;           
            for(int i=0;i<ourDate.size();i++)
            {
                info = ourDate.get(i);
                checkedDate = info.split("\\s");
                if(Integer.parseInt(checkedDate[0]) == checkedId)
                    ourDate.set(i,serviceNo + " " + serviceName + " " + price + " " + serviceStatus);
            }
            
            FileWriter write = new FileWriter(pservices);
            for(int i=0;i<ourDate.size();i++)    
                write.write(ourDate.get(i)+"\n");
            write.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
    //***********************************
       public static String[] Get(){
        ArrayList<String> data = new ArrayList<String>();
        String[] info = null;
        File file = new File(pservices);
        try{
            Scanner in = new Scanner(file);
            while(in.hasNext()){
                data.add(in.nextLine());
            }
            info = data.toArray(new String[0]);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return info;
    }
    //********************************************
      
    
    
}
