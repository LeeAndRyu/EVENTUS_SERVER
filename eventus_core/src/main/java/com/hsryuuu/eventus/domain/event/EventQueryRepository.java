package com.hsryuuu.eventus.domain.event;

import com.hsryuuu.eventus.domain.event.entity.Event;
import com.hsryuuu.eventus.domain.event.entity.QEvent;
import com.hsryuuu.eventus.domain.event.entity.QEventCondition;
import com.hsryuuu.eventus.user.owner.entity.QOwner;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class EventQueryRepository {

    private static final QEvent event = QEvent.event;
    private static final QEventCondition eventCondition = QEventCondition.eventCondition;
    private static final QOwner owner = QOwner.owner;
    private final JPAQueryFactory queryFactory;

    public List<Event> findAll() {
        return queryFactory.selectFrom(event)
                .join(event.owner, owner).fetchJoin()
                .leftJoin(eventCondition).on(event.id.eq(eventCondition.event.id)).fetchJoin()
                .fetch();
    }
}
