package com.keqi.fastjson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

	private String name;

	private LocalDate startTime;

	private LocalDate endTime;

}
