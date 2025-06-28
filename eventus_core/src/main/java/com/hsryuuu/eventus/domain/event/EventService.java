package com.hsryuuu.eventus.domain.event;

import com.hsryuuu.eventus.appllication.exception.impl.OwnerException;
import com.hsryuuu.eventus.appllication.security.SecurityUtils;
import com.hsryuuu.eventus.appllication.util.DateTimeValidator;
import com.hsryuuu.eventus.domain.event.dto.CreateEventRequest;
import com.hsryuuu.eventus.domain.event.dto.EventDto;
import com.hsryuuu.eventus.domain.event.entity.Event;
import com.hsryuuu.eventus.domain.event.entity.EventCondition;
import com.hsryuuu.eventus.user.owner.OwnerRepository;
import com.hsryuuu.eventus.user.owner.entity.Owner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class EventService {

    private final OwnerRepository ownerRepository;
    private final EventRepository eventRepository;

    @Transactional
    public EventDto createEvent(CreateEventRequest request) {
        UUID userId = Objects.requireNonNull(SecurityUtils.getCurrentUser()).getId();
        Owner owner = ownerRepository.findById(userId)
                .orElseThrow(() -> OwnerException.defaultNotFound("오너 사용자"));

        DateTimeValidator.validateTimeRange(request.getStartTime(), request.getEndTime());

        Event event = CreateEventRequest.toEntity(request, owner);

        Optional.ofNullable(request.getConditions())
                .orElse(Collections.emptyList())
                .stream()
                .map(item -> new EventCondition(item.getConditionType(), item.getValue()))
                .forEach(event::addCondition);

        Event saved = eventRepository.save(event);

        return EventDto.fromEntity(saved);
    }
}
