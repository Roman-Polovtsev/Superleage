package com.company.domain.PlayerDecorator;

import java.io.Serializable;

public interface Person extends Serializable {

    String getName();

    int getYearOfBirth();

    long getID();
}
