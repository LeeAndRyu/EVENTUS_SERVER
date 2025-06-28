package com.hsryuuu.eventus.domain.event.dto;

import com.hsryuuu.eventus.domain.event.entity.Event;
import com.hsryuuu.eventus.domain.event.type.EventCreatorType;
import com.hsryuuu.eventus.domain.event.type.EventType;
import com.hsryuuu.eventus.member.owner.entity.Owner;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class CreateEventRequest {
    @NotBlank
    private String title;

    private String description;

    @NotNull
    private LocalDateTime startTime;
    @NotNull
    private LocalDateTime endTime;

    @NotNull
    private EventType eventType;

    private EventCreatorType creatorType;

    @Builder.Default
    private List<CreateEventConditionDto> conditions = new ArrayList<>();

    public static Event toEntity(CreateEventRequest req, Owner owner) {
        return Event.builder()
                .title(req.getTitle())
                .description(req.getDescription())
                .startTime(req.getStartTime())
                .endTime(req.getEndTime())
                .eventType(req.getEventType())
                .creatorType(req.getCreatorType())
                .owner(owner)
                .build();
    }
}
