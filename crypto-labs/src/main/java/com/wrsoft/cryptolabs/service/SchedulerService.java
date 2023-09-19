package com.wrsoft.cryptolabs.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SchedulerService {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm:ss:SSS");
	
	@Async
	@Scheduled(fixedRate = 3000)
	public void fixedRate() {
	    log.info("fixedRate: 현재시간 - {}", formatter.format(LocalDateTime.now()));
	}
	
	@Async
	@Scheduled(fixedDelay = 1000)
	public void fixedDelay() throws InterruptedException {
	    log.info("시작시간 - {}", formatter.format(LocalDateTime.now()));
	    TimeUnit.SECONDS.sleep(5);
	    log.info("종료시간 - {}", formatter.format(LocalDateTime.now()));
	}
	
	@Async
	@Scheduled(fixedRate = 3000, initialDelay = 5000)
	public void fixedRateAndInitialDelay() {
	    log.info("fixedRateAndInitialDelay: 현재시간 - {}", formatter.format(LocalDateTime.now()));
	}
	
	/*
	 *  1 2 3 4 5 6  // 순서
	 *  * * * * * *  // 실행주기 문자열
	 *  
	 *  // 순서별 정리
	 *	1. 초(0-59)
	 *	2. 분(0-59)
	 *	3. 시간(0-23)
	 *	4. 일(1-31)
	 *	5. 월(1-12)
	 *	6. 요일(0-7)
	 *  "0 0 * * * *" = the top of every hour of every day.
	 *	"* /10 * * * * *" = 매 10초마다 실행한다.
	 *	"0 0 8-10 * * *" = 매일 8, 9, 10시에 실행한다
	 *	"0 0 6,19 * * *" = 매일 오전 6시, 오후 7시에 실행한다.
	 *	"0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30, 10:00 and 10:30 every day.
	 *	"0 0 9-17 * * MON-FRI" = 오전 9시부터 오후 5시까지 주중(월~금)에 실행한다.
	 *	"0 0 0 25 12 ?" = every Christmas Day at midnight
	 *
	 */
	
	@Async
	@Scheduled(cron = "*/3 * * * * *")
	public void cronExpression() {
	    log.info("cronExpression: 현재시간 - {}", formatter.format(LocalDateTime.now()));
	}
}