package com.ibm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ibm.Entity.Bug;
import com.ibm.Entity.STATUS;
import com.ibm.repo.BugRepository;

public class DummyBugRepository implements BugRepository {

	@Override
	public <S extends Bug> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bug> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bug> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Bug save(Bug bug) {
		bug.setId("24398t84gb32oi");
		bug.setStatus(STATUS.VERIFIED);
		return bug;
	}

	@Override
	public <S extends Bug> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bug> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bug> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bug> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Bug> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	//public <S extends Bug> S save(S entity) {
		// TODO Auto-generated method stub
	//	return null;
	//}

	@Override
	public Optional<Bug> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Bug> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Bug entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Bug> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Bug> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bug> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bug> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Bug> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Bug> findByName(String bugName) {
		// TODO Auto-generated method stub
		return null;
	}

}
