package com.company.domain.playerDecorator;

import java.io.Serializable;

public interface Person extends Serializable {

    String getName();

    int getYearOfBirth();

    long getID();
}
