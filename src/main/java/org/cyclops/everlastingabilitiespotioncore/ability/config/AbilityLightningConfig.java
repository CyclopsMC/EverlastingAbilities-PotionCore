package org.cyclops.everlastingabilitiespotioncore.ability.config;

import com.tmtravlr.potioncore.potion.PotionFire;
import com.tmtravlr.potioncore.potion.PotionLightning;
import net.minecraft.item.EnumRarity;
import org.cyclops.cyclopscore.config.ConfigurableProperty;
import org.cyclops.cyclopscore.config.ConfigurableTypeCategory;
import org.cyclops.cyclopscore.config.configurable.IConfigurable;
import org.cyclops.cyclopscore.helper.MinecraftHelpers;
import org.cyclops.everlastingabilities.ability.AbilityTypePotionEffectRadius;
import org.cyclops.everlastingabilities.core.config.extendedconfig.AbilityConfig;

/**
 * Config for an ability.
 * @author rubensworks
 *
 */
public class AbilityLightningConfig extends AbilityConfig {

    /**
     * Rarity of this ability.
     */
    @ConfigurableProperty(category = ConfigurableTypeCategory.GENERAL, categoryRaw = "ability", comment = "Rarity of this ability.", requiresMcRestart = true)
    public static int rarity = EnumRarity.EPIC.ordinal();
    /**
     * The maximum ability level.
     */
    @ConfigurableProperty(category = ConfigurableTypeCategory.GENERAL, categoryRaw = "ability", comment = "The maximum ability level.", requiresMcRestart = true)
    public static int maxLevel = 5;
    /**
     * The xp required per level.
     */
    @ConfigurableProperty(category = ConfigurableTypeCategory.GENERAL, categoryRaw = "ability", comment = "The xp required per level.", requiresMcRestart = true)
    public static int xpPerLevel = 150;

    /**
     * The unique instance.
     */
    public static AbilityConfig _instance;

    /**
     * Make a new instance.
     */
    public AbilityLightningConfig() {
        super(
                true,
                "lightning",
                "Entities in the area are struck with lightning"
        );
    }

    @Override
    protected IConfigurable initSubInstance() {
        return new AbilityTypePotionEffectRadius(getNamedId(), rarity, maxLevel, xpPerLevel, PotionLightning.INSTANCE, true) {
            @Override
            protected int getDuration(int tickModulus, int level) {
                return MinecraftHelpers.SECOND_IN_TICKS / 10;
            }

            @Override
            protected int getTickModulus(int level) {
                return MinecraftHelpers.SECOND_IN_TICKS * getMaxLevelInfinitySafe() / level;
            }
        };
    }
}
