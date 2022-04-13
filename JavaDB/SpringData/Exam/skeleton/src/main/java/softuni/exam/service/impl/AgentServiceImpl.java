package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportAgentDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.repository.AgentRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class AgentServiceImpl implements AgentService {

    public static final String AGENTS_FILE_PATH = "src/main/resources/files/json/agents.json";

    private final AgentRepository agentRepository;
    private final TownService townService;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public AgentServiceImpl(AgentRepository agentRepository, TownService townService, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.agentRepository = agentRepository;
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENTS_FILE_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        ImportAgentDto[] importAgentDtos = gson.fromJson(readAgentsFromFile(), ImportAgentDto[].class);
        StringBuilder sb = new StringBuilder();
        for (ImportAgentDto importAgentDto : importAgentDtos) {
            if (validationUtil.isValid(importAgentDto)){
                Agent agent = modelMapper.map(importAgentDto, Agent.class);
                if (existsAgentByFirstName(agent.getFirstName())){
                    sb.append("Invalid agent");
                }else{
                    agent.setTown(townService.findByTownName(importAgentDto.getTown()).orElse(null));
                    agentRepository.save(agent);
                    sb.append(String.format("Successfully imported agent - %s %s", agent.getFirstName(), agent.getLastName()));
                }

            } else {
                sb.append("Invalid agent");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public boolean existsAgentByFirstName(String name) {
        return agentRepository.existsAgentByFirstName(name);
    }
}
