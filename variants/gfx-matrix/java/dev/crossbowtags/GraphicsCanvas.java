package dev.crossbowtags;

import net.minecraft.client.gui.GuiGraphics;

public final class GraphicsCanvas implements Canvas {
	private final GuiGraphics g;

	public GraphicsCanvas(GuiGraphics g) { this.g = g; }

	@Override public void fill(int x1, int y1, int x2, int y2, int argb) { g.fill(x1, y1, x2, y2, argb); }
}
