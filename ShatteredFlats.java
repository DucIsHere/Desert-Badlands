package com.hypergen.biomes.desert;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeatures;
import net.minecraft.world.level.levelgen.placement.PlacedFeatures;

public class ShatteredFlats {

    public static final ResourceKey<Biome> SHATTERED_FLATS = ResourceKey.create(
            Registries.BIOME,
            new ResourceLocation("hypergen", "shattered_flats")
    );

    public static Biome create() {
        BiomeGenerationSettings.Builder generation = new BiomeGenerationSettings.Builder();

        // Structures
        generation.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, PlacedFeatures.DESERT_WELL);
        // Nếu có structure riêng như "buried_crate", dùng custom placed feature ở đây

        // Surface features (dead bushes)
        generation.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacedFeatures.DEAD_BUSH);

        // Mob spawn
        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();
        spawns.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 80, 2, 4));
        spawns.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 20, 1, 2));
        // Add custom entity spawn (e.g., ScorpionEntity) nếu đã đăng ký

        // Biome Special Effects
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(0xC9B47C) // màu sương sa mạc
                .waterColor(0xE0D9AF)
                .waterFogColor(0xD4C896)
                .skyColor(0xEBDCA5)
                .grassColorOverride(0xA97F4D)
                .foliageColorOverride(0x9E7C4B)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .build();

        // Climate
        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE)
                .temperature(2.75f)  // nhiệt độ ban ngày (có thể giảm vào ban đêm bằng weather override)
                .downfall(0.0f)      // không mưa
                .temperatureAdjustment(Biome.TemperatureModifier.NONE)
                .specialEffects(effects)
                .mobSpawnSettings(spawns.build())
                .generationSettings(generation.build())
                .build();
    }
}
