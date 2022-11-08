package wifiinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WifiInfoService {
	public static void dbInsert(WifiInfo wifiInfo) {

		Connection con = null;
		try {
			// SQLite JDBC 체크
			Class.forName("org.sqlite.JDBC");
			
			// SQLite 데이터베이스 파일에 연결
			String dbFile = "/Users/junga/Desktop/SQLite/wifi_service.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			
			 
			// SQL 수행
			String sql = " INSERT OR REPLACE INTO wifi_info ( "
					+ " wifi_mgr_no, wifi_wrdofc, wifi_main_nm, wifi_adres1, wifi_adres2, "
					+ " wifi_instl_floor, wifi_instl_ty, wifi_instl_mby, wifi_svc_se, wifi_cmcwr, "
					+ " wifi_cnstc_year, wifi_inout_door, wifi_remars3, lat, lnt, work_dttm "
					+ " ) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";
			
			PreparedStatement preparedStatement  = con.prepareStatement(sql);
			preparedStatement.setString(1, wifiInfo.getWifiMgrNo());
            preparedStatement.setString(2, wifiInfo.getWifiWrdofc());
            preparedStatement.setString(3, wifiInfo.getWifiMainNm());
            preparedStatement.setString(4, wifiInfo.getWifiAdres1());
            preparedStatement.setString(5, wifiInfo.getWifiAdres2());
            preparedStatement.setString(6, wifiInfo.getWifiInstlFloor());
            preparedStatement.setString(7, wifiInfo.getWifiInstlTy());
            preparedStatement.setString(8, wifiInfo.getWifiInstlMby());
            preparedStatement.setString(9, wifiInfo.getWifiSvcSe());
            preparedStatement.setString(10, wifiInfo.getWifiCmcwr());
            preparedStatement.setString(11, wifiInfo.getWifiCnstcYear());
            preparedStatement.setString(12, wifiInfo.getWifiInoutDoor());
            preparedStatement.setString(13, wifiInfo.getWifiRemars3());
            preparedStatement.setString(14, wifiInfo.getLat().toString());
            preparedStatement.setString(15, wifiInfo.getLnt().toString());
            preparedStatement.setString(16, wifiInfo.getWorkDttm());
           
            
            preparedStatement.executeUpdate();

            
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {con.close();}catch(Exception e) {}
			}
		}
	}

	public static void dbHistoryInsert(History history) {

		Connection con = null;
		try {
			// SQLite JDBC 체크
			Class.forName("org.sqlite.JDBC");
			
			// SQLite 데이터베이스 파일에 연결
			String dbFile = "/Users/junga/Desktop/SQLite/wifi_service.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

			 
			// SQL 수행
			String sql = " INSERT INTO history (lat, lnt, date) "
					+ " VALUES (?, ?, ?); ";
			
			PreparedStatement preparedStatement  = con.prepareStatement(sql);
			preparedStatement.setString(1, history.getLat().toString());
            preparedStatement.setString(2, history.getLnt().toString());
            preparedStatement.setString(3, history.getDate());
            
            preparedStatement.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {con.close();}catch(Exception e) {}
			}
		}
	}
	
	public static List<History> getHistoryList() {

		Connection con = null;
		
		List<History> historyList = new ArrayList<>();

		try {
			// SQLite JDBC 체크
			Class.forName("org.sqlite.JDBC");
			
			// SQLite 데이터베이스 파일에 연결
			String dbFile = "/Users/junga/Desktop/SQLite/wifi_service.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			
			// SQL 수행
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM history ORDER BY id DESC");
			while(rs.next()) {
				int id = rs.getInt("id");
				Double lat = rs.getDouble("lat");
				Double lnt = rs.getDouble("lnt");
				String date = rs.getString("date");
				
				History history = new History();
				history.setId(id);
				history.setLat(lat);
				history.setLnt(lnt);
				history.setDate(date);
				
				historyList.add(history);
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {con.close();}catch(Exception e) {}
			}
		}
		return historyList;
	}
	
	public static List<WifiInfo> getWifiInfoList() {
		final int LIMIT = 20;
		
		Connection con = null;
		
		List<WifiInfo> wifiInfoList = new ArrayList<>();

		try {
			// SQLite JDBC 체크
			Class.forName("org.sqlite.JDBC");
			
			// SQLite 데이터베이스 파일에 연결
			String dbFile = "/Users/junga/Desktop/SQLite/wifi_service.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			
			// SQL 수행
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM wifi_info,  "
					+ " (SELECT id, lat as my_lat, lnt as my_lnt  FROM history ORDER BY id DESC LIMIT 1);");
			
			while(rs.next()) {
				String wifiMgrNo = rs.getString("wifi_mgr_no");
				String wifiWrdofc = rs.getString("wifi_wrdofc");
				String wifiMainNm = rs.getString("wifi_main_nm");
				String wifiAdres1 = rs.getString("wifi_adres1");
				String wifiAdres2 = rs.getString("wifi_adres2");
				String wifiInstlFloor = rs.getString("wifi_instl_floor");
				String wifiInstlTy = rs.getString("wifi_instl_ty");
				String wifiInstlMby = rs.getString("wifi_instl_mby");
				String wifiSvcSe = rs.getString("wifi_svc_se");
				String wifiCmcwr = rs.getString("wifi_cmcwr");
				String wifiCnstcYear = rs.getString("wifi_cnstc_year");
				String wifiInoutDoor = rs.getString("wifi_inout_door");
				String wifiRemars3 = rs.getString("wifi_remars3");
				Double lat = rs.getDouble("lat");
				Double lnt = rs.getDouble("lnt");
				String workDttm = rs.getString("work_dttm");
				
				Double myLat = rs.getDouble("my_lat");
				Double myLnt = rs.getDouble("my_lnt");	
				Double distance = Calculation.getDistance(lat, lnt, myLat, myLnt);
				
				WifiInfo wifiInfo = new WifiInfo();
				
				wifiInfo.setWifiMgrNo(wifiMgrNo);
				wifiInfo.setWifiWrdofc(wifiWrdofc);
				wifiInfo.setWifiMainNm(wifiMainNm);
				wifiInfo.setWifiAdres1(wifiAdres1);
				wifiInfo.setWifiAdres2(wifiAdres2);
				wifiInfo.setWifiInstlFloor(wifiInstlFloor);
				wifiInfo.setWifiInstlTy(wifiInstlTy);
				wifiInfo.setWifiInstlMby(wifiInstlMby);
				wifiInfo.setWifiSvcSe(wifiSvcSe);
				wifiInfo.setWifiCmcwr(wifiCmcwr);
				wifiInfo.setWifiCnstcYear(wifiCnstcYear);
				wifiInfo.setWifiInoutDoor(wifiInoutDoor);
				wifiInfo.setWifiRemars3(wifiRemars3);
				wifiInfo.setLat(lat);
				wifiInfo.setLnt(lnt);
				wifiInfo.setWorkDttm(workDttm);
				wifiInfo.setDistance(distance);
				
				wifiInfoList.add(wifiInfo);		
			}	
			
			Collections.sort(wifiInfoList);
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {con.close();}catch(Exception e) {}
			}
		}
		return wifiInfoList.subList(0, LIMIT);
	}
	
}
