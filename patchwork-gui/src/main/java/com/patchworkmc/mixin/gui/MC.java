package com.patchworkmc.mixin.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import de.keksuccino.fancymain.mainscreen.AnimatedMainMenu;
import de.keksuccino.rendering.RenderUtils;
import net.minecraftforge.client.event.GuiScreenEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Mixin(AnimatedMainMenu.class)
public class MC {
	@Shadow
	private static int tickFooter;
	@Shadow
	private static float fadeFooter;
	@Shadow
	@Final
	private static Identifier FACEBOOK;
	@Shadow
	@Final
	private static Identifier TWITTER;
	@Shadow
	@Final
	private static Identifier INSTAGRAM;

	@Overwrite
	private static void renderFooter(GuiScreenEvent.DrawScreenEvent e) {
		if (tickFooter < 30) {
			++tickFooter;
		} else if (e.getGui().height >= 280) {
			int i = MathHelper.ceil(fadeFooter * 255.0F) << 24;
			RenderUtils.setScale(1.1F);
			e.getGui().drawCenteredString(MinecraftClient.getInstance().textRenderer, "§fDISCOVER MORE AT MINECRAFT.NET", (int) ((double) (e.getGui().width / 2) / 1.1D), (int) ((double) (e.getGui().height - 50) / 1.1D), i);
			RenderUtils.postScale();
			MinecraftClient.getInstance().getTextureManager().bindTexture(FACEBOOK);
			GlStateManager.enableBlend();
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			GlStateManager.color4f(1.0F, 1.0F, 1.0F, MathHelper.clamp(fadeFooter, 0.2F, 1.0F));
			InGameHud.blit(e.getGui().width / 2 - 100, e.getGui().height - 35, 0.0F, 0.0F, 15, 15, 15, 15);
			GlStateManager.disableBlend();
			RenderUtils.setScale(0.7F);
			e.getGui().drawString(MinecraftClient.getInstance().textRenderer, "§f/MINECRAFT", (int) ((double) (e.getGui().width / 2 - 80) / 0.7D), (int) ((double) (e.getGui().height - 30) / 0.7D), i);
			RenderUtils.postScale();
			MinecraftClient.getInstance().getTextureManager().bindTexture(TWITTER);
			GlStateManager.enableBlend();
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			GlStateManager.color4f(1.0F, 1.0F, 1.0F, MathHelper.clamp(fadeFooter, 0.2F, 1.0F));
			InGameHud.blit(e.getGui().width / 2 - 30, e.getGui().height - 35, 0.0F, 0.0F, 15, 15, 15, 15);
			GlStateManager.disableBlend();
			RenderUtils.setScale(0.7F);
			e.getGui().drawString(MinecraftClient.getInstance().textRenderer, "§f@MINECRAFT", (int) ((double) (e.getGui().width / 2 - 10) / 0.7D), (int) ((double) (e.getGui().height - 30) / 0.7D), i);
			RenderUtils.postScale();
			MinecraftClient.getInstance().getTextureManager().bindTexture(INSTAGRAM);
			GlStateManager.enableBlend();
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			GlStateManager.color4f(1.0F, 1.0F, 1.0F, MathHelper.clamp(fadeFooter, 0.2F, 1.0F));
			InGameHud.blit(e.getGui().width / 2 + 40, e.getGui().height - 35, 0.0F, 0.0F, 15, 15, 15, 15);
			GlStateManager.disableBlend();
			RenderUtils.setScale(0.7F);
			e.getGui().drawString(MinecraftClient.getInstance().textRenderer, "§fMINECRAFT", (int) ((double) (e.getGui().width / 2 + 60) / 0.7D), (int) ((double) (e.getGui().height - 30) / 0.7D), i);
			RenderUtils.postScale();

			if (fadeFooter < 1.0F) {
				fadeFooter += 0.005F;
			}
		}

	}
}
