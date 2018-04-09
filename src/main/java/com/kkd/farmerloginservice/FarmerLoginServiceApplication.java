package com.kkd.farmerloginservice;

import java.io.IOException;

import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
//@EnableSwagger2
@EnableFeignClients("com.kkd.farmerloginservice")
@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
public class FarmerLoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmerLoginServiceApplication.class, args);
	}
	/*
	//for sleuth to generate id
	@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}
	
	//For swagger to document the Service
			@Bean
			public Docket api() throws IOException, XmlPullParserException {
				return new Docket(DocumentationType.SWAGGER_2);
	}*/
}
