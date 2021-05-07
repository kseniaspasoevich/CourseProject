package Service3;

import java.sql.Time;

public class Stats {
    private int amountOfUnloadedShips;
    //private int averageLengthOfQueue;
    private Time timeOfWaitingInQueue;
    private double maxUnloadDelay;
    private double averageUnloadDelay;
    private double maximumPenalty;
    private int amountOfNeededCranes;

    public Stats() {
        this.amountOfUnloadedShips = DoStatistics.getUnloadedShipsAmount();
        this.timeOfWaitingInQueue = DoStatistics.getTimeOfWaiting();
        this.maxUnloadDelay = DoStatistics.getMax();
        this.averageUnloadDelay = DoStatistics.getAverage();
        this.maximumPenalty = DoStatistics.getMaxPenalty();
        this.amountOfNeededCranes = DoStatistics.getNeededCranes();
    }

    public int getAmountOfUnloadedShips() {
        return amountOfUnloadedShips;
    }

    public void setAmountOfUnloadedShips(int amountOfUnloadedShips) {
        this.amountOfUnloadedShips = amountOfUnloadedShips;
    }

    public Time getTimeOfWaitingInQueue() {
        return timeOfWaitingInQueue;
    }

    public void setTimeOfWaitingInQueue(Time timeOfWaitingInQueue) {
        this.timeOfWaitingInQueue = timeOfWaitingInQueue;
    }

    public double getMaxUnloadDelay() {
        return maxUnloadDelay;
    }

    public void setMaxUnloadDelay(double maxUnloadDelay) {
        this.maxUnloadDelay = maxUnloadDelay;
    }

    public double getAverageUnloadDelay() {
        return averageUnloadDelay;
    }

    public void setAverageUnloadDelay(double averageUnloadDelay) {
        this.averageUnloadDelay = averageUnloadDelay;
    }

    public double getMaximumPenalty() {
        return maximumPenalty;
    }

    public void setMaximumPenalty(double maximumPenalty) {
        this.maximumPenalty = maximumPenalty;
    }

    public int getAmountOfNeededCranes() {
        return amountOfNeededCranes;
    }

    public void setAmountOfNeededCranes(int amountOfNeededCranes) {
        this.amountOfNeededCranes = amountOfNeededCranes;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "amountOfUnloadedShips=" + amountOfUnloadedShips +
                ", timeOfWaitingInQueue=" + timeOfWaitingInQueue +
                ", maxUnloadDelay=" + maxUnloadDelay +
                ", averageUnloadDelay=" + averageUnloadDelay +
                ", maximumPenalty=" + maximumPenalty +
                ", amountOfNeededCranes=" + amountOfNeededCranes +
                '}';
    }
}
