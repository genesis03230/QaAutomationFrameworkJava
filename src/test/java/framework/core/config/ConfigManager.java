package framework.core.config;

import framework.core.driver.BrowserType;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigManager {
    private ConfigManager() {}

    private static final Properties properties = new Properties();
    private static boolean initialized = false;

    public static void init() {
        if (initialized) return;

        try (InputStream input = ConfigManager.class.getClassLoader()
                .getResourceAsStream("config/framework.properties")) {

            if (input == null) {
                throw new IllegalStateException("No se encontró config/framework.properties en test resources.");
            }

            properties.load(input);
            initialized = true;

        } catch (IOException e) {
            throw new RuntimeException("Error cargando framework.properties", e);
        }
    }

    private static String get(String key) {
        init();

        // Permite override por -Dkey=value en Maven/CI
        String sys = System.getProperty(key);
        if (sys != null && !sys.isBlank()) return sys;

        String value = properties.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Falta propiedad requerida: " + key);
        }
        return value.trim();
    }

    public static String getBaseUrl() {
        return get("baseUrl");
    }

    public static BrowserType getBrowser() {
        return BrowserType.valueOf(get("browser").toUpperCase());
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(get("headless"));
    }

    public static long getImplicitWaitSeconds() {
        return Long.parseLong(get("implicitWaitSeconds"));
    }

    public static long getExplicitWaitSeconds() {
        return Long.parseLong(get("explicitWaitSeconds"));
    }

    public static long getPageLoadTimeoutSeconds() {
        return Long.parseLong(get("pageLoadTimeoutSeconds"));
    }
}
