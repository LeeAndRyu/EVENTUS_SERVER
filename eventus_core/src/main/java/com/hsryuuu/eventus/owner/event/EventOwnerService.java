package com.hsryuuu.eventus.owner.event;

import com.hsryuuu.eventus.appllication.exception.impl.OwnerException;
import com.hsryuuu.eventus.appllication.security.SecurityUtils;
import com.hsryuuu.eventus.appllication.util.DateTimeValidator;
import com.hsryuuu.eventus.domain.event.EventQueryRepository;
import com.hsryuuu.eventus.domain.event.EventRepository;
import com.hsryuuu.eventus.domain.event.dto.EventDto;
import com.hsryuuu.eventus.domain.event.entity.Event;
import com.hsryuuu.eventus.domain.event.entity.EventCondition;
import com.hsryuuu.eventus.member.owner.OwnerRepository;
import com.hsryuuu.eventus.member.owner.entity.Owner;
import com.hsryuuu.eventus.owner.event.dto.CreateEventRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RequiredArgsConstructor
@Service
public class EventOwnerService {

    private final OwnerRepository ownerRepository;
    private final EventRepository eventRepository;
    private final EventQueryRepository eventQueryRepository;

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

    @Transactional(readOnly = true)
    public List<EventDto> findAll() {
        // TEMP: 검색 / 페이지네이션 필요
        return eventQueryRepository.findAll()
                .stream()
                .map(EventDto::fromEntity)
                .toList();
    }
}
