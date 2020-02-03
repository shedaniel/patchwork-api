package com.patchworkmc.mixin.gui;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.keksuccino.rendering.AnimationRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(AnimationRenderer.class)
public class MB {
	@Overwrite
	private <T> List<String> getAnimationResource(String path, Class<T> c) throws URISyntaxException, IllegalArgumentException {
		if (path.equals("keksuccino/animations/mainmenu_start")) {
			List<String> strings = new ArrayList<>();

			for (int i = 1; i <= 96; i++) {
				strings.add(path + "/" + i + ".jpg");
			}

			return strings;
		} else if (path.equals("keksuccino/animations/mainmenu_loop")) {
			List<String> strings = new ArrayList<>();

			for (int i = 97; i <= 210; i++) {
				strings.add(path + "/" + i + ".jpg");
			}

			return strings;
		}

		return Collections.emptyList();
	}
}
