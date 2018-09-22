/*
 * This file is part of World Downloader: A mod to make backups of your
 * multiplayer worlds.
 * http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/2520465
 *
 * Copyright (c) 2014 nairol, cubic72
 * Copyright (c) 2018 Pokechu22, julialy
 *
 * This project is licensed under the MMPLv2.  The full text of the MMPL can be
 * found in LICENSE.md, or online at https://github.com/iopleke/MMPLv2/blob/master/LICENSE.md
 * For information about this the MMPLv2, see http://stopmodreposts.org/
 *
 * Do not redistribute (in modified or unmodified form) without prior permission.
 */
package wdl.versioned;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraft.util.text.TextComponentString;

/**
 * Functions that help deal with things that vary in type between versions.
 */
class TypeFunctions {
	/* (non-javadoc)
	 * @see VersionedFunctions#getChunkListClass
	 */
	@SuppressWarnings("rawtypes")
	static Class<Long2ObjectMap> getChunkListClass() {
		return Long2ObjectMap.class;
	}

	/* (non-javadoc)
	 * @see VersionedFunctions#getChunksToSaveClass
	 */
	@SuppressWarnings("rawtypes")
	static Class<Object2ObjectMap> getChunksToSaveClass() {
		return Object2ObjectMap.class;
	}

	/* (non-javadoc)
	 * @see VersionedFunctions#customName
	 */
	static TextComponentString customName(String name) {
		return new TextComponentString(name);
	}
}
