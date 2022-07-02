package com.codebreaker.pacmanserver;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codebreaker.pacmanserver.repository.LeaderBoardSubmissionRepository;

@SpringBootTest
class PacmanServerApplicationTests {

	@Autowired
	private LeaderBoardSubmissionRepository leaderBoardSubmissionRepository;

	@Test
	void contextLoads() throws Exception{
		assertThat(leaderBoardSubmissionRepository).isNotNull();
	}
}
