package org.cyclops.everlastingabilitiespotioncore.proxy;

import org.cyclops.cyclopscore.init.ModBase;
import org.cyclops.cyclopscore.proxy.CommonProxyComponent;
import org.cyclops.everlastingabilitiespotioncore.EverlastingAbilitiesPotionCore;

/**
 * Proxy for server and client side.
 * @author rubensworks
 *
 */
public class CommonProxy extends CommonProxyComponent {

    @Override
    public ModBase getMod() {
        return EverlastingAbilitiesPotionCore._instance;
    }

}
