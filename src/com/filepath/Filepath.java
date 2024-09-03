package com.filepath;

import java.io.File;

public class Filepath {

	private int num;
	private String name;
	private File filePath;
	
	

	public Filepath() {
		super();
	}
	

	public Filepath(int num, String name, File filePath) {
		super();
		this.num = num;
		this.name = name;
		this.filePath = filePath;
	}


	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getFilePath() {
		return filePath;
	}

	public void setFilePath(File filePath) {
		this.filePath = filePath;
	}
}
