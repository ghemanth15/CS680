package edu.umb.cs680.hw08;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.ApfsDirectory;
import edu.umb.cs680.hw08.ApfsFile;
import edu.umb.cs680.hw08.ApfsLink;

public class ApfsDirectoryTest {
	private static ApfsDirectory root;
	private static ApfsDirectory apps;
	private static ApfsDirectory bin;
	private static ApfsDirectory home;
	private static ApfsDirectory pictures;
	private static ApfsFile f1;
	private static ApfsFile f2;
	private static ApfsFile f3;
	private static ApfsFile f4;
	private static ApfsFile f5;
	private static ApfsLink f6;
	private static ApfsLink f7;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new ApfsDirectory(null, "root", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		apps = new ApfsDirectory(root, "apps", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		bin = new ApfsDirectory(root, "bin", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		home = new ApfsDirectory(root, "home", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		pictures = new ApfsDirectory(home, "pictures", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		f1 = new ApfsFile(apps, "f1", 10, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		f2 = new ApfsFile(bin, "f2", 20, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		f3 = new ApfsFile(pictures, "f3", 30, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		f4 = new ApfsFile(pictures, "f4", 40, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		f5 = new ApfsFile(home, "f5", 50, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		f6 = new ApfsLink(home, "f6", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime", bin);
		f7 = new ApfsLink(pictures, "f7", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime", f2);
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(f1);
		apps.appendChild(f2);
		home.appendChild(pictures);
		home.appendChild(f5);
		home.appendChild(f6);
		pictures.appendChild(f3);
		pictures.appendChild(f4);
		pictures.appendChild(f7);
	}

	private String[] dirToStringArray(ApfsDirectory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getOwnerName(), String.valueOf(d.getTotalSize()),
							d.getLastModifiedTime(), String.valueOf(d.countChildren()) };
		return dirInfo;
	}

	@Test
	public void verifyDirectoryEqualityRoot() {
		String[] expected = { "true", "defaultOwnerName", "150", "defaultLastModifiedTime", "3" };
		ApfsDirectory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void verifyDirectoryEqualityHome() {
		String[] expected = { "true", "defaultOwnerName", "120", "defaultLastModifiedTime", "3" };
		ApfsDirectory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void isDirectoyTestingWithRoot() {
		assertTrue(root.isDirectory());
	}
	
	@Test
	public void isFileTestingWithRoot() {
		assertFalse(root.isFile());
	}
	
	@Test
	public void isLinkTestingWithRoot() {
		assertFalse(root.isLink());
	}
	
	@Test
	public void appendChildrenTestingWithRoot() {
		assertSame(root, apps.getParent());
	}
	
	@Test
	public void appendChildrenTestingWithHome() {
		assertSame(home, f5.getParent());
	}
	
	@Test
	public void countChildrenTestingWithRoot() {
		assertEquals(3, root.countChildren());;
	}
	
	@Test
	public void countChildrenTestingWithHome() {
		assertSame(3, home.countChildren());
	}
	
	@Test
	public void getSubDirectoriesTestingWithRoot() {
		ApfsDirectory[] expected = new ApfsDirectory[3];
		expected[0] = apps;
		expected[1] = bin;
		expected[2] = home;
		ApfsDirectory[] actual = new ApfsDirectory[3];
		LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories();
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getSubDirectoriesTestingWithHome() {
		assertSame(pictures, home.getSubDirectories().get(0));
	}
	
	@Test
	public void getFilesTestingWithHome() {
		assertSame(f5, home.getFiles().get(0));
	}
	
	@Test
	public void getFilesTestingWithPictures() {
		ApfsFile[] expected = new ApfsFile[2];
		expected[0] = f3;
		expected[1] = f4;
		ApfsFile[] actual = new ApfsFile[2];
		LinkedList<ApfsFile> files = pictures.getFiles();
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getLinksTestingWithHome() {
		assertSame(f6, home.getLinks().get(0));
	}
	
	@Test
	public void getLinksTestingWithPictures() {
		assertSame(n, pictures.getLinks().get(0));
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
