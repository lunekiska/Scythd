package eu.lunekiska.scythd.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ScythesConfig
{
    public static ForgeConfigSpec.BooleanValue atomic_scythe;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
    {
        server.comment("ScythesConfig");

        atomic_scythe = server
                .comment("IsAtomicDisassemblerUsingScythe")
                .define("atomic_scythe", true);
    }
}
