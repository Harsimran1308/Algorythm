
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Harsimran singh
 */
public class database {
    
      Connection con=null;
      Statement stmt=null;
      ResultSet rs;
   database()
   {
       try
       {
           
       
       Class.forName("com.mysql.jdbc.Driver");
       String url="jdbc:mysql://172.31.1.60:3306/algorythm";
       con=DriverManager.getConnection(url,"username","password");
       stmt=con.createStatement();
       
       
       }
       
       
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
       
     
       
   }
    
    
      public synchronized void  update(String qry)throws Exception 
       {
           
           stmt.executeUpdate(qry);
           
           
       }
      
      public synchronized ResultSet execute(String qry)throws Exception
      {
          rs= stmt.executeQuery(qry);
          
          return rs;
          
      }
      
      
      
     
public void connectionclosing()
{
    try
    {
        
        con.close();
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e);
    }
}
    
    
    
}


