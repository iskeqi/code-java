package com.keqi.hutool.core.common;

import lombok.Data;

import java.util.List;

@Data
public class User {

	private String username;

	private List<Role> roleList;

}
