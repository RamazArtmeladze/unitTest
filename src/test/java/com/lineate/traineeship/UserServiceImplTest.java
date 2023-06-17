package com.lineate.traineeship;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class UserServiceImplTest {
    @Mock
    private UserServiceImpl userService;
    @Mock
    private EntityService entityService;

    @BeforeEach
    public void setup() {
        entityService = mock(EntityService.class);
        userService = new UserServiceImpl();
    }
    @Test
    void createGroup() {
        Group createdGroup = userService.createGroup("Admin");

        assertThat(createdGroup.getName()).isEqualTo("Admin");
    }
    @Test
    void addUserToGroup() {
        Group group = new Group("Admin");
        User user = new User("User", group);

        userService.addUserToGroup(user, group);

        assertThat(group.getUsers()).contains(user);
    }
    @Test
    void createUserWithNameAndGroup() {
        Group group = new Group("Admin");
        User expectedUser = new User("User", group);

        userService.createGroup("Admin");
        User createdUser = userService.createUser("User", group);

        assertThat(createdUser).isEqualTo(expectedUser);

        Set<Group> expectedGroups = new HashSet<>();
        expectedGroups.add(group);
        assertThat(createdUser.getGroups()).isEqualTo(expectedGroups);
    }
}

