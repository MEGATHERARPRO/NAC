package eu.nac.check;

import eu.nac.data.PlayerData;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckManager {
    @Getter private final List<Check> checks = new ArrayList<>();

    private final Class<?>[] classes = {

    };

    public CheckManager(final PlayerData data) {
        Arrays.stream(classes).forEach(clazz -> { try { checks.add((Check) clazz.getDeclaredConstructors()[0].newInstance(data)); } catch (final Exception e) { System.out.println("Failed to instantiate class " + clazz.getSimpleName()); e.printStackTrace(); } });
    }
}
