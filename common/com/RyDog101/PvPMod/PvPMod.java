/**
 * PvP-Mod
 * 
 * PvPMod
 * 
 * @author Ry_dog101
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
package com.RyDog101.PvPMod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.RyDog101.PvPMod.entity.monster.EntityHerobrine;
import com.RyDog101.PvPMod.entity.monster.EntityNotch;
import com.RyDog101.PvPMod.entity.monster.EntitySteve;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid = "PvPMod", name = "PvP-Mod", version = "2.3" )
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class PvPMod {
	
	static int startEntityId = 300;
	
	@Init
	public void load(FMLInitializationEvent event){
		/*
		 * Mob Registry
		 */
		EntityRegistry.registerModEntity(EntitySteve.class, "Steve", 1, this, 80, 3, true);
		EntityRegistry.registerModEntity(EntityNotch.class, "Notch", 2, this, 80, 3, true);
		EntityRegistry.registerModEntity(EntityHerobrine.class, "Herobrine", 3, this, 80, 3, true);
		
		/*
		 * Spawning
		 */
		EntityRegistry.addSpawn(EntitySteve.class, 10, 2, 4, EnumCreatureType.monster, 
				BiomeGenBase.beach,
				BiomeGenBase.desert,
				BiomeGenBase.desertHills,
				BiomeGenBase.extremeHills,
				BiomeGenBase.extremeHillsEdge,
				BiomeGenBase.forest,
				BiomeGenBase.forestHills,
				BiomeGenBase.hell,
				BiomeGenBase.jungle,
				BiomeGenBase.jungleHills,
				BiomeGenBase.mushroomIsland,
				BiomeGenBase.mushroomIslandShore,
				BiomeGenBase.plains,
				BiomeGenBase.sky,
				BiomeGenBase.swampland,
				BiomeGenBase.taiga,
				BiomeGenBase.taigaHills);
		EntityRegistry.addSpawn(EntityNotch.class, 10, 2, 4, EnumCreatureType.monster, 
                BiomeGenBase.beach,
                BiomeGenBase.desert,
                BiomeGenBase.desertHills,
                BiomeGenBase.extremeHills,
                BiomeGenBase.extremeHillsEdge,
                BiomeGenBase.forest,
                BiomeGenBase.forestHills,
                BiomeGenBase.hell,
                BiomeGenBase.jungle,
                BiomeGenBase.jungleHills,
                BiomeGenBase.mushroomIsland,
                BiomeGenBase.mushroomIslandShore,
                BiomeGenBase.plains,
                BiomeGenBase.sky,
                BiomeGenBase.swampland,
                BiomeGenBase.taiga,
                BiomeGenBase.taigaHills);
		EntityRegistry.addSpawn(EntityHerobrine.class, 10, 2, 4, EnumCreatureType.monster, 
                BiomeGenBase.beach,
                BiomeGenBase.desert,
                BiomeGenBase.desertHills,
                BiomeGenBase.extremeHills,
                BiomeGenBase.extremeHillsEdge,
                BiomeGenBase.forest,
                BiomeGenBase.forestHills,
                BiomeGenBase.hell,
                BiomeGenBase.jungle,
                BiomeGenBase.jungleHills,
                BiomeGenBase.mushroomIsland,
                BiomeGenBase.mushroomIslandShore,
                BiomeGenBase.plains,
                BiomeGenBase.sky,
                BiomeGenBase.swampland,
                BiomeGenBase.taiga,
                BiomeGenBase.taigaHills);
		
		/*
		 * Language Fix
		 */
		LanguageRegistry.instance().addStringLocalization("entity.PvPMod.Steve.name", "Steve");
		LanguageRegistry.instance().addStringLocalization("entity.PvPMod.Notch.name", "Notch");
		LanguageRegistry.instance().addStringLocalization("entity.PvPMod.Herobrine.name", "Herobrine");
		
		/*
		 * Spawn egg and colour
		 */
		registerEntityEgg(EntitySteve.class, 0x6F9DD1, 0x7AD16F);
		registerEntityEgg(EntityNotch.class, 0xFA3E19 , 0xFA9C19);
		registerEntityEgg(EntityHerobrine.class, 0x6F9DD1 , 0xFFFFFF);
	}
	
	public static int getUniqueEntityId()
	{
		do
		{
			startEntityId++;
		}
		while(EntityList.getStringFromID(startEntityId) != null);
		
		return startEntityId;
	}
		
	public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor)
	{
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
}
