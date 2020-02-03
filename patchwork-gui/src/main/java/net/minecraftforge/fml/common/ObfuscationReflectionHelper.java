package net.minecraftforge.fml.common;

import java.lang.reflect.Field;

public class ObfuscationReflectionHelper {
	public static Field findField(Class clazz, String name) {
		try {
			switch (name) {
			case "field_209101_K":
				return clazz.getDeclaredField("backgroundRenderer");
			case "field_73975_c":
				return clazz.getDeclaredField("splashText");
			case "field_213099_c":
				return clazz.getDeclaredField("PANORAMA_OVERLAY");
			case "field_110352_y":
				return clazz.getDeclaredField("MINECRAFT_TITLE_TEXTURE");
			case "field_194400_H":
				return clazz.getDeclaredField("EDITION_TITLE_TEXTURE");
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		return null;
	}
}
