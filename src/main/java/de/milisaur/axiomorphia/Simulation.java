package de.milisaur.axiomorphia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulation {

  private final Environment environment;
  private final List<Entity> population = new ArrayList<>(); // like slice in go?
  private int tick = 0;

  public Simulation(Environment environment) {
    this.environment = environment;
  }

  public void addEntity(Entity entity) {
    population.add(entity);
  }

  public void step() {
    tick++;

    environment.regenerate();

    Collections.shuffle(population); // randomising the execution order

    for (Entity entity : population) {
      entity.absorb(environment);
      entity.maintain();
    }

    population.removeIf(entity -> !entity.isAlive()); // remove every entity that is no longer alive

    List<Entity> offspring = new ArrayList<>();

    for (Entity entity : population) {
      if (entity.canReproduce()) {
        offspring.add(entity.reproduce());
      }
    }

    population.addAll(offspring);
  }

  public int getPopulationSize() {
    return population.size();
  }

  public int getTick() {
    return tick;
  }
}
