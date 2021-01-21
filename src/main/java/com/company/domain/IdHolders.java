package com.company.domain;

/**
 * This interface give access to object ID for all classes implementing its
 * Created by me to have an ability finding objects by ID in generic class Repository<T>
 */

public interface IdHolders {
    long getID();
}
