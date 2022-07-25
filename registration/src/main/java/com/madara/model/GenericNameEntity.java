package com.madara.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@EqualsAndHashCode
public abstract class GenericNameEntity extends BaseID{

    protected String name;
    protected static final long serialVersionUID = 1L;
}
