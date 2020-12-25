package com.keqi;

import java.awt.*;

public class main {
	public static void main(String[] args) {
		String[] availableFontFamilyNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for (String t : availableFontFamilyNames) {
			System.out.println(t);
		}
	}
}
