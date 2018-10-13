
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginValidate
{
        
     public static boolean checkUser(String uname,String passw)
     {
        boolean b=false;
        
        try
        {
        String url="jdbc:mysql://localhost:3306/university?useSSL=false";
        String uname1="root";
        String pass1="sigma@321";
        String query="select * from Login where Username=? and Password=?";
        System.out.print("outside");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con=DriverManager.getConnection(url,uname1,pass1);
        PreparedStatement st=con.prepareStatement(query);
        st.setString(1,uname);
        st.setString(2,passw);
        
        ResultSet rs= st.executeQuery();
      
        b=rs.next();
      
       // b=rs.next();
        /*
        while(rs.next())
        {
          String user=rs.getString(1);
          String pa=rs.getString(2);
                  
          if(user.equals(uname) && pa.equals(pass))
          {
           response.getWriter().println("Successful !");
          }
          else
          {
           response.getWriter().println("Invalid login credentials !");
          }
           
       }
       */
        }
        catch(Exception e)
        {
            
           
            System.out.println("\n*****See here!!Excepton occured in login validate page");
        }
      return b; 
     }
}
