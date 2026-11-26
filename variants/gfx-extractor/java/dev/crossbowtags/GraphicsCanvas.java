package dev.crossbowtags;

import net.minecraft.client.gui.GuiGraphicsExtractor;

public final class GraphicsCanvas implements Canvas {
	private final GuiGraphicsExtractor g;

	public GraphicsCanvas(GuiGraphicsExtractor g) { this.g = g; }

	@Override public void fill(int x1, int y1, int x2, int y2, int argb) { g.fill(x1, y1, x2, y2, argb); }
}
