package com.keqi.io.binarystream;

import java.io.*;
import java.math.BigDecimal;
import java.util.StringJoiner;
import java.util.UUID;

/**
 * @author keqi
 */
public class CharStreamTest {
	
	public static void main(String[] args) {
		File file = new File("D:/home/2021-05-27/ed863e6c-b49d-491f-bed5-a6da3818cea0.log");
		try {
			for (int i = 0; i < 100000000; i++) {
				write(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(BigDecimal.valueOf(file.length()));
		
		/*String content = null;
		try {
			content = read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(content);*/
	}
	
	private static void write(File file) throws IOException {
		if (!file.isFile() || !file.exists()) {
			throw new RuntimeException("file not exists or this is not a file");
		}
		try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)))) {
			bufferedWriter.write(UUID.randomUUID().toString());
			bufferedWriter.newLine();
		}
	}
	
	private static String read(File file) throws IOException {
		StringJoiner r = new StringJoiner("\n");
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				r.add(line);
			}
		}
		return r.toString();
	}
	
	
}
