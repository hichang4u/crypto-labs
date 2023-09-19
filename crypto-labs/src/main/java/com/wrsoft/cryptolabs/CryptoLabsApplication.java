package com.wrsoft.cryptolabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync	// 비동기 기능을 enable 함
@EnableScheduling // 스케줄링 기능을 enable 함
@SpringBootApplication
public class CryptoLabsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoLabsApplication.class, args);
	}

}
