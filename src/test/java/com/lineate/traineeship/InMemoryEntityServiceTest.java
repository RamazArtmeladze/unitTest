package com.lineate.traineeship;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryEntityServiceTest {

    @Mock
    private EntityService entityService;
    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        entityService = ServiceFactory.createEntityService();
        userService = ServiceFactory.createUserService();
    }


    @Test
    void delete() {
        User user = userService.createUser("user");
        Entity entity = new Entity("entity");

        entityService.save(user, entity);

        boolean deleted = entityService.delete(user, entity);
        assertThat(deleted).isTrue();
    }
}