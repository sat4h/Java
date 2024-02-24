package com.example.demo.jms;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table
public class WatchDog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String object;

    @NonNull
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    public WatchDog(String object, @NonNull EventType eventType) {
        this.object = object;
        this.eventType = eventType;
    }
}
