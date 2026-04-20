ubuntu@ip-172-31-2-162:~/oops-project$ cat src/main/java/com/disaster/ResourceRepository.java
package com.disaster;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

    List<Resource> findByNameContainingIgnoreCase(String name);

    List<Resource> findByDisaster(String disaster);

    List<Resource> findByAvailable(boolean available);

    List<Resource> findByType(String type);

}
