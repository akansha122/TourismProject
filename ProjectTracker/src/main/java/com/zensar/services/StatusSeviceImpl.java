package com.zensar.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zensar.entities.Status;
import com.zensar.repository.StatusRepository;

@Service
@Transactional
public class StatusSeviceImpl implements StatusService {

	@Autowired
	private StatusRepository statusRepository;

	@Override
	public void addStatus(Status status) {
		statusRepository.save(status);
	}

	@Override
	public void updateStatus(Status status) {
		/*
		 * // TODO Auto-generated method stub statusDao.save(status);
		 */
	}

	@Override
	public void deleteStatus(Status status) {
		statusRepository.delete(status);
	}

	@Override
	public List<Status> getAllByStatus() {
		return statusRepository.findAll();
	}

	@Override
	public Optional<Status> getByStatusId(Long statusId) {
		return statusRepository.findById(statusId);
	}

}
