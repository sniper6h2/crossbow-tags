# Crossbow Tags

Carrying a Piercing crossbow *and* a Multishot crossbow? Mid-fight they look identical. Crossbow Tags flashes a background behind each one in your hotbar and inventories so you grab the right one instantly:

| Enchantment | Background |
|---|---|
| Piercing | flashing **light green** |
| Multishot | flashing **light red** |

Crossbows with neither enchantment, and every other item, are left alone.

**Requires [EagerLib](https://github.com/sniper6h2/EagerLib)** for the same Minecraft version. Press **Right Shift** in game (or use Mod Menu) to open its settings:
- the colours
- flashing on/off, flash speed, and the dimmest and brightest opacity
- hotbar and inventory switches
- a toggle key

It's client-side only and works on any server.

| Minecraft | Jar | Java |
|---|---|---|
| 26.3 / 26.2 / 26.1 – 26.1.2 | `crossbow-tags-1.1.0+mc26.x.jar` | 25 |
| 1.21.11 / 1.21.8 / 1.21.4 / 1.21 – 1.21.1 | `crossbow-tags-1.1.0+mc1.21.x.jar` | 21 |

## Building

This repository includes [EagerLib](https://github.com/sniper6h2/EagerLib) as a git submodule, so clone it with submodules:

```bash
git clone --recursive https://github.com/sniper6h2/crossbow-tags.git
```

If you already cloned it without them, run:

```bash
git submodule update --init
```

You need JDK 25, which also builds the Java 21 jars. Then run:

```bash
./gradlew buildAll
```

The jars land in `dist/`, one per Minecraft version. EagerLib is built from the submodule automatically.

To move to the newest EagerLib, run:

```bash
git submodule update --remote eagerlib
```

### In-game smoke test (dev only)

```bash
./scripts/smoke-test.sh 26.3
```

This generates a flat test world and launches the game with this mod and EagerLib. It screenshots the HUD and every EagerLib page, then quits. Screenshots land in `versions/<mc>/run/screenshots/`.

## License

MIT

The Modrinth listing text and the 512 px icon are in `modrinth/`.
