package kr.co.vita;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(basePackages = "kr.co.vita")
public class Vita1Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		//SpringApplication.run(BitaApplication.class, args);
		SpringApplication application = new SpringApplication(Vita1Application.class);
		application.run(args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(Vita1Application.class);
	}
}
