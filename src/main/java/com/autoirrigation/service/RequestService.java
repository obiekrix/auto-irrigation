package com.autoirrigation.service;

import com.autoirrigation.entity.Request;

import java.util.List;

public interface RequestService {

	void saveIrrigationRequest(Request request);

	List<Request> getAllRequests();

	Integer requestIrrigation();
}
