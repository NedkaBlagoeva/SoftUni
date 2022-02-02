package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Explorer> explorerRepository;
    private Repository<State> stateRepository;
    private int countExploredStates;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type) {
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);

        }

        this.explorerRepository.add(explorer);

        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
//        Collection<String> stateExhibits = state.getExhibits();
//        Collections.addAll(stateExhibits, exhibits);
        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }
        this.stateRepository.add(state);
        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorerRepository.byName(explorerName);
        if (explorer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        explorerRepository.remove(explorer);
        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);

    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer> explorerList = explorerRepository.getCollection()
                .stream()
                .filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());
        if (explorerList.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        } else {
            State stateToExplorer = new StateImpl(stateName);
            Mission mission = new MissionImpl();
            mission.explore(stateToExplorer, explorerList);
        }
        long retired = explorerList.stream().filter(e -> e.getEnergy() < 0).count();
        countExploredStates++;
        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retired);
    }

    @Override
    public String finalResult() {
        StringBuilder result = new StringBuilder();
        result.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, this.countExploredStates));
        result.append(System.lineSeparator());
        result.append(ConstantMessages.FINAL_EXPLORER_INFO);

        Collection<Explorer> explorers = this.explorerRepository.getCollection();
        for (Explorer explorer : explorers) {
            result.append(System.lineSeparator());
            result.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, explorer.getName()));
            result.append(System.lineSeparator());
            result.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, explorer.getEnergy()));
            result.append(System.lineSeparator());
            if(explorer.getSuitcase().getExhibits().isEmpty()){
                result.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
            } else {
                result.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,
                        String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits())));
            }
        }
        return result.toString();
    }
}
