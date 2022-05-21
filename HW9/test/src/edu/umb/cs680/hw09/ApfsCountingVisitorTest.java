package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;
import edu.umb.cs680.hw09.apfs.util.ApfsCountingVisitor;

public class ApfsCountingVisitorTest {
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
	private static ApfsCountingVisitor rootVisitor;
	private static ApfsCountingVisitor homeVisitor;

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
		rootVisitor = new ApfsCountingVisitor();
		homeVisitor = new ApfsCountingVisitor();
		root.accept(rootVisitor);
		home.accept(homeVisitor);
	}

	@Test
	public void verifyDirNumberRoot() {
		int expected = 5;
		int actual = rootVisitor.getDirNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void verifyFileNumberRoot() {
		int expected = 5;
		int actual = rootVisitor.getFileNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void verifyLinkNumberRoot() {
		int expected = 2;
		int actual = rootVisitor.getLinkNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void verifyDirNumberHome() {
		int expected = 2;
		int actual = homeVisitor.getDirNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void verifyFileNumberHome() {
		int expected = 3;
		int actual = homeVisitor.getFileNum();
		assertEquals(expected, actual);
	}
	
	@Test
	public void verifyLinkNumberHome() {
		int expected = 2;
		int actual = homeVisitor.getLinkNum();
		assertEquals(expected, actual);
	}

}

