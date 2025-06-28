package com.hsryuuu.eventus.owner.event;

import com.hsryuuu.eventus.domain.event.dto.EventDto;
import com.hsryuuu.eventus.owner.event.dto.CreateEventRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "이벤트 Owner API")
@RequiredArgsConstructor
@RequestMapping("/api/owner/events")
@RestController
public class EventOwnerController {

    private final EventOwnerService eventService;

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
}
