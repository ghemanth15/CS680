package edu.umb.cs680.hw06;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw06.Directory;
import edu.umb.cs680.hw06.FileSystem;

public class FileSystemTest {

	@Test
	public void getFileSystemReturnNonNullValue() {
		assertNotNull(FileSystem.getFileSystem());
	}

	@Test
	public void getFileSystemReturnIdenticalInstance() {
		FileSystem f1 = FileSystem.getFileSystem();
		FileSystem f2 = FileSystem.getFileSystem();
		assertSame(f1, f2);
	}
	
	@Test
	public void appendRootDirTesting() {
		FileSystem fs = FileSystem.getFileSystem();
		Directory d1 = new Directory(null, "root1", 0, LocalDateTime.now());
		Directory d2 = new Directory(null, "root2", 0, LocalDateTime.now());
		Directory d3 = new Directory(null, "root3", 0, LocalDateTime.now());
		fs.appendRootDir(d1);
		fs.appendRootDir(d2);
		fs.appendRootDir(d3);
		Directory[] expected = new Directory[3];
		expected[0] = d1;
		expected[1] = d2;
		expected[2] = d3;
		Directory[] actual = new Directory[3];
		LinkedList<Directory> rootDirs = fs.getRootDirs();
		actual[0] = rootDirs.get(0);
		actual[1] = rootDirs.get(1);
		actual[2] = rootDirs.get(2);
		assertArrayEquals(expected, actual);
		
	}
	
	

}
