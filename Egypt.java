public class Egypt {
    private Desert desert;
    private Population ePop;
    private Treasury eTreasury;
    private CoalMine cMine;
    private River river;
    private Technology tech;
    private Strategy strat;
    private Settlement[] settleArr;
    private int settlePos;

    public Egypt() {
        desert = new Desert();
        ePop = new Population();
        eTreasury = new Treasury();
        cMine = new CoalMine();
        river = new River("Nile River");
        tech = new Technology();
        strat = new Strategy();
        settleArr = new Settlement[10];
        settlePos = 0;
    }

    public Desert getDesert() {
        return desert;
    }

    public Population getPopulation() {
        return ePop;
    }

    public Treasury getTreasury() {
        return eTreasury;
    }

    public CoalMine getCoalMine() {
        return cMine;
    }

    public River getRiver() {
        return river;
    }

    public Technology getTechnology() {
        return tech;
    }

    public Strategy getStrategy() {
        return strat;
    }

    public Settlement[] getSettlements() {
        return settleArr;
    }

    public boolean settle(Settlement tbsettled) {
        if (settlePos < 10) {
            settleArr[settlePos] = tbsettled;
            settlePos++;
            return true;
        } else {
            return false;
        }
    }

    public int getNumSettlements() {
        int index = 0;
        while (index < settleArr.length && settleArr[index] != null) {
            index++;
        }
        return index;
    }

    public boolean buildPyramid(Settlement pSettle) {
        tech.increaseExperience(10);
        return pSettle.build(eTreasury.getCoins(), ePop, 500, 100);
    }

    public void practiceHieroglyphics() {
        ePop.increaseHappiness(10);
    }
}