package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.models.dto.AgentNameDto;
import softuni.exam.models.entity.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {

    boolean existsAgentByFirstName(String name);

    Agent findByFirstName(String name);
}
