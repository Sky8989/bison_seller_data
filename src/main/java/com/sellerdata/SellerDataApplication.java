package com.sellerdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.ArrayList;
import java.util.List;


@MapperScan("com.sellerdata.mapper.mybatis")
@SpringBootApplication
@EnableEurekaClient
public class SellerDataApplication {

	public static void main(String[] args) {
		try{
			SpringApplication.run(SellerDataApplication.class, args);
		}catch(Exception error){
			System.err.println("启动报错"+ error);
		}

		/*List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);


		for (Integer i1 : list1){
			3

			for (Integer i2 : list2){
				if(i1 == i2){ 3 == 1 2
					System.out.print("1 \t");
				}
			}


			System.out.print("未授权 \t");

		}*/


	}

	//为了打包springboot项目
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}


}
