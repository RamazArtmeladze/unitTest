package com.lineate.traineeship;

import com.lineate.traineeship.*;

import java.security.Provider;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;


import com.lineate.traineeship.DatabaseEntityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseEntityServiceTest {


    private EntityRepository entityRepository;
    private EntityService entityService;
    private UserService userService;



    @BeforeEach
    public void setUp() {
        entityRepository = mock(EntityRepository.class);
        entityService = ServiceFactory.createEntityService(entityRepository);
        userService = ServiceFactory.createUserService();

    }

    @Test
    void getByName() {
        User user = userService.createUser("user");
        Entity entity = new Entity("entity");

        when(entityRepository.save(entity)).thenReturn(true);
        boolean saved = entityService.save(user, entity);
        assertThat(saved).isTrue();

        when(entityRepository.getByName("entity")).thenReturn(entity);
        Entity userEntity = entityService.getByName(user, entity.getName());
        assertThat(entity).isEqualTo(userEntity);
    }

    @Test
    void delete() {
        User user = userService.createUser("user");
        Entity entity = new Entity("entity");

        entityService.save(user, entity);

        when(entityRepository.delete(entity)).thenReturn(true);
        boolean deleted = entityService.delete(user, entity);
        assertThat(deleted).isTrue();

    }
}