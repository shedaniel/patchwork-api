/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2019, 2019
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.fml;

import java.util.List;

public class ModList {
	private static ModList INSTANCE;
	private List<String> mods;

	//Patchwork: signature changed to just have a list of modids
	private ModList(List<String> mods) {
		this.mods = mods;
	}

	public static ModList get() {
		return INSTANCE;
	}

	//Patchwork: method does not exist in Forge
	public static ModList create(List<String> mods) {
		INSTANCE = new ModList(mods);
		return INSTANCE;
	}

	public boolean isLoaded(String modId) {
		return this.mods.contains(modId);
	}

}
