package RacingManager.database;

import RacingManager.business.Circuito.Circuito;
import RacingManager.business.Circuito.SectoresCircuito;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class CircuitoDAO implements Map<String , Circuito> {

    private static CircuitoDAO singleton = null;

    public static CircuitoDAO getInstance() {

        if (CircuitoDAO.singleton == null) CircuitoDAO.singleton = new CircuitoDAO();
        return CircuitoDAO.singleton;

    }

    private static Map<String,Circuito> circuitos=Map.of(
            "Nurburing",new Circuito("Nurburing",20,4, new ArrayList<SectoresCircuito>(Arrays.asList(
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.75F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CHICANE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.2F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.5F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CHICANE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.05F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.6F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.8F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F)
            ))),
            "Monaco",new Circuito("Monaco",7.004F,44,new ArrayList<SectoresCircuito>(Arrays.asList(
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.5F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.2F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.2F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.5F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.05F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.6F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.8F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CURVE, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.STRAIGHT, 0.15F),
                    new SectoresCircuito(SectoresCircuito.CircuitSectionType.CHICANE,0.2F)
            )))
    );
    public static List<Circuito> getCircuitos() {
  return circuitos.values().stream().toList();
    }
    @Override
    public int size() {
        return circuitos.size();
    }

    @Override
    public boolean isEmpty() {
        return circuitos.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return circuitos.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return circuitos.containsValue(value);
    }

    @Override
    public Circuito get(Object key) {
        return circuitos.get(key);
    }

    @Override
    public Circuito put(String key, Circuito value) {
        return null;
    }


    @Override
    public Circuito remove(Object key) {
        return circuitos.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends Circuito> m) {

    }


    @Override
    public void clear() {
        circuitos.clear();
    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Circuito> values() {
        return null;
    }

    @Override
    public Set<Entry<String, Circuito>> entrySet() {
        return null;
    }


    @Override
    public Circuito getOrDefault(Object key, Circuito defaultValue) {
        return Map.super.getOrDefault(key, defaultValue);
    }

    @Override
    public void forEach(BiConsumer<? super String, ? super Circuito> action) {
        Map.super.forEach(action);
    }

    @Override
    public void replaceAll(BiFunction<? super String, ? super Circuito, ? extends Circuito> function) {
        Map.super.replaceAll(function);
    }

    @Override
    public Circuito putIfAbsent(String key, Circuito value) {
        return Map.super.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return Map.super.remove(key, value);
    }

    @Override
    public boolean replace(String key, Circuito oldValue, Circuito newValue) {
        return Map.super.replace(key, oldValue, newValue);
    }

    @Override
    public Circuito replace(String key, Circuito value) {
        return Map.super.replace(key, value);
    }

    @Override
    public Circuito computeIfAbsent(String key, Function<? super String, ? extends Circuito> mappingFunction) {
        return Map.super.computeIfAbsent(key, mappingFunction);
    }

    @Override
    public Circuito computeIfPresent(String key, BiFunction<? super String, ? super Circuito, ? extends Circuito> remappingFunction) {
        return Map.super.computeIfPresent(key, remappingFunction);
    }

    @Override
    public Circuito compute(String key, BiFunction<? super String, ? super Circuito, ? extends Circuito> remappingFunction) {
        return Map.super.compute(key, remappingFunction);
    }

    @Override
    public Circuito merge(String key, Circuito value, BiFunction<? super Circuito, ? super Circuito, ? extends Circuito> remappingFunction) {
        return Map.super.merge(key, value, remappingFunction);
    }
}