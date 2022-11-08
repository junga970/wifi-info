<%@page import="wifiinfo.History"%>
<%@page import="wifiinfo.WifiInfo"%>
<%@page import="wifiinfo.WifiInfoService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>와이파이 정보 구하기</title>
</head>
<body>
	<% 
	  	String lat = request.getParameter("lat");
		String lnt = request.getParameter("lnt"); 
	%>

	<h1> 와이파이 정보 구하기 </h1>
	<a href="http://localhost:8080/wifi-info/"> 홈 </a> | 
	<a href="history.jsp"> 위치 히스토리 목록 </a> | 
	<a href="load-wifi.jsp"> Open API 와이파이 정보 가져오기 </a>
	
	<p>
		<form action="save-history.jsp">
			LAT: <input type="text" id = "lat_id" name="lat" value="<%=lat != null ? lat : "0.0"%>"> , &nbsp; 
			LNT: <input type="text" id = "lnt_id" name="lnt" value="<%=lnt != null ? lnt : "0.0"%>">
			<button type="button" onclick="getLocation()"> 내 위치 가져오기 </button>
			<input type='submit' onclick="getValue()" value="근처 WIFI 정보 보기"/>
		</form>
	</p>
	
	
	<table>
		<thead>
			<tr>
				<th> 거리(Km) </th>
				<th> 관리번호 </th>
				<th> 자치구 </th>
				<th> 와이파이명 </th>
				<th> 도로명주소 </th>
				<th> 상세주소 </th>
				<th> 설치위치(층) </th>
				<th> 설치유형 </th>
				<th> 설치기관 </th>
				<th> 서비스구분 </th>
				<th> 망종류 </th>
				<th> 설치년도 </th>
				<th> 실내외구분 </th>
				<th> WIFI접속환경 </th>
				<th> X좌표 </th>
				<th> Y좌표 </th>
				<th> 작업일자 </th>
			</tr>
		</thead>
		<tbody>
			<%
				if (lat != null && lnt != null) {
					List<WifiInfo> wifiInfoList = WifiInfoService.getWifiInfoList();
					for (WifiInfo wifiInfo : wifiInfoList) {
			%>
						<tr>
							<td>
								<%=String.format("%.4f", wifiInfo.getDistance())%>
							</td>
							<td>
								<%=wifiInfo.getWifiMgrNo()%>
							</td>
							<td>
								<%=wifiInfo.getWifiWrdofc()%>
							</td>
							<td>
								<%=wifiInfo.getWifiMainNm()%>
							</td>
							<td>
								<%=wifiInfo.getWifiAdres1()%>
							</td>
							<td>
								<%=wifiInfo.getWifiAdres2()%>
							</td>
							<td>
								<%=wifiInfo.getWifiInstlFloor()%>
							</td>
							<td>
								<%=wifiInfo.getWifiInstlTy()%>
							</td>
							<td>
								<%=wifiInfo.getWifiInstlMby()%>
							</td>
							<td>
								<%=wifiInfo.getWifiSvcSe()%>
							</td>
							<td>
								<%=wifiInfo.getWifiCmcwr()%>
							</td>
							<td>
								<%=wifiInfo.getWifiCnstcYear()%>
							</td>
							<td>
								<%=wifiInfo.getWifiInoutDoor()%>
							</td>
							<td>
								<%=wifiInfo.getWifiRemars3()%>
							</td>
							<td>
								<%=wifiInfo.getLat()%>
							</td>
							<td>
								<%=wifiInfo.getLnt()%>
							</td>
							<td>
								<%=wifiInfo.getWorkDttm()%>
							</td>
						</tr>
			<%	
					}
				} else {
			%>
					<tr>
						<td id="td_id"colspan="17">
							위치 정보를 입력한 후에 조회해 주세요.
						</td>
					</tr>
			<%	
				}
			%>
		</tbody>
	</table>
	<script>		
		function getLocation() {
		  if (navigator.geolocation) {
		    navigator.geolocation.getCurrentPosition(showPosition);
		  } else { 
		    location.href = "error";
		  }
		}
		
		function showPosition(position) {
			const lat = position.coords.latitude;
			const lnt = position.coords.longitude;
			document.getElementById("lat_id").value = lat;
			document.getElementById("lnt_id").value = lnt;
		}
	</script>	
</body>
</html>