package org.cyclops.everlastingabilitiespotioncore.ability.config;

import com.tmtravlr.potioncore.potion.PotionArchery;
import net.minecraft.item.EnumRarity;
import org.cyclops.cyclopscore.config.ConfigurableProperty;
import org.cyclops.cyclopscore.config.ConfigurableTypeCategory;
import org.cyclops.cyclopscore.config.configurable.IConfigurable;
import org.cyclops.everlastingabilities.ability.AbilityTypePotionEffectSelf;
import org.cyclops.everlastingabilities.core.config.extendedconfig.AbilityConfig;

/**
 * Config for an ability.
 * @author rubensworks
 *
 */
public class AbilityArcheryConfig extends AbilityConfig {

    /**
     * Rarity of this ability.
     */
    @ConfigurableProperty(category = ConfigurableTypeCategory.GENERAL, categoryRaw = "ability", comment = "Rarity of this ability.", requiresMcRestart = true)
    public static int rarity = EnumRarity.UNCOMMON.ordinal();
    /**
     * The maximum ability level.
     */
    @ConfigurableProperty(category = ConfigurableTypeCategory.GENERAL, categoryRaw = "ability", comment = "The maximum ability level.", requiresMcRestart = true)
    public static int maxLevel = 5;
    /**
     * The xp required per level.
     */
    @ConfigurableProperty(category = ConfigurableTypeCategory.GENERAL, categoryRaw = "ability", comment = "The xp required per level.", requiresMcRestart = true)
    public static int xpPerLevel = 20;

    /**
     * The unique instance.
     */
    public static AbilityConfig _instance;

    /**
     * Make a new instance.
     */
    public AbilityArcheryConfig() {
        super(
                true,
                "archery",
                "See in the dark"
        );
    }

    @Override
    protected IConfigurable initSubInstance() {
        return new AbilityTypePotionEffectSelf(getNamedId(), rarity, maxLevel, xpPerLevel, PotionArchery.INSTANCE);
    }
}
