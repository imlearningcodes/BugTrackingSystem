package com.ibm.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.Entity.Bug;
import com.ibm.Entity.STATUS;
import com.ibm.repo.BugRepository;

@Service
public class BugService {
	@Autowired
	BugRepository bugRepository;

	public BugRepository getBugRepository() {
		return bugRepository;
	}

	public void setBugRepository(BugRepository bugRepository) {
		this.bugRepository = bugRepository;
	}

	public String createBug(Bug bug) {
		Bug savedBug = bugRepository.save(bug);
		return savedBug.getId();
	}

	public List<Bug> getBugs() {
		return bugRepository.findAll();
	}

	public Optional<Bug> getBug(String id) {
		return bugRepository.findById(id);
	}
	
	public Optional<Bug> getBugByName(String bugName) {
		return bugRepository.findByName(bugName);
	}

	public void updateBug(@Valid Bug bug) {
		STATUS status=bug.getStatus();
		Optional <Bug> oldBug=bugRepository.findById(bug.getId());
		oldBug.ifPresent(oldbug->{
			STATUS oldstatus=oldbug.getStatus();
			if(oldstatus==STATUS.NEW) {
				if(!(status==STATUS.ASSIGNED)||(status==STATUS.NEW)) {
					throw new IllegalArgumentException("STATUS ONLY CAN BE ASSIGNED!");
				}
			 }
			if(oldstatus==STATUS.ASSIGNED) {
				if(!(status==STATUS.OPEN)) {
					throw new IllegalArgumentException("STATUS ONLY CAN BE OPENED!");
				}
			}
			if(oldstatus==STATUS.OPEN) {
				if(!(status==STATUS.OPEN)||(status==STATUS.DEFECT)||(status==STATUS.DUPLICATE)||(status==STATUS.DEFERRED)||(status==STATUS.REJECTED)||(status==STATUS.NOT_A_BUG)) {
					throw new IllegalArgumentException("STATUS ONLY CAN ONLY BE DEFECT,DUPLICATE,DEFERRED,NOT_A_BUG,REJECTED!");
				}
			}
			if(oldstatus==STATUS.DEFECT) {
				if(!(status==STATUS.DEFECT)||(status==STATUS.WORK_IN_PROGRESS)||(status==STATUS.FIXED)) {
					throw new IllegalArgumentException("STATUS ONLY CAN BE WORK_IN_PROGRESS OR FIXED!");
				}
			}
			if(oldstatus==STATUS.WORK_IN_PROGRESS) {
				if(!(status==STATUS.FIXED)) {
					throw new IllegalArgumentException("STATUS ONLY CAN BE WORK_IN_PROGRESS OR FIXED!");
				}
			}
			if(oldstatus==STATUS.FIXED) {
				if(!(status==STATUS.FIXED)||(status==STATUS.PENDING_RETEST)||(status==STATUS.RETEST)) {
					throw new IllegalArgumentException("STATUS ONLY CAN BE PENDING_REST OR RETEST!");
				}
			}
			if(oldstatus==STATUS.RETEST) {
				if(!(status==STATUS.VERIFIED||status==STATUS.ISSUE)) {
					throw new IllegalArgumentException("STATUS ONLY CAN BE ISSUE!");
				}
			}
			if(oldstatus==STATUS.ISSUE) {
				if(!(status==STATUS.REOPEN)) {
					throw new IllegalArgumentException("STATUS ONLY CAN BE VERIFIED!");
				}
			}
			if(oldstatus==STATUS.REOPEN) {
				if(!(status==STATUS.OPEN)) {
					throw new IllegalArgumentException("STATUS ONLY CAN BE OPEN!");
				}
			}
			if(oldstatus==STATUS.VERIFIED) {
				if(!(status==STATUS.CLOSED)) {
					throw new IllegalArgumentException("STATUS ONLY CAN BE CLOSED!");
				}
			}
			if(oldstatus==STATUS.DUPLICATE||oldstatus==STATUS.REJECTED||oldstatus==STATUS.NOT_A_BUG) {
				if(!(status==STATUS.CLOSED)) {
					throw new IllegalArgumentException("STATUS ONLY CAN BE VERIFIED!");
				}
			}
			if(oldstatus==STATUS.DEFERRED) {
				oldstatus=STATUS.ASSIGNED;
			}
			
		});
		bugRepository.save(bug);
		
	}

}
