# ๐ zerobase - assignment1

**"๋ด ์์น ๊ธฐ๋ฐ ๊ณต๊ณต ์์ดํ์ด ์ ๋ณด๋ฅผ ์ ๊ณตํ๋ ์น์๋น์ค ๊ฐ๋ฐ" <br>**
์ ๋ก๋ฒ ์ด์ค ๋ฐฑ์๋ ์ค์ฟจ์ ๊ณผ์ ๋ฅผ ํ ๋๋ก ์งํํ ํ๋ก์ ํธ์๋๋ค.

### [ ํ์ ์ค์ ์ฌํญ ]
1. ๊ณผ์ ๋ฅผ ๋ถ์ํ์ฌ ERD๋ฅผ ํตํ ๋ฐ์ดํฐ ์ค๊ณ๋ฅผ ์์ฑํ์ฌ ์ ์ถํด ์ฃผ์ธ์.
2. ๊ณต๊ณต ์์ดํ์ด ์ ๋ณด๋ ์์ธ์ ์คํAPI๋ฅผ ํ์ฉํด ์ฃผ์ธ์.
3. JAVA๊ธฐ๋ฐ์ ๋ค์ด๋๋ฏน ์น์๋น์ค๋ฅผ ๊ตฌํํด ์ฃผ์ธ์.(JSP)


- **๊ธฐ๋ฅ ์ฌํญ**
	- ๊ณต๊ณต ์์ดํ์ด ์ ๋ณด ๊ฐ์ ธ์ค๊ธฐ ๊ธฐ๋ฅ ๊ตฌํ
	- ๋ด ์์น ์ ๋ณด๋ฅผ ์๋ ฅํ๋ฉด ๊ฐ๊น์ด ์์น์ ์๋ ์์ดํ์ด ์ ๋ณด 20๊ฐ ๋ณด์ฌ์ฃผ๋ ๊ธฐ๋ฅ ๊ตฌํ
	- ๋ด๊ฐ ์๋ ฅํ ์์น์ ๋ณด์ ๋ํด์ ์กฐํํ๋ ์์ ์ DB์ ํ์คํ ๋ฆฌ ์ ์ฅ ๋ฐ ๋ณด์ฌ์ฃผ๋ ๊ธฐ๋ฅ ๊ตฌํ
	- ๋ฐ์ดํฐ๋ฒ ์ด์ค๋ SQLite ์ด์ฉ(SQLite ์ด์ฉํ๊ธฐ๊ฐ ํ๋ค๋ฉด, MySQL or MariaDB ์ด์ฉ)
  


## ๐ฐ๏ธ ๊ฐ๋ฐ ๊ธฐ๊ฐ 
* 22.11.06 - 22.11.08


### โ๏ธ ๊ฐ๋ฐ ํ๊ฒฝ
- `Java 11`
- `JDK 11`
- **IDE** :  Eclipse
- **Database** : SQLite
- **Tools:**  
	- DB Browser for SQLite
	- eXERD

## ๐ ๋ชจ๋ธ๋ง
<img width="1075" alt="erd แแณแแณแแตแซแแฃแบ" src="https://user-images.githubusercontent.com/111635735/201070616-2922f265-37e8-4312-9fd3-7fab692258b1.png">


## ๐ ์ฃผ์ ๊ธฐ๋ฅ
#### 1. ๊ณต๊ณต ์์ดํ์ด ์ ๋ณด ๊ฐ์ ธ์ค๊ธฐ - <a href="https://github.com/junga970/wifi-info/wiki/%F0%9F%93%8C-%EA%B3%B5%EA%B3%B5-%EC%99%80%EC%9D%B4%ED%8C%8C%EC%9D%B4-%EC%A0%95%EB%B3%B4-%EA%B0%80%EC%A0%B8%EC%98%A4%EA%B8%B0" > ์์ธ๋ณด๊ธฐ </a>
 
- OpenAPI ํ์ฑ(Json)
- DB(wifi_info) - ๊ณต๊ณต ์์ดํ์ด ์ ๋ณด ์ ์ฅ

#### 2. ๋ด ์์น ๊ฐ์ ธ์ค๊ธฐ - <a href="https://github.com/junga970/wifi-info/wiki/%F0%9F%93%8C-%EB%82%B4-%EC%9C%84%EC%B9%98-%EA%B0%80%EC%A0%B8%EC%98%A4%EA%B8%B0" > ์์ธ๋ณด๊ธฐ </a> 
- Geolocation API ์ฌ์ฉ

#### 3. ๊ฒ์ํ ์์น์ ๊ฐ๊น์ด ์์ดํ์ด ๋ชฉ๋ก ์กฐํ - <a href="https://github.com/junga970/wifi-info/wiki/%F0%9F%93%8C-%EA%B2%80%EC%83%89%ED%95%9C-%EC%9C%84%EC%B9%98%EC%99%80-%EA%B0%80%EA%B9%8C%EC%9A%B4-%EC%99%80%EC%9D%B4%ED%8C%8C%EC%9D%B4-%EB%AA%A9%EB%A1%9D-%EC%A1%B0%ED%9A%8C" > ์์ธ๋ณด๊ธฐ </a> 
- DB(history) - ๊ฒ์ํ ์์น ์ ๋ณด ์ ์ฅ
- ๋ชจ๋  ๊ณต๊ณต ์์ดํ์ด ์์น์ ๊ฒ์ํ ์์น์ ๊ฑฐ๋ฆฌ ๊ณ์ฐ
- ๊ฐ๊น์ด ์์ผ๋ก ๋ชฉ๋ก ์ถ๋ ฅ(20๊ฐ ์ ํ)

#### 4. ๊ฒ์ํ ์์น์ ๋ํ ํ์คํ ๋ฆฌ ๋ชฉ๋ก ์กฐํ - <a href="https://github.com/junga970/wifi-info/wiki/%F0%9F%93%8C-%EA%B2%80%EC%83%89%ED%95%9C-%EC%9C%84%EC%B9%98%EC%97%90-%EB%8C%80%ED%95%9C-%ED%9E%88%EC%8A%A4%ED%86%A0%EB%A6%AC-%EB%AA%A9%EB%A1%9D-%EC%A1%B0%ED%9A%8C" > ์์ธ๋ณด๊ธฐ </a> 
- DB(history) - ๋ชฉ๋ก ์ถ๋ ฅ



## ๐ ํด๋ ๊ตฌ์กฐ

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