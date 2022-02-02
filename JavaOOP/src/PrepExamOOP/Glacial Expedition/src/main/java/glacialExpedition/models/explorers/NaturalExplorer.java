package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{
    private static final double NATURAL_EXPLORER_ENERGY = 60;

    public NaturalExplorer(String name) {
        super(name, NATURAL_EXPLORER_ENERGY);
    }

    @Override
    public void search() {
        if (super.getEnergy() <= 7) {
            super.setEnergy(0);
        } else {
            super.setEnergy(super.getEnergy() - 7);
        }
    }

}
