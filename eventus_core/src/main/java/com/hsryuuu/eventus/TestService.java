package com.hsryuuu.eventus;

import com.hsryuuu.eventus.domain.event.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TEMP: 테스트용 서비스
@RequiredArgsConstructor
@Service
public class TestService {

    private final EventRepository eventRepository;

    @Transactional
    public void deleteAllEvents() {
        eventRepository.deleteAll();
    }
}
