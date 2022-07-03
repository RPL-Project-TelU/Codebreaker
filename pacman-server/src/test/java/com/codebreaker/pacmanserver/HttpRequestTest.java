package com.codebreaker.pacmanserver;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.codebreaker.pacmanserver.entity.LeaderboardSubmission;
import com.codebreaker.pacmanserver.repository.LeaderBoardSubmissionRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class HttpRequestTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LeaderBoardSubmissionRepository leaderBoardSubmissionRepository;

    @Test
    public void getTopSubmissionReturnAJSONArray() throws Exception{
        LeaderboardSubmission submission1 = new LeaderboardSubmission();
        submission1.setIdSubmission(1);
        submission1.setName("AAA");
        submission1.setScore(10);

        LeaderboardSubmission submission2 = new LeaderboardSubmission();
        submission2.setIdSubmission(2);
        submission2.setName("AAB");
        submission2.setScore(14);
        
        when(leaderBoardSubmissionRepository.findFirst10ByOrderByScoreDesc())
            .thenReturn(List.of(submission2, submission1));

        this.mockMvc.perform(get("/api/getLeaderboard"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].score", is(14)))
            .andExpect(jsonPath("$[1].name", is("AAA")));
    }

    @Test
    public void removeSubmissionReturnStringMessage() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/delete/{id}", "11")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string("Submission with id of 11 successfully deleted"));
    }

    @Test
    public void removeSubmissionIDNotFound() throws Exception {
        when(leaderBoardSubmissionRepository.findById((long) 11)).thenReturn(null);

        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/delete/{id}", "11")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string("ID Not Found"));
    }

    @Test
    public void removeSubmissionArgumentIsString() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/delete/{id}", "STRING")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().is4xxClientError());
    }

    @Test
    public void submitSubmissionValidName() throws Exception {
        String content = "{\"name\":\"AAA\",\"score\": 10}";

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/submit")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content))
            .andExpect(status().isOk())
            .andExpect(content().string("Success"));
    }

    @Test
    public void submitSubmissionInvalidName() throws Exception {
        String content = "{\"name\":\"Hello World\",\"score\": 10}";

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/submit")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content))
            .andExpect(status().isOk())
            .andExpect(content().string("Failed"));
    }
    
}
