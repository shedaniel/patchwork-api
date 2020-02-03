package com.patchworkmc.mixin.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import de.keksuccino.rendering.RenderUtils;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(RenderUtils.class)
public class MA {
	@Overwrite
	public static void setScale(float scale) {
		GL11.glPushMatrix();
		GlStateManager.enableBlend();
		GL11.glPushMatrix();
		GL11.glScaled(scale, scale, scale);
	}

	@Overwrite
	public static void postScale() {
		GL11.glPopMatrix();
		GlStateManager.disableBlend();
		GL11.glPopMatrix();
	}
}
