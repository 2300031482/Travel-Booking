package klu.model;

import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; // bus, train, flight
    private String fromLocation;
    private String toLocation;
    private String date;
    private String passengerName;

    @ManyToOne
    private User user;

    // Getters & Setters
}
