package wifiinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class WifiInfoService {
	public static void dbInsert(WifiInfo wifiInfo) {

		Connection con = null;
		try {
			// SQLite JDBC 체크
			Class.forName("org.sqlite.JDBC");
			
			// SQLite 데이터베이스 파일에 연결
			String dbFile = "/Users/junga/Desktop/SQLite/test.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			
			 
			// SQL 수행
			String sql = " INSERT OR REPLACE INTO wifi_infos ( "
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
}
