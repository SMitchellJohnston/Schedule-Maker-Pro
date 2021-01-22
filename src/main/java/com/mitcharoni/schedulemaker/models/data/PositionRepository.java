package com.mitcharoni.schedulemaker.models.data;

import com.mitcharoni.schedulemaker.models.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends CrudRepository<Position, Integer> {

}
