package green.spring.myWeather.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherController {
	
	// http://localhost/getWeather
	// 공공데이터에서 날씨정보를 우리서버로 가져와서 요청한 웹클라이언트 중계를 해준다.
	@GetMapping("/getWeather")
	@ResponseBody
	public String getWeather() throws Exception{
		// 1. 공공데이터 서비스주소 url 설정
		// 기상청_관광코스별 관광지 상세 날씨 조회서비스 중에서
		// 세번째 동네예보조회를 할 수 있는 API
		String apiUrl = "https://apis.data.go.kr/1360000/TourStnInfoService/getTourStnVilageFcst"; /*URL*/
		
		// 2. 요청변수(Request Parameter)설정
		// serviceKey : 이 서비스를 이용할 수 있는 사용자 인증정보 // 일반 인증키
		// pageNo : 페이지 번호
		// numOfR : 한 페이지에서 볼 수 있는 결과 수
		// dataType : JSON / XML => JSON  사용
		// CURRENT_DATE : 검사하고 싶은 날짜
		// HOUR : 현재날짜로 부터 다음 시간 24시간
		// COURSE_ID : 관광코스 ID(일련번호)
		String serviceKey = "44NAeIDcjoeZ1Ou87oa2HJ56YDU8wovL%2FlSJmuQ6BK21%2BQT4EuSyELhhn8ZANfMa%2FP94vbifY0fTtO9Rh%2BjAOA%3D%3D";
		String pageNo = "1";
		String numOfRows = "10";
		String dataType = "JSON";
		String CURRENT_DATE = "20220717";
		String HOUR = "24";
		String COURSE_ID = "1";
		
		StringBuilder urlBuilder = new StringBuilder(apiUrl);
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey);
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode(dataType, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("CURRENT_DATE","UTF-8") + "=" + URLEncoder.encode(CURRENT_DATE, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("HOUR","UTF-8") + "=" + URLEncoder.encode(HOUR, "UTF-8"));
        
        urlBuilder.append("&" + URLEncoder.encode("COURSE_ID","UTF-8") + "=" + URLEncoder.encode(COURSE_ID, "UTF-8"));
		
		// GET 방식으로 공공데이터 API서버에 요청해야한다.
        // 바로 텍스트 웹브라우저를 만들어야 한다.
        // 텍스트 웹브라우저는 = URLBuilder 문자열을 이용해 URL주소 만들기 + 등록돤 URL을 이용하여 네트워크 연결하기
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        
        // 데이터를 보내고 받기 (IO=Input and Output) 만들기
        // 자바는 모든 데이터를 한 바이트씩 연속적으로 보낸다. 이것을 스트림이라고 한다.
        // 이렇게 보내면 연결되어 있어 보내는 데이터를 관리하기는 좋지만 느리다.
        // 그것을 극복하기 위해 묶음배송을 생각 해 놓았다.
        // 버퍼라는 임시창고에 모아서 한꺼번에 처리배송한다.
        BufferedReader rd;
		// 일단 데이터를 처리하기 전에 공공데이터포털 서버가 정상적으로 작동하는지 확인할 필요가 있다.
        // 정상이라면 200응답코드를 돌려줄 것이다.
        if((conn.getResponseCode() >=200) &&
        		conn.getResponseCode() <= 300){
        	rd = new BufferedReader(
        			new InputStreamReader(
        				conn.getInputStream()));
        } else {
        	rd = new BufferedReader(
        			new InputStreamReader(
        					conn.getErrorStream()));
        }
        
        //실제 HTML(=JSON 또는 XML) 데이터를 저장할 문자열빌더를 준비
        StringBuilder sb = new StringBuilder();
        String line; //한줄씩 네트워크로 부터 읽어오기 위해 임시문자열 준비
        
        while ((line = rd.readLine()) != null) {
            sb.append(line);
            // 네트워크로부터 데이터를 읽어 올때마다 sb에 읽은 문자열을 추가한다.
        }
        rd.close();
        conn.disconnect();
        String result= sb.toString();
        System.out.println(result);

       return result;
		
	}

}
