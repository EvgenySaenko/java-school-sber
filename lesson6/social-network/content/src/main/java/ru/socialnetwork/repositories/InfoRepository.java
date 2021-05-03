package ru.socialnetwork.repositories;

import ru.socialnetwork.persist.entities.Info;

public interface InfoRepository {
    Info getInfoById(Long id);
}
