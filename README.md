# SpawnTeleport

A small Paper/Spigot plugin that teleports every player to the world `spawn` at `0.5 / 97 / 0.5` each time they join the server.

## Requirements

- Paper or Spigot 1.20.x
- Java 17+
- A loaded world named `spawn`

## Build

```
mvn package
```

The jar is written to `target/SpawnTeleport-1.0.0.jar`. Copy it into your server's `plugins/` folder and restart.

## Configuration

The world name and coordinates are constants at the top of
`src/main/java/com/example/spawnteleport/SpawnTeleport.java`:

```java
private static final String WORLD_NAME = "spawn";
private static final double X = 0.500;
private static final double Y = 97.00000;
private static final double Z = 0.500;
```

If the `spawn` world isn't loaded, the plugin logs a warning and does nothing.
