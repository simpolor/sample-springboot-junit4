package io.simpolor.testing.repository;

import io.simpolor.testing.domain.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository extends JpaRepository<Demo, Long> {

}
