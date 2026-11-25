package de.milisaur.axiomorphia;

public class Entity {

  private double energy;
  private final double absorptionRate;
  private final double maintenanceCost;

  public Entity(double energy, double absorptionRate, double maintenanceCost) {
    if (!Double.isFinite(energy) || energy < 0) {
      throw new IllegalArgumentException("Invalid energy");
    }

    if (!Double.isFinite(absorptionRate) || absorptionRate <= 0 || absorptionRate > 1) {
      throw new IllegalArgumentException("Invalid absorption rate");
    }

    if (!Double.isFinite(maintenanceCost) || maintenanceCost < 0) {
      throw new IllegalArgumentException("Invalid maintenance cost");
    }
    this.energy = energy;
    this.absorptionRate = absorptionRate;
    this.maintenanceCost = maintenanceCost;
  }

  public void absorb(Environment environment) {
    if (!isAlive()) { // guard clause
      return;
    }

    double requestedEnergy = environment.getEnergy() * absorptionRate;
    double extractedEnergy = environment.extract(requestedEnergy);

    energy += extractedEnergy;
  }

  public void maintain() {
    energy = Math.max(0, energy - maintenanceCost);
  }

  public boolean isAlive() {
    return energy > 0;
  }

  public double getEnergy() {
    return energy;
  }

  public boolean canReproduce() {
    return energy >= 20;
  }

  public Entity reproduce() {
    if (!canReproduce()) {
      throw new IllegalStateException(
          "Insufficient energy for reproduction");
    }

    double offspringEnergy = energy / 2;
    energy -= offspringEnergy;

    return new Entity(
        offspringEnergy,
        absorptionRate,
        maintenanceCost);
  }

}
