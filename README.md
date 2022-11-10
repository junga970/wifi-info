# 📋 zerobase - assignment1

**"내 위치 기반 공공 와이파이 정보를 제공하는 웹서비스 개발" <br>**
제로베이스 백엔드 스쿨의 과제를 토대로 진행한 프로젝트입니다.

### [ 필수 준수 사항 ]
1. 과제를 분석하여 ERD를 통한 데이터 설계를 작성하여 제출해 주세요.
2. 공공 와이파이 정보는 서울시 오픈API를 활용해 주세요.
3. JAVA기반의 다이나믹 웹서비스를 구현해 주세요.(JSP)


- **기능 사항**
	- 공공 와이파이 정보 가져오기 기능 구현
	- 내 위치 정보를 입력하면 가까운 위치에 있는 와이파이 정보 20개 보여주는 기능 구현
	- 내가 입력한 위치정보에 대해서 조회하는 시점에 DB에 히스토리 저장 및 보여주는 기능 구현
	- 데이터베이스는 SQLite 이용(SQLite 이용하기가 힘들면, MySQL or MariaDB 이용)
  


## 🕰️ 개발 기간 
* 22.11.06 - 22.11.08


### ⚙️ 개발 환경
- `Java 11`
- `JDK 11`
- **IDE** :  Eclipse
- **Database** : SQLite
- **Tools:**  
	- DB Browser for SQLite
	- eXERD

## 🔍 모델링
<img width="1075" alt="erd 스크린샷" src="https://user-images.githubusercontent.com/111635735/201070616-2922f265-37e8-4312-9fd3-7fab692258b1.png">


## 📌 주요 기능
#### 1. 공공 와이파이 정보 가져오기 
- OpenAPI 파싱(Json)
- DB(wifi_info) - 공공 와이파이 정보 저장

#### 2. 내 위치 가져오기 
- Geolocation API 사용

#### 3. 검색한 위치와 가까운 와이파이 목록 조회 
- DB(history) - 검색한 위치 정보 저장
- 모든 공공 와이파이 위치와 검색한 위치의 거리 계산
- 가까운 순으로 목록 출력(20개 제한)

#### 4. 검색한 위치에 대한 히스토리 목록 조회 
- DB(history) - 목록 출력



## 📁 폴더 구조

```
.
|-- README.md
|-- build
|   `-- classes
|       `-- wifiinfo
|           |-- ApiExplorer.class
|           |-- ApiKey.class
|           |-- Calculation.class
|           |-- History.class
|           |-- WifiInfo.class
|           `-- WifiInfoService.class
|-- erd
|   `-- wifi-info.exerd
`-- src
    `-- main
        |-- java
        |   `-- wifiinfo
        |       |-- ApiExplorer.java
        |       |-- ApiKey.java
        |       |-- Calculation.java
        |       |-- History.java
        |       |-- WifiInfo.java
        |       `-- WifiInfoService.java
        `-- webapp
            |-- META-INF
            |   `-- MANIFEST.MF
            |-- WEB-INF
            |   |-- lib
            |   |   |-- gson-2.9.0.jar
            |   |   |-- lombok.jar
            |   |   `-- sqlite-jdbc-3.36.0.3.jar
            |   `-- web.xml
            |-- history.jsp
            |-- index.jsp
            |-- load-wifi.jsp
            |-- save-history.jsp
            `-- style.css```