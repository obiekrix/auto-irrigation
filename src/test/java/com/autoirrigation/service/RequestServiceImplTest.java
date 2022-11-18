package com.autoirrigation.service;

import com.autoirrigation.entity.Request;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RequestServiceImplTest {

	@Autowired
	RequestService requestService;

	@Test
	void getAllRequests() {
		List<Request> allRequests = requestService.getAllRequests();
		assertThat(allRequests.size()).isEqualTo(0);
	}

}
