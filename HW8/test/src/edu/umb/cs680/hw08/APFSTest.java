package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.APFS;
import edu.umb.cs680.hw08.ApfsDirectory;
import edu.umb.cs680.hw08.FSElement;

public class APFSTest {

	@Test
	public void getFileSystemReturnNonNullValue() {
		assertNotNull(APFS.getApfs());
	}

	@Test
	public void getFileSystemReturnIdenticalInstance() {
		APFS apfs1 = APFS.getApfs();
		APFS apfs2 = APFS.getApfs();
		assertSame(apfs1, apfs2);
	}
	
	@Test
	public void initMethodAndGetRootDirTesting() {
		APFS apfs = APFS.getApfs();
		FSElement expected = apfs.init("apfs", 1000);
		ApfsDirectory actual = apfs.getRootDir();
		assertSame(expected, actual);
	}

}
