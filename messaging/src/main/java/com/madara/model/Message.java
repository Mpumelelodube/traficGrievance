package com.madara.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table
public class Message extends GenericNamedEntity{
    private Long senderID;
    private Long sender;

    @JsonBackReference
    @ManyToOne
    private Chat chatID;
    private String messageText;

}
