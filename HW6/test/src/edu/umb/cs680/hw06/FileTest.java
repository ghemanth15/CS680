package edu.umb.cs680.hw06;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw06.Directory;
import edu.umb.cs680.hw06.File;

public class FileTest {
	private static Directory root;
	private static Directory apps;
	private static Directory bin;
	private static Directory home;
	private static Directory pictures;
	private static File f1;
	private static File f2;
	private static File f3;
	private static File f4;
	private static File f5;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new Directory(null, "root", 0, LocalDateTime.now());
		apps = new Directory(root, "apps", 0, LocalDateTime.now());
		bin = new Directory(root, "bin", 0, LocalDateTime.now());
		home = new Directory(root, "home", 0, LocalDateTime.now());
		pictures = new Directory(home, "pictures", 0, LocalDateTime.now());
		f1 = new File(apps, "f2", 10, LocalDateTime.now());
		f2 = new File(bin, "f2", 20, LocalDateTime.now());
		f3 = new File(pictures, "f3", 30, LocalDateTime.now());
		f4 = new File(pictures, "f4", 40, LocalDateTime.now());
		f5 = new File(home, "f5", 50, LocalDateTime.now());
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(f1);
		apps.appendChild(f2);
		home.appendChild(pictures);
		home.appendChild(f5);
		pictures.appendChild(f3);
		pictures.appendChild(f4);
	}
	
	private String[] fileToStringArray(File f) {
		String[] fi = { String.valueOf(f.isDirectory()), f.getName(), String.valueOf(f.getSize()),
				String.valueOf(f.getCreationTime()), f.getParent().getName() };
		return fi;
	}

	@Test
	public void verifyFileEquality_f1() {
		String[] expected = { "false", "f1", "10", String.valueOf(x.getCreationTime()), "apps" };
		File actual = f1;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void verifyFileEquality_f3() {
		String[] expected = { "false", "f3", "30", String.valueOf(a.getCreationTime()), "pictures" };
		File actual = f3;
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void isDirTestingWithf4() {
		assertFalse(f4.isDirectory());
	}

}
