package org.cyclops.everlastingabilitiespotioncore;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import org.apache.logging.log4j.Level;
import org.cyclops.cyclopscore.config.ConfigHandler;
import org.cyclops.cyclopscore.init.ModBaseVersionable;
import org.cyclops.cyclopscore.init.RecipeHandler;
import org.cyclops.cyclopscore.proxy.ICommonProxy;
import org.cyclops.everlastingabilitiespotioncore.ability.config.*;

/**
 * The main mod class of this mod.
 * @author rubensworks (aka kroeserr)
 *
 */
@Mod(
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        useMetadata = true,
        version = Reference.MOD_VERSION,
        dependencies = Reference.MOD_DEPENDENCIES,
        guiFactory = "org.cyclops.everlastingabilitiespotioncore.GuiConfigOverview$ExtendedConfigGuiFactory",
        certificateFingerprint = Reference.MOD_FINGERPRINT
)
public class EverlastingAbilitiesPotionCore extends ModBaseVersionable {
    
    /**
     * The proxy of this mod, depending on 'side' a different proxy will be inside this field.
     * @see SidedProxy
     */
    @SidedProxy(clientSide = "org.cyclops.everlastingabilitiespotioncore.proxy.ClientProxy", serverSide = "org.cyclops.everlastingabilitiespotioncore.proxy.CommonProxy")
    public static ICommonProxy proxy;
    
    /**
     * The unique instance of this mod.
     */
    @Instance(value = Reference.MOD_ID)
    public static EverlastingAbilitiesPotionCore _instance;

    public EverlastingAbilitiesPotionCore() {
        super(Reference.MOD_ID, Reference.MOD_NAME, Reference.MOD_VERSION);
    }

    @Override
    protected RecipeHandler constructRecipeHandler() {
        return new RecipeHandler(this);
    }

    /**
     * The pre-initialization, will register required configs.
     * @param event The Forge event required for this.
     */
    @EventHandler
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }
    
    /**
     * Register the config dependent things like world generation and proxy handlers.
     * @param event The Forge event required for this.
     */
    @EventHandler
    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }
    
    /**
     * Register the event hooks.
     * @param event The Forge event required for this.
     */
    @EventHandler
    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
    
    /**
     * Register the things that are related to server starting, like commands.
     * @param event The Forge event required for this.
     */
    @EventHandler
    @Override
    public void onServerStarting(FMLServerStartingEvent event) {
        super.onServerStarting(event);
    }

    /**
     * Register the things that are related to server starting.
     * @param event The Forge event required for this.
     */
    @EventHandler
    @Override
    public void onServerStarted(FMLServerStartedEvent event) {
        super.onServerStarted(event);
    }

    /**
     * Register the things that are related to server stopping, like persistent storage.
     * @param event The Forge event required for this.
     */
    @EventHandler
    @Override
    public void onServerStopping(FMLServerStoppingEvent event) {
        super.onServerStopping(event);
    }

    @Override
    public CreativeTabs constructDefaultCreativeTab() {
        // Uncomment the following line and specify an item config class to add a creative tab
        // return new ItemCreativeTab(this, new ItemConfigReference(ITEM CONFIG CLASS));
        return null;
    }

    @Override
    public void onGeneralConfigsRegister(ConfigHandler configHandler) {
        configHandler.add(new GeneralConfig());
    }

    @Override
    public void onMainConfigsRegister(ConfigHandler configHandler) {
        super.onMainConfigsRegister(configHandler);

        configHandler.add(new AbilityArcheryConfig());
        configHandler.add(new AbilityDrownConfig());
        configHandler.add(new AbilityAntidoteConfig());
        configHandler.add(new AbilityPurityConfig());
        configHandler.add(new AbilitySlowFallConfig());
        configHandler.add(new AbilitySolidCoreConfig());
        configHandler.add(new AbilityClimbConfig());
        configHandler.add(new AbilityReachConfig());
        configHandler.add(new AbilityIronSkinConfig());
        configHandler.add(new AbilityDiamondSkinConfig());
        configHandler.add(new AbilityRecoilConfig());
        configHandler.add(new AbilityMagicFocusConfig());
        configHandler.add(new AbilityMagicShieldingConfig());
        configHandler.add(new AbilityRevivalConfig());
        configHandler.add(new AbilityRepairConfig());
        configHandler.add(new AbilityExtensionConfig());
        configHandler.add(new AbilityBlessConfig());
        configHandler.add(new AbilityCureConfig());

        configHandler.add(new AbilityBrokenArmorConfig());
        configHandler.add(new AbilityWeightConfig());
        configHandler.add(new AbilityKlutzConfig());
        configHandler.add(new AbilityInvertConfig());
        configHandler.add(new AbilityVulnerableConfig());
        configHandler.add(new AbilityMagicInhibitionConfig());
        configHandler.add(new AbilityExplosionConfig());
        configHandler.add(new AbilityCombustionConfig());
        configHandler.add(new AbilityLightningConfig());
        configHandler.add(new AbilityLaunchConfig());
        configHandler.add(new AbilityCorrosionConfig());
        configHandler.add(new AbilityDisorganizationConfig());
        configHandler.add(new AbilityPerplexityConfig());
        configHandler.add(new AbilityCurseConfig());
        configHandler.add(new AbilityDispelConfig());
    }

    @Override
    public ICommonProxy getProxy() {
        return proxy;
    }

    /**
     * Log a new info message for this mod.
     * @param message The message to show.
     */
    public static void clog(String message) {
        clog(Level.INFO, message);
    }
    
    /**
     * Log a new message of the given level for this mod.
     * @param level The level in which the message must be shown.
     * @param message The message to show.
     */
    public static void clog(Level level, String message) {
        EverlastingAbilitiesPotionCore._instance.getLoggerHelper().log(level, message);
    }
    
}
