package green.spring.myWeather;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Mapper 인터페이스가 어디있는지 자동검색하는 위치 지정
@MapperScan(basePackages="green.spring.myWeather.mapper")
@SpringBootApplication
public class MyWeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyWeatherApplication.class, args);
	}

}
