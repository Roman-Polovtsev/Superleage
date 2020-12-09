package com.company.services;

import com.company.domain.Team;
import junit.framework.TestCase;

public class TeamServiceTest extends TestCase {

    public void testFindHighest() {
        TeamService service = new TeamService();
        service.addTeam(new Team());
        assertEquals(new Team(),new TeamService().findHighest());
    }
}