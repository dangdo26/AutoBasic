package constant;

import helpers.PropertiesHelper;

public class ConstantGlobal {
    static {
        PropertiesHelper.loadAllFiles();
    }


    public static final Boolean HEADLESS = Boolean.parseBoolean(PropertiesHelper.getValue("headless"));

    public static  final String ENVIRONMENT = PropertiesHelper.getValue("environment");
    public static  final String BROWSER = PropertiesHelper.getValue("browser");
}
