package com.hsryuuu.eventus.domain.event.dto;

import com.hsryuuu.eventus.domain.event.entity.Event;
import com.hsryuuu.eventus.domain.event.type.EventCreatorType;
import com.hsryuuu.eventus.domain.event.type.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDto {
    private UUID id;
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private UUID ownerId;
    private EventType eventType;
    private EventCreatorType creatorType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<EventConditionDto> conditions;

    public static EventDto fromEntity(Event event) {
        return EventDto.builder()
                .id(event.getId())
                .title(event.getTitle())
                .description(event.getDescription())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .ownerId(event.getOwner() != null ? event.getOwner().getId() : null)
                .eventType(event.getEventType())
                .creatorType(event.getCreatorType())
                .createdAt(event.getCreatedAt())
                .updatedAt(event.getUpdatedAt())
                .conditions(event.getConditions().stream()
                        .map(EventConditionDto::fromEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}