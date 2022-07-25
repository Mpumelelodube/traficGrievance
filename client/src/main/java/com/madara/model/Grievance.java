package com.madara.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Grievance extends GenericNameEntity{
    @Column(nullable = false, updatable = false)
    private String email;
    private LocalDate date = LocalDate.now();
    private String cartegories;
    private String additionalInfomation;
    private String licencePlate;
    private int status = 1;
    @Column(nullable = false)
    private Long griever;
}
