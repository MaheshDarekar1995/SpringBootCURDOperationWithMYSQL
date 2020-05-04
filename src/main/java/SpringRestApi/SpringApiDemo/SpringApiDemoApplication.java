package SpringRestApi.SpringApiDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"SpringRestApi.SpringApiDemo"})
public class SpringApiDemoApplication {

	
	  public static void main(String[] args) {		
	  SpringApplication.run(SpringApiDemoApplication.class, args); }
	 

}
