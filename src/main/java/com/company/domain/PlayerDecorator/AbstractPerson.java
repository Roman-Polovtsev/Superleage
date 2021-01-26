package com.company.domain.PlayerDecorator;

import com.company.domain.IdHolders;

import java.io.Serializable;

public interface AbstractPerson extends Serializable {

    String getName();

    int getYearOfBirth();
}
