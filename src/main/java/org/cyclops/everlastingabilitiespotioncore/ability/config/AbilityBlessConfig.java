package org.cyclops.everlastingabilitiespotioncore.ability.config;

import com.tmtravlr.potioncore.potion.PotionBless;
import net.minecraft.item.EnumRarity;
import org.cyclops.cyclopscore.config.ConfigurableProperty;
import org.cyclops.cyclopscore.config.ConfigurableTypeCategory;
import org.cyclops.cyclopscore.config.configurable.IConfigurable;
import org.cyclops.cyclopscore.helper.MinecraftHelpers;
import org.cyclops.everlastingabilities.ability.AbilityTypePotionEffectSelf;
import org.cyclops.everlastingabilities.core.config.extendedconfig.AbilityConfig;

/**
 * Config for an ability.
 * @author rubensworks
 *
 */
public class AbilityBlessConfig extends AbilityConfig {

    /**
     * Rarity of this ability.
     */
    @ConfigurableProperty(category = ConfigurableTypeCategory.GENERAL, categoryRaw = "ability", comment = "Rarity of this ability.", requiresMcRestart = true)
    public static int rarity = EnumRarity.COMMON.ordinal();
    /**
     * The maximum ability level.
     */
    @ConfigurableProperty(category = ConfigurableTypeCategory.GENERAL, categoryRaw = "ability", comment = "The maximum ability level.", requiresMcRestart = true)
    public static int maxLevel = 6;
    /**
     * The xp required per level.
     */
    @ConfigurableProperty(category = ConfigurableTypeCategory.GENERAL, categoryRaw = "ability", comment = "The xp required per level.", requiresMcRestart = true)
    public static int xpPerLevel = 25;
    /**
     * The basis tick delay after which this ability should apply. This is divided by the active level.
     */
    @ConfigurableProperty(category = ConfigurableTypeCategory.GENERAL, categoryRaw = "ability", comment = "The basis tick delay after which this ability should apply. This is divided by the active level.", requiresMcRestart = true)
    public static int baseTickDelay = MinecraftHelpers.SECOND_IN_TICKS * 10;

    /**
     * The unique instance.
     */
    public static AbilityConfig _instance;

    /**
     * Make a new instance.
     */
    public AbilityBlessConfig() {
        super(
                false,
                "bless",
                "Gives a random positive potion effect"
        );
    }

    @Override
    protected IConfigurable initSubInstance() {
        return new AbilityTypePotionEffectSelf(getNamedId(), rarity, maxLevel, xpPerLevel, PotionBless.INSTANCE){
            @Override
            protected int getDuration(int tickModulus, int level) {
                return 1;
            }

            @Override
            protected int getTickModulus(int level) {
                return AbilityBlessConfig.baseTickDelay * getMaxLevelInfinitySafe() / level;
            }

            @Override
            protected int getAmplifier(int level) {
                return 0;
            }
        };
    }
}
