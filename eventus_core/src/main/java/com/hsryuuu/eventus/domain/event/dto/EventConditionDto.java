package com.hsryuuu.eventus.domain.event.dto;

import com.hsryuuu.eventus.domain.event.entity.EventCondition;
import com.hsryuuu.eventus.domain.event.type.EventConditionType;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class EventConditionDto {
    private UUID id;
    private EventConditionType conditionType;
    private String value;
    private UUID eventId;

    public static EventConditionDto fromEntity(EventCondition eventCondition) {
        return EventConditionDto.builder()
                .id(eventCondition.getId())
                .conditionType(eventCondition.getConditionType())
                .value(eventCondition.getValue())
                .eventId(eventCondition.getEvent().getId())
                .build();
    }
}
