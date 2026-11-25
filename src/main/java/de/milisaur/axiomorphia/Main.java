package de.milisaur.axiomorphia;

public class Main {

  public static void main(String[] args) {
    Environment environment = new Environment(100, 10);
    Simulation simulation = new Simulation(environment);

    for (int i = 0; i < 20; i++) {
      simulation.addEntity(new Entity(10, 0.2, 2));
    }

    for (int i = 0; i < 50; i++) {
      simulation.step();

      System.out.printf("Tick %d | Population: %d | Environment: %.2f%n", simulation.getTick(),
          simulation.getPopulationSize(), environment.getEnergy());
    }
  }
}
