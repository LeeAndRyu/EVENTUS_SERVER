package com.hsryuuu.eventus.domain.event.entity;

import com.hsryuuu.eventus.domain.event.type.EventConditionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;

@Entity
@Table(name = "event_condition")
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
public class EventCondition {
    @Id
    @GeneratedValue
    private UUID id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    @Enumerated(EnumType.STRING)
    private EventConditionType conditionType;

    private String value;

    public EventCondition(EventConditionType conditionType, String value) {
        this.conditionType = conditionType;
        this.value = value;
    }


}
