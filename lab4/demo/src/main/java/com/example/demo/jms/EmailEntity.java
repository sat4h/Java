package com.example.demo.jms;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "emails")
@NoArgsConstructor
public class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "recipient")
    private String to;

    @Column
    private String body;

    public EmailEntity(String to, String body) {
        this.to = to;
        this.body = body;
    }

}
