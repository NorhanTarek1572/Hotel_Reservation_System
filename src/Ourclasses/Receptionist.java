package Ourclasses;
import Databases.DbActions;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Receptionist {
    
    private String email ;
    private String password ;
    private String name ;
    private String address ;
    //====================**************=============================
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

    //*******************************************************************************************
     public static void Add(String name, String email, String password, String Address){ //For Receptionist
        try{
            
        String Query = "insert into receptionist values(' "+name+" ','"+email+"','"+password+"','"+Address+"')";
            DbActions.setData(Query, "Done");
            
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }
     //*******************************************************************************************
     public static boolean login(String email, String password){
     try{
            String Query = "SELECT * FROM  receptionist WHERE email='"+email+"' and  password= '"+password+ "' ";
            ResultSet rs = DbActions.getDate(Query);
            if(rs.next())
            {
                return true;
            }
            else
                return false;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    //*******************************************************************************************
}
