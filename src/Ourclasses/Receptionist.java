
package Ourclasses;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Receptionist {
    
    private String email ;
    private String password ;
    private String name ;
    private String address ;
    final static String  preception ="D:\\projects\\oop\\Hotel_Reservation_System_v2\\src\\OurFiles\\Receptionist.txt";
    //****************************************************************

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static String getPreception() {
        return preception;
    }
    
    
    //******************************************************************
     public static void Add(String name, String email, String password, String Address){ //For Receptionist
        try{
            FileWriter file = new FileWriter(preception, true);
            file.write(name + " " + email + " " + password + " " + Address + "\n");
            file.close();
            JOptionPane.showMessageDialog(null, "User Added Successfully, Now You Can Login");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
     
     public static String[] Get(){
        ArrayList<String> data = new ArrayList<String>();
        String[] info = null;
        File file = new File(preception);
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
     
     public  void checke_register() {
     //Make sure that there is no such email    
    }
}
