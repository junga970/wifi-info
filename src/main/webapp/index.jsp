<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
</head>
<body>
	<% 
	String s1 = request.getParameter("lat") != null ? request.getParameter("lat") : "";
	String s2 = request.getParameter("lnt") != null ? request.getParameter("lnt") : "";
	System.out.println(s1 + " " + s2);
	%>

	<h1> 와이파이 정보 구하기 </h1>
	<a href="http://localhost:8080/wifi-info/"> 홈 </a> | 
	<a href="history.jsp"> 위치 히스토리 목록 </a> | 
	<a href="load-wifi.jsp"> Open API 와이파이 정보 가져오기 </a>
	<form>
		LAT: <input type="text" name="lat" value="<%=s1%>" placeholder="0.0"> , &nbsp; 
		LNT: <input type="text" name="lnt" value="<%=s2%>" placeholder="0.0">
		<button type="button" onclick="getLocation()"> 내 위치 가져오기 </button>
		<input type='submit' value="근처 WIFI 정보 보기"/>
	</form>
	
	
	<table border = "1">
		<thead>
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
		</thead>
		<tbody>
			<tr> 
				<td colspan="17">
					위치 정보를 입력한 후에 조회해 주세요.
				</td>
			</tr>
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
			location.href = "?lat=" + lat + "&lnt=" + lnt;
		}
</script>
	
</body>
</html>