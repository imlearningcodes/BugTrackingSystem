package com.ibm.Service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.ibm.Entity.Bug;
import com.ibm.repo.BugRepository;

class BugServiceTest {
	@Test
	void testCreateBug() {
		BugService bugService = new BugService();
		BugRepository dummyRepo = new DummyBugRepository();
		bugService.setBugRepository(dummyRepo);
		Bug bug = new Bug();
		String bugId = bugService.createBug(bug);
		assertNotNull(bugId);
	}

//@Test
//void testGetBugs() {
		//fail("Not yet implemented");
	//}

	//@Test
	//void testGetBug() {
	//	fail("Not yet implemented");
	//}

	//@Test
	//void testUpdateBugStatus() {
		//BugService bugService = new BugService();
		//BugRepository dummyRepo = new DummyBugRepository();
		//bugService.setBugRepository(dummyRepo);
		//Bug bug = new Bug();
		///STATUS status = bugService.updateBugStatus(bug);
		//assertNotNull(status);
		//assertEquals(STATUS.VERIFIED, status);
	//}

}
