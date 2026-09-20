package com.logistics;

import com.logistics.app.DeliveryApplication;
import com.logistics.log.Logistics;
import com.logistics.log.RoadLogistics;
import com.logistics.log.SeaLogistics;
import com.logistics.ui.GUIFactory;
import com.logistics.ui.MacOSFactory;
import com.logistics.ui.WindowsFactory;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Error: Missing required configuration parameters.");
            System.err.println("Usage: java Main <ROAD|SEA> <WINDOWS|MACOS>");
            return;
        }

        String modeArg = args[0].toUpperCase();
        String platformArg = args[1].toUpperCase();

        Logistics logistics = selectLogistics(modeArg);
        GUIFactory factory = selectGUIFactory(platformArg);

        if (logistics == null || factory == null) {
            System.err.println("Error: Initialization failed due to invalid arguments.");
            return;
        }

        System.out.println("Delivery mode: " + modeArg);
        System.out.println("UI platform: " + platformArg);

        DeliveryApplication app = new DeliveryApplication(factory, logistics);
        app.run("laboratory equipment", "Aktau warehouse");
    }

    private static Logistics selectLogistics(String mode) {
        return switch (mode) {
            case "ROAD" -> new RoadLogistics();
            case "SEA" -> new SeaLogistics();
            default -> {
                System.err.println("Error: Unsupported delivery mode '" + mode + "'. Expected ROAD or SEA.");
                yield null;
            }
        };
    }

    private static GUIFactory selectGUIFactory(String platform) {
        return switch (platform) {
            case "WINDOWS" -> new WindowsFactory();
            case "MACOS" -> new MacOSFactory();
            default -> {
                System.err.println("Error: Unsupported UI platform '" + platform + "'. Expected WINDOWS or MACOS.");
                yield null;
            }
        };
    }
}