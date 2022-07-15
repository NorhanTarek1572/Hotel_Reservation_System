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
public class Room {
   //***********************************
   private int number;
   private String type;
   private double price ;
   private String status;
   final  static String proom="D:\\projects\\oop\\Hotel_Reservation_System_v2\\src\\OurFiles\\Rooms.txt";
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

    public static String getProom() {
        return proom;
    }
    
    
     //=====================================================(**************************)==============================
    public static void Add(int roomNo, String roomType, double price, String roomStatus){ //For Rooms
        try{
            FileWriter file = new FileWriter(proom, true);
            file.write(roomNo + " " + roomType + " " + price + " " + roomStatus + "\n");
            file.close();
            JOptionPane.showMessageDialog(null, "Room Added Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
        
        }
        //*******************************
    public static void Update(int checkedId, int roomNo, String roomType, double price, String roomStatus){
        ArrayList<String> ourDate = new ArrayList<String>();
        File file = new File(proom);
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
                    ourDate.set(i,roomNo + " " + roomType + " " + price + " " + roomStatus);
            }
            
            FileWriter write = new FileWriter(proom);
            for(int i=0;i<ourDate.size();i++)    
                write.write(ourDate.get(i)+"\n");
            write.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
        
        }
        //*******************************
    public static String[] Get(){
            
            ArrayList<String> data = new ArrayList<String>();
            String[] info = null;
            File file = new File(proom);
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
        //*******************************
    public static void Remove(int id){

            ArrayList<String> ourDate = new ArrayList<String>();
            File file = new File(proom);
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

                FileWriter write = new FileWriter(proom);
                for(int i=0;i<ourDate.size();i++)    
                    write.write(ourDate.get(i)+"\n");
                write.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
         }
    //================================================================================================================
        
        
    
    
    
}
