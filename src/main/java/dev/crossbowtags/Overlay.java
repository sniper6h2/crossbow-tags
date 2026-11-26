package dev.crossbowtags;

import dev.eagerlib.platform.Platform;

public final class Overlay {
	private Overlay() {}

	public static void slotBackground(Canvas canvas, CrossbowKind kind, int x, int y) {
		if (kind == CrossbowKind.NONE || CrossbowTags.ENABLED == null || !CrossbowTags.ENABLED.get()) return;
		boolean inScreen = Platform.screen() != null;
		if (inScreen ? !CrossbowTags.IN_INVENTORIES.get() : !CrossbowTags.IN_HOTBAR.get()) return;
		int rgb = (kind == CrossbowKind.PIERCING ? CrossbowTags.PIERCING_COLOR.get() : CrossbowTags.MULTISHOT_COLOR.get()) & 0xFFFFFF;
		canvas.fill(x, y, x + 16, y + 16, (alpha() << 24) | rgb);
	}

	private static int alpha() {
		int min = CrossbowTags.MIN_ALPHA.getInt();
		int max = CrossbowTags.MAX_ALPHA.getInt();
		if (min > max) {
			int t = min;
			min = max;
			max = t;
		}
		int period = CrossbowTags.FLASH_PERIOD.getInt();
		if (!CrossbowTags.FLASHING.get() || period <= 0) return max;
		long ms = System.nanoTime() / 1_000_000L;
		double phase = (ms % period) / (double) period;
		double wave = 0.5 - 0.5 * Math.cos(phase * 2.0 * Math.PI);
		return min + (int) Math.round((max - min) * wave);
	}
}
