package com.hsryuuu.eventus.domain.event.dto;

import com.hsryuuu.eventus.domain.event.type.EventConditionType;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateEventConditionDto {
    private EventConditionType conditionType;
    private String value;
}
