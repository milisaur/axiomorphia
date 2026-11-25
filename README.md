# Axiomorphia

An experimental artificial life simulation written in Java, loosely inspired by Conway's Game of Life and the idea of complexity emerging from simple rules.

## Concept

- Define a minimal set of rules within an artificial universe.
- Establish conditions under which entities can exist, interact and reproduce.
- Observe population dynamics emerging from these interactions.
- Investigate how simple rules can give rise to complex behaviour.
- Gradually extend the model to explore evolutionary processes.

The model is not restricted to terrestrial biology and, unlike Conway's Game of Life, focuses on energy exchange, resource competition and individual heritable characteristics.

## Model

### Environment

- Contains a finite amount of energy.
- Regenerates energy at a constant rate.
- Has a maximum energy capacity.
- Provides a shared energy field accessible to all entities.

### Entities

Each entity has three fundamental properties:

| Property | Description |
|---|---|
| Energy | Current internal energy reserve |
| Absorption rate | Proportion of available energy an entity can absorb |
| Maintenance cost | Energy required per tick to sustain existence |

### Fundamental rules

- Energy is required for existence.
- Absorbed energy is removed from the environment.
- Maintenance reduces internal energy.
- Reaching zero energy results in irreversible death.
- Reproduction requires a minimum internal energy reserve.
- During reproduction, energy is divided equally between parent and offspring.
- Offspring inherit the characteristics of their parent.

### Simulation cycle

Each tick consists of the following operations:

1. Regenerate environmental energy.
2. Randomise the interaction order.
3. Process energy absorption and maintenance.
4. Remove dead entities.
5. Process reproduction.
6. Integrate offspring into the population.

## Running

Requires Java 25 and Maven.

```bash
git clone https://github.com/milisaur/axiomorphia.git
cd axiomorphia
mvn compile
java -cp target/classes de.milisaur.axiomorphia.Main
```

## Further development

- Heritable variation and mutation
- Reproducible experiments
- Population statistics
- Spatial environments
- Environmental variation
- Emergent behaviour

## License

Licensed under the GNU General Public License v3.0.
See [LICENSE](LICENSE) for details.
