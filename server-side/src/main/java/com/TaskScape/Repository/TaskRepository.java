package com.TaskScape.Repository;

import com.TaskScape.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query("SELECT t from Task t where t.Title=:title AND t.description=:description")
    List<Task> findByTitleAndDescription(@Param("title") String title,
                                         @Param("description") String description);
}
