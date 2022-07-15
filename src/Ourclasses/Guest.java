
package Ourclasses;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
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
  
    final  static  String pguest ="D:\\projects\\oop\\Hotel_Reservation_System_v2\\src\\OurFiles\\Guests.txt";
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

    public static String getPguest() {
        return pguest;
    }
    
    
//======================================================================
    
    
    public static void Add(String name, String mobile, String gender, int id, String checkInDate, String roomType, int roomNo, double price){ //For Guests
        try{
            FileWriter file = new FileWriter(pguest, true);
            file.write(name + " " + mobile + " " + gender + " " + id + " " + checkInDate + " " + roomType + " " + roomNo + " " + price + "\n");
            file.close();
            JOptionPane.showMessageDialog(null, "Room Booked Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static String[] getGuest(){
        ArrayList<String> data = new ArrayList<String>();
        String[] info = null;
        File file = new File(pguest);
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
    
    public static void deleteGuest(int id){
        ArrayList<String> ourDate = new ArrayList<String>();
        File file = new File(pguest);
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
                if(Integer.parseInt(checkedDate[6]) == id)
                    ourDate.remove(i);
            }
            
            FileWriter write = new FileWriter(pguest);
            for(int i=0;i<ourDate.size();i++)    
                write.write(ourDate.get(i)+"\n");
                write.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    //=============================
}
