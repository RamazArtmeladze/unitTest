# junit

## User

1. The user must get a name
2. User must belong to at least one group

## Group

1. The group must have a name
2. The group is used in the list of permissions in the BaseEntityService, which determines the level of user access to the entity (read or write)

## Permission

1. Permissions have two flags read and write
2. Read - allows all users to read data from the entity
3. Write - allows all users to change the value of an entity

## Entity

1. The entity must have a name
2. An entity has a mutable value
3. Entity name must not contain whitespace characters
4. Entity name must not be more than 32 characters
5. Entity name must not be empty

## Services

1. All operations on users groups and entities must be performed using services
* UserService - service for working with users and groups
* EntityService - service for working with entities
* ServiceFactory - a factory for creating services

## Requirements

1. The user who created the entity gets full read and write access to this entity, regardless of
   permissions of the groups to which he is a member
2. When an entity is created, all groups in which the user who created the entity is a member are bound to it
3. Users other than the creator of the entity can only access the entity through the group.