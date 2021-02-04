package com.company.repository.Hall;

import com.company.domain.EnableGameTime;
import com.company.repository.DataBaseException;

public interface GameTimeRepository {

    long getID();

    void save(EnableGameTime gameTime) throws DataBaseException;

    EnableGameTime getById(long id) throws DataBaseException;

    void delete(EnableGameTime gameTime);
}
