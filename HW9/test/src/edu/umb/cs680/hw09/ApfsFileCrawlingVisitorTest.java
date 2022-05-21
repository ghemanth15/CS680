package edu.umb.cs680.hw09;

import static org.junit.Assert.assertArrayEquals;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;
import edu.umb.cs680.hw09.apfs.util.ApfsFileCrawlingVisitor;

public class ApfsFileCrawlingVisitorTest {
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

	@Test
	public void verifyFilesInRoot() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		root.accept(visitor);
		LinkedList<ApfsFile> actual = visitor.getFiles();
		LinkedList<ApfsFile> expected = new LinkedList<>();
		expected.add(f1);
		expected.add(f2);
		expected.add(f3);
		expected.add(f4);
		expected.add(f5);
		assertArrayEquals(expected.toArray(), actual.toArray());
	}
	
	@Test
	public void verifyFilesInHome() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		home.accept(visitor);
		LinkedList<ApfsFile> actual = visitor.getFiles();
		LinkedList<ApfsFile> expected = new LinkedList<>();
		expected.add(f3);
		expected.add(f4);
		expected.add(f5);
		assertArrayEquals(expected.toArray(), actual.toArray());
	}

}
