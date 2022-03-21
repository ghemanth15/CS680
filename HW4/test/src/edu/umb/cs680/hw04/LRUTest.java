package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw04.LRU;

class LRUTest {
	private static LRU cache;
	private static Path path1;
	private static Path path2;
	private static Path path3;
	private static Path path4;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cache = new LRU(3);
		path1 = Paths.get("filesfortesting/file1.txt");
		path2 = Paths.get("filesfortesting/file2.txt");
		path3 = Paths.get("filesfortesting/file3.txt");
		path4 = Paths.get("filesfortesting/file4.txt");
		cache.fetch(path1);
		cache.fetch(path2);
		cache.fetch(path3);
	}

	@Test
	public void fetchwithpath1() throws IOException {
		assertEquals(Files.readString(path1), cache.fetch(path1));
	}
	
	@Test
	public void fetchwithpath2() throws IOException {
		assertEquals(Files.readString(path2), cache.fetch(path2));
	}
	
	@Test
	public void fetchwithpath3() throws IOException {
		assertEquals(Files.readString(path3), cache.fetch(path3));
	}
	
	@Test
	public void fetchwithpath4() throws IOException {
		assertEquals(Files.readString(path4), cache.fetch(path4));
		
	}

}
