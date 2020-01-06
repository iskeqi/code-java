package com.keqi.springbootrestserver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private Integer id;
	private String name;
	private Double price;

}

