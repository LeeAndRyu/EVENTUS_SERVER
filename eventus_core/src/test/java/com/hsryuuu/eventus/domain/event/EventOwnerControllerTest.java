package com.hsryuuu.eventus.domain.event;

import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@DisplayName("EventController 통합 테스트")
@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class EventOwnerControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    void setAuthentication() {
//        Authentication authentication = BypassUserFactory.getAllAuthorizedAuthentication();
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//    }
//
//    @Test
//    @DisplayName("이벤트 생성 성공")
//    void createEvent_success() throws Exception {
//        CreateEventRequest request = CreateEventRequest.builder()
//                .title("test title")
//                .description("설명")
//                .startTime(LocalDateTime.now().plusDays(1))
//                .endTime(LocalDateTime.now().plusDays(2))
//                .eventType(EventType.DURATION)
//                .creatorType(EventCreatorType.OWNER)
//                .conditions(List.of(
//                        new CreateEventConditionDto(EventConditionType.MAX_PARTICIPANTS, "댓글")
//                ))
//                .build();
//
//        mockMvc.perform(post("/api/owner/events")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.title").value("test title"))
//                .andExpect(jsonPath("$.data.conditions").isArray());
//    }
}