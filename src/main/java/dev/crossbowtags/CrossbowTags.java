package dev.crossbowtags;

import dev.eagerlib.api.BoolOption;
import dev.eagerlib.api.ColorOption;
import dev.eagerlib.api.EagerLibPlugin;
import dev.eagerlib.api.EagerMod;
import dev.eagerlib.api.EagerRegistry;
import dev.eagerlib.api.KeyOption;
import dev.eagerlib.api.NumberOption;
import dev.eagerlib.api.Section;

public final class CrossbowTags implements EagerLibPlugin {
	public static final String MOD_ID = "crossbow_tags";

	public static BoolOption ENABLED;
	public static BoolOption IN_HOTBAR;
	public static BoolOption IN_INVENTORIES;
	public static ColorOption PIERCING_COLOR;
	public static ColorOption MULTISHOT_COLOR;
	public static BoolOption FLASHING;
	public static NumberOption FLASH_PERIOD;
	public static NumberOption MIN_ALPHA;
	public static NumberOption MAX_ALPHA;
	public static KeyOption TOGGLE_KEY;

	@Override
	public void register(EagerRegistry registry) {
		EagerMod.Builder mod = registry.mod(MOD_ID)
			.name("Crossbow Tags")
			.description("Flashing light-green (Piercing) and light-red (Multishot) backgrounds behind your crossbows.")
			.icon("assets/crossbow_tags/icon.png")
			.changelog("1.1.0", "2026-11-26",
				"Settings now live in the EagerLib menu (Right Shift, or Mod Menu)",
				"New toggle key bind and separate hotbar / inventory switches")
			.changelog("1.0.0", "2026-11-26",
				"Flashing light-green background behind Piercing crossbows",
				"Flashing light-red background behind Multishot crossbows");

		Section general = mod.section("General");
		ENABLED = general.toggle("enabled", "Mod Enabled", true);
		IN_HOTBAR = general.toggle("in_hotbar", "Show in Hotbar", true);
		IN_INVENTORIES = general.toggle("in_inventories", "Show in Inventories", true)
			.describe("Chests, your inventory and every other container screen.");
		TOGGLE_KEY = general.keybind("toggle_key", "Toggle Highlights", KeyOption.NONE);
		TOGGLE_KEY.onPress(() -> ENABLED.toggle());

		Section colours = mod.section("Colours");
		PIERCING_COLOR = colours.color("piercing_color", "Piercing", 0x8CFF8C);
		MULTISHOT_COLOR = colours.color("multishot_color", "Multishot", 0xFF8C8C);

		Section flash = mod.section("Flashing");
		FLASHING = flash.toggle("flashing", "Flashing", true).describe("Turn off for a steady background.");
		FLASH_PERIOD = flash.slider("flash_period_ms", "Flash Speed", 1000, 200, 3000, 50).suffix(" ms")
			.describe("Time for one full dim-bright-dim cycle.");
		FLASH_PERIOD.visibleWhen(() -> FLASHING.get());
		MIN_ALPHA = flash.slider("min_alpha", "Dimmest", 60, 0, 255, 1);
		MIN_ALPHA.visibleWhen(() -> FLASHING.get());
		MAX_ALPHA = flash.slider("max_alpha", "Brightest", 210, 0, 255, 1);

		mod.build();
	}
}
