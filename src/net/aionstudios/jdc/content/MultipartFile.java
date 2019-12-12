package net.aionstudios.jdc.content;

import java.io.InputStream;

/**
 * An API for files transmitted in client requests.
 * @author Winter Roberts
 */
public class MultipartFile {
	
	private String fieldName;
	private String fileName;
	private String contentType;
	private InputStream inputStream;
	private long size;
	
	/**
	 * Creates a new Multipart File object to be used by {@link ElementProcessor}s.
	 * @param fieldName The name of the form field that exposed this file upload.
	 * @param fileName The name, from the client, of this file.
	 * @param contentType The content type of this file.
	 * @param inputStream An active input stream which can be used to read this file to active or physical memory.
	 * @param size The size, in bytes, of this file.
	 */
	public MultipartFile(String fieldName, String fileName, String contentType, InputStream inputStream, long size) {
		this.fieldName = fieldName;
		this.fileName = fileName;
		this.contentType = contentType;
		this.inputStream = inputStream;
		this.size = size;
	}

	/**
	 * @return The name of the form field that exposed this file upload.
	 */
	public String getFieldName() {
		return fieldName;
	}
	
	/**
	 * @return The name, from the client, of this file.
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @return The content type of this file.
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @return An active input stream which can be used to read this file to active or physical memory.
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

	/**
	 * @return The size, in bytes, of this file.
	 */
	public long getSize() {
		return size;
	}
	
}
