package utils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * This class is used to achieve database connectivity and stores all db queries
 * and functions this is only single class to have all db related queries
 * 
 * @author Ankit Srivastava
 */
public class Database_Connectivity extends baseClass {

	public static Connection conn;
	public static Statement stmt;

	/**
	 * used to create db connectivity
	 * 
	 * @throws Exception
	 * 
	 */
	public static void aulDBConnect() throws Exception {
		try {
			//// class to access jdbc sql driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//// connection string to connect to aul db
			//qa
			//String url = "jdbc:sqlserver://AUL-DEVDB-01;databaseName=OCEAN_BUILD";
			//qa2
			String url = "jdbc:sqlserver://AUL-DEVDB-01;databaseName=OCEAN_QA2";
			//// create connection
			conn = DriverManager.getConnection(url, "webidentity", "webidentity");
			//// attached session
			stmt = conn.createStatement();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * used to close db
	 * 
	 * @throws Exception
	 * 
	 */
	public static void closeConnection() throws SQLException {
		try {
			//// check if connection is open, close the same
			if (conn != null)
				//// close connection
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

	/**
	 * Convert db data to hashmap and return a hashmap This function will convert
	 * all db data
	 * 
	 * @throws Exception
	 * 
	 */
	public static HashMap<Integer, HashMap<String, String>> returnAllData(ResultSet rs1) throws Exception {
		//// Hash map to store columns and value
		HashMap<Integer, HashMap<String, String>> dbMap = new HashMap<Integer, HashMap<String, String>>();
		try {
			int counter = 1;
			///// rssult set
			ResultSet rs = rs1;
			ResultSetMetaData metaData = rs.getMetaData();
			//// column count
			int count = metaData.getColumnCount();
			/// iterate all rows
			while (rs.next()) {
				HashMap<String, String> mapp = new HashMap<String, String>();
				for (int i = 1; i <= count; i++) {
					//// get column mane
					String col_name = metaData.getColumnName(i);
					//// get column type, like int, string etc
					String columnReturnType = metaData.getColumnTypeName(i);
					//// convert all column type to string and apened to hashmap
					String data = convertData(columnReturnType, rs, i);
					if (data == null)
						mapp.put(col_name.trim(), "");
					else
						mapp.put(col_name.trim(), data.trim());
				}
				dbMap.put(counter, mapp);
				counter++;
			}

		} catch (Exception e) {
			//// exception
			throw e;
		} finally {
			closeConnection();
		}
		/// return map
		return dbMap;
	}

	/**
	 * This function is used to convert db data like int, date etc to string
	 * 
	 */
	public static String convertData(String columnReturnType, ResultSet rs, int i) throws SQLException {
		switch (columnReturnType) {
		case "int":
			return Integer.toString(rs.getInt(i));
		case "nvarchar":
			return rs.getString(i);
		case "string":
			return rs.getString(i);
		case "float":
			return Float.toString(rs.getFloat(i));
		case "bigint":
			return rs.getString(i);
		case "decimal":
			BigDecimal decimalValue = rs.getBigDecimal(i);
			if (decimalValue == null)
				return null;
			return rs.getBigDecimal(i).toString();
		// return df.format(rs.get(i));
		default:
			return rs.getString(i);
		}
	}


}