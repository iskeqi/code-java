package com.keqi.hutool.core;

import lombok.Data;

import java.util.List;

@Data
public class Role {

	private String roleName;

	private List<Premiss> premissList;
}
