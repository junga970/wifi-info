package wifiinfo;

import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class WifiInfo implements Comparable<WifiInfo>{
	String wifiMgrNo;
	String wifiWrdofc;
	String wifiMainNm;
	String wifiAdres1;
	String wifiAdres2;
	String wifiInstlFloor;
	String wifiInstlTy;
	String wifiInstlMby;
	String wifiSvcSe;
	String wifiCmcwr;
	String wifiCnstcYear;
	String wifiInoutDoor;
	String wifiRemars3;
	Double lat;
	Double lnt;
	Double distance;
	String workDttm;

	@Override
	public int compareTo(WifiInfo o) {
		if (this.distance > o.distance) {
			return 1;
		} else if (this.distance < o.distance) {
			return -1;
		} else {
			return 0;
		}
	}
}