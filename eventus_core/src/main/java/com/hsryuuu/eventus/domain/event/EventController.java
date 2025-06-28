package com.hsryuuu.eventus.domain.event;

import com.hsryuuu.eventus.domain.event.dto.CreateEventRequest;
import com.hsryuuu.eventus.domain.event.dto.EventDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "이벤트 API")
@RequiredArgsConstructor
@RequestMapping("/api/events")
@RestController
public class EventController {

    private final EventService eventService;

    @PreAuthorize("hasRole('ROLE_OWNER')")
    @Operation(summary = "이벤트 생성")
    @PostMapping
    public EventDto createEvent(@RequestBody CreateEventRequest request) {
        return eventService.createEvent(request);
    }

    @Operation(summary = "이벤트 조회 (임시)")
    @GetMapping
    public List<EventDto> getParticipants() {

        return eventService.findAll();
    }

//    @Operation(summary = "이벤트 참여")
//    @PostMapping("/{eventId}")
//    public Object participateEvent(@PathVariable UUID eventId,
//                                   @RequestBody Object request) {
//        AuthPrincipal currentUser = SecurityUtils.getCurrentUser();
//        return null;
//    }
//
//    @Operation(summary = "이벤트 참여 인원 조회")
//    @GetMapping("/{eventId}/participants")
//    public Object getParticipants(@PathVariable UUID eventId) {
//        AuthPrincipal currentUser = SecurityUtils.getCurrentUser();
//
//        return null;
//    }
//
//    @Operation(summary = "이벤트 상태 변경")
//    @PutMapping("/{eventId}")
//    public Object changeEventStatus(@PathVariable UUID eventId) {
//        AuthPrincipal currentUser = SecurityUtils.getCurrentUser();
//        return null;
//    }
//
//    @Operation(summary = "이벤트 당첨자 추첨")
//    @PostMapping("/{eventId}/draw")
//    public Object drawParticipants(@PathVariable UUID eventId) {
//        AuthPrincipal currentUser = SecurityUtils.getCurrentUser();
//        return null;
//    }
}
