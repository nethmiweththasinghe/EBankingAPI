package com.example.ebanking.feedback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="feedback")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_generator")
    @SequenceGenerator(name="feedback_generator", sequenceName = "fb_seq", allocationSize=50)
    @Column(name = "fId", updatable = false, nullable = false)
    private long fId;
    private String Name;
    private String feedback;
}
