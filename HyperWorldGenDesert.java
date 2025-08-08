package com.hyperworldgen.world.biome.desert;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.OverworldBiomes;
import net.minecraft.world.level.biome.Biome.BiomeBuilder;

import java.util.function.Consumer;

public class HyperWorldGenDesert {
    public static final ResourceKey<Biome> DRY_SPINES = register("dry_spines");
    public static final ResourceKey<Biome> CHARRED_HOLLOW = register("charred_hollow");
    public static final ResourceKey<Biome> ASHEN_LOWLANDS = register("ashen_lowlands");
    public static final ResourceKey<Biome> SCORCHTRAIL_DUNES = register("scorchtrail_dunes");
    public static final ResourceKey<Biome> BURNING_SHARDLANDS = register("burning_shardlands");
    public static final ResourceKey<Biome> BLISTERED_WASTES = register("blistered_wastes");
    public static final ResourceKey<Biome> CRACKED_BONEFIELD = register("cracked_bonefield");
    public static final ResourceKey<Biome> OBSIDIAN_RIDGES = register("obsidian_ridges");
    public static final ResourceKey<Biome> DRYROOT_VALLEY = register("dryroot_valley");
    public static final ResourceKey<Biome> TOMB_VALLEY = register("tomb_valley");
    // ... thêm tiếp tới DESERT_30 nếu muốn

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation("yourmodid", name));
    }

    public static void bootstrap(BootstrapContext<Biome> context) {
        context.register(DESERT_11, makeDesertBiome(1));
        context.register(DESERT_12, makeDesertBiome(2));
        context.register(DESERT_13, makeDesertBiome(3));
        context.register(DESERT_14, makeDesertBiome(4));
        context.register(DESERT_15, makeDesertBiome(5));
        context.register(DESERT_16, makeDesertBiome(6));
        context.register(DESERT_17, makeDesertBiome(7));
        context.register(DESERT_18, makeDesertBiome(8));
        context.register(DESERT_19, makeDesertBiome(9));
        context.register(DESERT_20, makeDesertBiome(10));
        // ... đăng ký tiếp nếu có thêm
    }

    private static Biome makeDesertBiome(int index) {
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
            .fogColor(0xE0CDA9)
            .waterColor(0xE3DDB4)
            .waterFogColor(0xD1C59A)
            .skyColor(0xFFD580)
            .build();

        BiomeGenerationSettings generation = new BiomeGenerationSettings.Builder()
            .build();

        MobSpawnSettings spawns = new MobSpawnSettings.Builder()
            .build();

        return new Biome.BiomeBuilder()
            .precipitation(Biome.Precipitation.NONE)
            .temperature(2.0F + (index * 0.02F)) // Nhiệt độ tăng dần
            .downfall(0.0F)
            .specialEffects(effects)
            .mobSpawnSettings(spawns)
            .generationSettings(generation)
            .build();
    }
}
