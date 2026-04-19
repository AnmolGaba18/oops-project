package com.disaster;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

    List<Resource> findByAvailable(boolean available);

    List<Resource> findByTypeContainingIgnoreCase(String type);

    List<Resource> findByDisasterTypeContainingIgnoreCase(String disasterType);

    List<Resource> findByNameContainingIgnoreCase(String name);
}