package com.keqi.io.binarystream;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author keqi
 */
public class commonsioTest {
	public static void main(String[] args) throws IOException {
		FileUtils.touch(new File("D:/home/2021-05-28/" + UUID.randomUUID() + ".log"));
	}
}
