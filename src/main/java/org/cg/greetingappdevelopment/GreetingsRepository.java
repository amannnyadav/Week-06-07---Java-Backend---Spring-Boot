package org.cg.greetingappdevelopment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingsRepository extends JpaRepository<Greetings,Long>{

}
