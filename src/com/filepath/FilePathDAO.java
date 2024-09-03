package com.filepath;

import java.util.List;

public interface FilePathDAO {

void insertFilePath(Filepath filePath);
	
	List<Filepath> findAllData();
}
