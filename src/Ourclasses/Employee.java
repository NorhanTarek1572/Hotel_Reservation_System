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
public class Employee {
    
    private String name ;
    private int id ; 
    private  String email ;
    private String address ;
    private String department ;
    private double salary ;
    private String password ;
    private  String mobile ;
    
    final static String pemployee ="D:\\projects\\oop\\Hotel_Reservation_System_v2\\src\\OurFiles\\Employees.txt";
    //==========================
    //=========================================================***********==========================================
  
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static String getPemployee() {
        return pemployee;
    }
      
    
    //=====================================================(**************************)==============================
        public static void Add(int id , String name ,  String email, String department , double salary ){
         
            try{
            FileWriter file = new FileWriter(pemployee, true);
            file.write(id + " " + name + " " + email + " " + department + " " + salary + "\n");
            file.close();
            JOptionPane.showMessageDialog(null, "Employee Added Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }  
        
        }
        //*******************************
        public static void Update(int checkedId,int id , String name ,  String email, String department , double salary){

            ArrayList<String> ourDate = new ArrayList<String>();
            File file = new File(pemployee);
            String info = "";

            try{

                Scanner in = new Scanner(file);
                while (in.hasNext()){
                    ourDate.add(in.nextLine()); // have all data in the file line by line 
                }

                String[] checkedDate = null;           
                for(int i=0;i<ourDate.size();i++)
                {
                    info = ourDate.get(i);
                    checkedDate = info.split("\\s");
                    if(Integer.parseInt(checkedDate[0]) == checkedId)
                        ourDate.set(i,id + " " + name + " " + email + " " + department + " " + salary);
                }

                FileWriter write = new FileWriter(pemployee);
                for(int i=0;i<ourDate.size();i++)    
                    write.write(ourDate.get(i)+"\n");
                write.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
            
        }
        //*******************************
        public static void Remove(int id){
         ArrayList<String> ourDate = new ArrayList<String>();
        File file = new File(pemployee);
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
            
            FileWriter write = new FileWriter(pemployee);
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
            File file = new File(pemployee);
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
    //================================================================================================================
        
        
}
