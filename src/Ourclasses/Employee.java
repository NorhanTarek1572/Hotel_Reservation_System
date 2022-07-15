package Ourclasses;

import Databases.DbActions;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class Employee {
    
    private String name ;
    private int id ; 
    private  String email ;
    private String address ;
    private String department ;
    private double salary ;
    private String password ;
    private  String mobile ;
   
    //===============================***********==========================================
  
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

     
    
    //=====================================================(**************************)==============================
        public static void Add(int id , String name ,  String email, String department , double salary ){
          // add new employee and make sure that Employee ID Is not Already Exist
            try{
                
                String Query  ="SELECT * FROM `employee` WHERE id ="+id+"";
                ResultSet rs = DbActions.getDate(Query);
                
                if(rs.next())
                {
                   JOptionPane.showMessageDialog(null, "This Employee ID Is Already Exist");
                   
                }
                else{
                    DbActions.setData(" insert into  employee values(  " +id+ " ,'"+name+"'  ,'"+email+"' , '"+department+"' ," +salary+ ") ", "Employee Added Successfully" );
                   
                }
        }
             catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);

                }
            
     
        }
        //*******************************
        public static void Update(int checkedId,int id , String name ,  String email, String department , double salary){
            try {
                String k ="UPDATE employee SET id =" +id+ " ,name ='"+name+"' , email ='"+email+"',department= '"+department+"' ,salary="+salary+"   WHERE id= " +checkedId+"  "; 
              DbActions.setData(k , "Employee updated Successfully" );
              ;
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e);
            }
               /*
          // in case no table 
            try{
             ResultSet rsultSet = null;   
            rsultSet = DbActions.getDate("SELECT * FROM `employee` WHERE id ="+id+" ");
            if (rsultSet.next()){
            DbActions.setData("  UPDATE `employee` SET `id`=" +id+ " ,`name`='"+name+"' ,`email`='"+email+"',`department`= '"+department+"' ,`salary`=" +salary+" WHERE id= " +checkedId+" ", "Employee Added Successfully" );
            }
            else { 
            // cant find it 
              JOptionPane.showMessageDialog(null, "This Employee ID Is not Exist");
            }
                }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
          */  
        }
        //*******************************
        public static void Remove(int id){
 
        try{
              DbActions.setData(" DELETE FROM employee WHERE id = "+id+" ", " Employee Deleted ");
            
      
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        }
        //*******************************
        public static ResultSet Get(){
           // return all valuse in the table 
             ResultSet rs = null;
            try{
                  rs= DbActions.getDate("SELECT * FROM employee WHERE 1");
            
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            return rs;
        
        }
        //***********************************************
        public static ResultSet getselected(int id){
        ResultSet rs = DbActions.getDate("select * from employee where id = " + id+ "");
        return rs;
             }
    //================================================================================================================
        
     
        }

