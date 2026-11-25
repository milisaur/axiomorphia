package de.milisaur.axiomorphia;

public class Environment {

  private double energy;
  private final double capacity;
  private final double regenerationRate;

  public Environment(double capacity, double regenerationRate) {
    this.capacity = capacity;
    this.regenerationRate = regenerationRate;
    this.energy = capacity;
  }

  public void regenerate() {
    energy = Math.min(capacity, energy + regenerationRate);
  }

  public double extract(double requestedEnergy) {
    if (!Double.isFinite(requestedEnergy) || requestedEnergy < 0) {
      throw new IllegalArgumentException("Invalid energy request");
    }

    double extractedEnergy = Math.min(energy, requestedEnergy);
    energy -= extractedEnergy;

    return extractedEnergy;
  }

  public double getEnergy() {
    return energy;
  }
}
