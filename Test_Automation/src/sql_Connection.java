import java.sql.*; 
public class sql_Connection {
	 
	// public static void main(String args[])throws ClassNotFoundException, SQLException{
	public static void sqlfunc(String ciname,String SR) throws ClassNotFoundException, SQLException{  

	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://10.8.31.167/patch","root","Root@123");  
	System.out.println("done");
	//here sonoo is database name, root is username and password  
	Statement stmt=con.createStatement(); 
	//String ppp="patch_patch";
	//String ci="MUMMINITCER01";
	//String SR="REQTCL0296940";
	String abcd="\r\n" + 
			"UPDATE\r\n" + 
			"patch_schedule_timeslot pst JOIN patch_customer_ci_details pccd ON pccd.patch_schedule_timeslot_id=pst.id\r\n" + 
			"JOIN auto_patch_ci_details apcd ON apcd.patch_customer_ci_detail_id=pccd.id\r\n" + 
			"SET pst.end_date= DATE_ADD(pst.start_date, INTERVAL 2 HOUR)\r\n" + 
			"WHERE pccd.ci_name='"+ciname+"' AND apcd.sr_id='"+SR+"' ";
	/*
	String abcd="SELECT pccd.patch_schedule_timeslot_id,pd.id,pccd.ci_name FROM patch_details pd  join patch_customer_details pcd ON pd.id =pcd.patch_id\r\n" + 
			"JOIN patch_customer_ci_details pccd ON pcd.id= pccd.patch_to_customer_id  \r\n" + 
			"JOIN patch_schedule_timeslot pst ON pccd.patch_schedule_timeslot_id = pst.id\r\n" + 
			"where pd.patch_name= '"+ppp+"' AND pcd.customer_name LIKE '%CSP Test%' AND pccd.ci_name ='"+ci+"' \r\n" + 
			"";
			*/
	System.out.println(abcd);
	int rs=stmt.executeUpdate(abcd);  
	System.out.println("Query Executed");
	//int rs1=rs.getInt(0) ;
	
	//while(rs.next())  
	//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	con.close();  
	}
}





