package com.keqi.io.binarystream;

import java.io.*;

/**
 * @author keqi
 */
public class FileUtil {
	
	public static void writeByteArrayToFile(File file, byte[] data) throws IOException {
		writeByteArrayToFile(file, data, false);
	}
	
	public static void writeByteArrayToFile(File file, byte[] data, boolean append) throws IOException {
		try (OutputStream out = openOutputStream(file, append)) {
			out.write(data);
		}
	}
	
	public static byte[] readFileToByteArray(File file) throws IOException {
		try (InputStream in = openInputStream(file)) {
			return toByteArray(in, (int) file.length());
		}
	}
	
	private static BufferedOutputStream openOutputStream(File file, boolean append) throws IOException {
		if (file.exists()) {
			if (file.isDirectory()) {
				throw new IOException("File '" + file + "' exists but is a directory");
			}
			if (!file.canWrite()) {
				throw new IOException("File '" + file + "' cannot be written to");
			}
		} else {
			File parent = file.getParentFile();
			if (parent != null) {
				if (!parent.mkdirs() && !parent.isDirectory()) {
					throw new IOException("Directory '" + parent + "' could not be created");
				}
			}
		}
		return new BufferedOutputStream(new FileOutputStream(file, append));
	}
	
	private static BufferedInputStream openInputStream(File file) throws IOException {
		if (file.exists()) {
			if (file.isDirectory()) {
				throw new IOException("File '" + file + "' exists but is a directory");
			}
			if (!file.canRead()) {
				throw new IOException("File '" + file + "' cannot be read");
			}
		} else {
			throw new FileNotFoundException("File '" + file + "' does not exist");
		}
		return new BufferedInputStream(new FileInputStream(file));
	}
	
	private static byte[] toByteArray(InputStream input, int size) throws IOException {
		if (size < 0) {
			throw new IllegalArgumentException("Size must be equal or greater than zero: " + size);
		}
		
		if (size == 0) {
			return new byte[0];
		}
		
		byte[] data = new byte[size];
		int offset = 0;
		int readed;
		
		while (offset < size && (readed = input.read(data, offset, size - offset)) != -1) {
			offset += readed;
		}
		
		if (offset != size) {
			throw new IOException("Unexpected readed size. current: " + offset + ", excepted: " + size);
		}
		
		return data;
	}
}
