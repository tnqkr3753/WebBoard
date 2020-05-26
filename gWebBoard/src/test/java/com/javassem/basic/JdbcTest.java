package com.javassem.basic;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.sql.Connection;

import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Log4j
public class JdbcTest {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try {
			Connection con = 
			DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.8:1521:orcl", 
					"guest", "1234");
			System.out.println("연결성공");
			log.info("---------연결 성공--------------"+con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
