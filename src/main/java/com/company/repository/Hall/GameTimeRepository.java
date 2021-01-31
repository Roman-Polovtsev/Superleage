package com.company.repository.Hall;

import com.company.domain.EnableGameTime;

public interface GameTimeRepository {

    long getID();

    void save(EnableGameTime gameTime);

    EnableGameTime getById(long id);

    void delete(EnableGameTime gameTime);
}
