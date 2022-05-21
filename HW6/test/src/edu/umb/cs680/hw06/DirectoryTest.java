package edu.umb.cs680.hw06;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw06.Directory;
import edu.umb.cs680.hw06.File;

public class DirectoryTest {
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
		f1 = new File(apps, "f1", 10, LocalDateTime.now());
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

	private String[] dirToStringArray(Directory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getName(), String.valueOf(d.getTotalSize()),
				String.valueOf(d.getCreationTime()), String.valueOf(d.countChildren()) };
		return dirInfo;
	}

	@Test
	public void verifyDirEqualityRoot() {
		String[] expected = { "true", "root", "150", String.valueOf(root.getCreationTime()), "3" };
		Directory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void verifyDirEqualityHome() {
		String[] expected = { "true", "home", "120", String.valueOf(home.getCreationTime()), "2" };
		Directory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void isDirTestingWithRoot() {
		assertTrue(root.isDirectory());
	}
	
	@Test
	public void appendChildrenWithRoot() {
		assertSame(root, apps.getParent());
	}
	
	@Test
	public void appendChildrenWithHome() {
		assertSame(home, c.getParent());
	}
	
	@Test
	public void countChildrenWithRoot() {
		assertEquals(3, root.countChildren());;
	}
	
	@Test
	public void countChildrenWithHome() {
		assertSame(2, home.countChildren());
	}
	
	@Test
	public void getSubDirTestingWithRoot() {
		Directory[] expected = new Directory[3];
		expected[0] = apps;
		expected[1] = bin;
		expected[2] = home;
		Directory[] actual = new Directory[3];
		LinkedList<Directory> subDirectories = root.getSubDirectories();
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getSubDirTestingWithHome() {
		assertSame(pictures, home.getSubDirectories().get(0));
	}
	
	@Test
	public void getFilesTestingWithHome() {
		assertSame(f5, home.getFiles().get(0));
	}
	
	@Test
	public void getFilesTestingWithPictures() {
		File[] expected = new File[2];
		expected[0] = f3;
		expected[1] = f4;
		File[] actual = new File[2];
		LinkedList<File> files = pictures.getFiles();
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getTotalSizeTestingWithRoot() {
		assertEquals(150, root.getTotalSize());
	}
	
	@Test
	public void getTotalSizeTestingWithHome() {
		assertEquals(120, home.getTotalSize());
	}

}
