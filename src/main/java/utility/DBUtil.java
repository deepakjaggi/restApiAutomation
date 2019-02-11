package utility;

public class DBUtil {

//	static String connectionUrl = "jdbc:sqlserver://vipps-at1-sqlsrv01.database.windows.net:1433;database=vipps-at-w2-customer";
//	static Connection con = null;
//	static Statement stmt = null;
//	static ResultSet rs = null;
//
//	static String user = "JDeepak";
//	static String pass = "Vipps@14015";
//
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		try {
//			con = DriverManager.getConnection(connectionUrl, user, pass);
//		} catch (Exception e) {
//			System.out.println("could not connect");
//		}
//		// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//
//				
//		String sql = "select top 1 * from CUSTOMER.TBL_CUSTOMER_OTP_DETAIL order by CREATED_DT desc";
//		stmt = con.createStatement();
//		rs = stmt.executeQuery(sql);
//		
//		while (rs.next()) {
//			System.out.println(rs.getString("MOBILE_NO"));
//		}		
//	}
}
