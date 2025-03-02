package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumService {

    private static AppiumDriverLocalService service;

    public static void startService(String portNumber) {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(Integer.parseInt(portNumber));
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        System.out.println("portNumber " + portNumber);
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }
}
