package com.zensar.services;

import java.util.List;
import java.util.Optional;

import com.zensar.entities.Status;

public interface StatusService {

	public void addStatus(Status status);

	public void updateStatus(Status status);

	public void deleteStatus(Status status);

	public List<Status> getAllByStatus();

	public Optional<Status> getByStatusId(Long statusId);

}
