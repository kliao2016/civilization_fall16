package model;

public class CoalMinerUnit extends Unit implements Convertable {

    public CoalMinerUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public Building convert() {
        return new CoalMine(getOwner());
    }

    @Override
    public boolean canConvert(TileType type) {
        if (type.getSymbol() == 'H') {
            return true;
        }
        return false;
    }

    @Override
    public char symbol() {
        return 'c';
    }

    @Override
    public String toString() {
        return "Coal Miners. " + super.toString();
    }
}