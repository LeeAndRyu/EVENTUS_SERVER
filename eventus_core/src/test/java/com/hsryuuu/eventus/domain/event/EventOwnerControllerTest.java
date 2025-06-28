package com.hsryuuu.eventus.domain.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsryuuu.eventus.appllication.security.BypassUserFactory;
import com.hsryuuu.eventus.domain.event.type.EventConditionType;
import com.hsryuuu.eventus.domain.event.type.EventCreatorType;
import com.hsryuuu.eventus.domain.event.type.EventType;
import com.hsryuuu.eventus.owner.event.dto.CreateEventConditionDto;
import com.hsryuuu.eventus.owner.event.dto.CreateEventRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("EventController 통합 테스트")
@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class EventOwnerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setAuthentication() {
        Authentication authentication = BypassUserFactory.getAllAuthorizedAuthentication();
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Test
    @DisplayName("이벤트 생성 성공")
    void createEvent_success() throws Exception {
        CreateEventRequest request = CreateEventRequest.builder()
                .title("test title")
                .description("설명")
                .startTime(LocalDateTime.now().plusDays(1))
                .endTime(LocalDateTime.now().plusDays(2))
                .eventType(EventType.DURATION)
                .creatorType(EventCreatorType.OWNER)
                .conditions(List.of(
                        new CreateEventConditionDto(EventConditionType.MAX_PARTICIPANTS, "댓글")
                ))
                .build();

        mockMvc.perform(post("/api/owner/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.title").value("test title"))
                .andExpect(jsonPath("$.data.conditions").isArray());
    }
}