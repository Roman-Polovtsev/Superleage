package com.company.repository.Hall;

import com.company.domain.Hall;

public interface HallRepository {

    long getID();

    void save(Hall hall);

    Hall getById(long id);

    void delete(Hall hall);
}
