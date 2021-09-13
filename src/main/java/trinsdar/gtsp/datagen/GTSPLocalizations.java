package trinsdar.gtsp.datagen;


import muramasa.antimatter.datagen.providers.AntimatterLanguageProvider;
import net.minecraft.data.DataGenerator;
import trinsdar.gtsp.Ref;

public class GTSPLocalizations {

    public static class en_US extends AntimatterLanguageProvider {

        public en_US(DataGenerator gen) {
            super(Ref.ID, Ref.NAME + " en_us Localization", "en_us", gen);
        }

        @Override
        protected void addTranslations() {
            super.addTranslations();
        }

        @Override
        protected void processTranslations(String domain, String locale) {
            super.processTranslations(domain, locale);
        }
    }

}
