package RacingManager.database;

import RacingManager.business.Carro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class CarroDAO implements Map<String, Carro> {

    private static CarroDAO singleton = null;

    private CarroDAO() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS carro (" +
                    " idCarro varchar(10) NOT NULL PRIMARY KEY," +
                    "marca varchar(45) DEFAULT NULL," +
                    "modelo varchar(45) DEFAULT NULL)" +
                    "cilindrada int(4) DEFAULT 0" +
                    "potencia int(4) DEFAULT 0" +
                    "potenciaEletrica int(4) DEFAULT 0" +
                    "serHibrido BIT(2)" +
                    "pac FLOAT(2,2)";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    public static CarroDAO getInstance() {
        if (CarroDAO.singleton == null) {
            CarroDAO.singleton = new CarroDAO();
        }
        return CarroDAO.singleton;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Carro get(Object key) {
        return null;
    }

    @Override
    public Carro put(String key, Carro value) {
        return null;
    }

    @Override
    public Carro remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Carro> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Carro> values() {
        return null;
    }

    @Override
    public Set<Entry<String, Carro>> entrySet() {
        return null;
    }

    @Override
    public Carro getOrDefault(Object key, Carro defaultValue) {
        return Map.super.getOrDefault(key, defaultValue);
    }

    @Override
    public void forEach(BiConsumer<? super String, ? super Carro> action) {
        Map.super.forEach(action);
    }

    @Override
    public void replaceAll(BiFunction<? super String, ? super Carro, ? extends Carro> function) {
        Map.super.replaceAll(function);
    }

    @Override
    public Carro putIfAbsent(String key, Carro value) {
        return Map.super.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return Map.super.remove(key, value);
    }

    @Override
    public boolean replace(String key, Carro oldValue, Carro newValue) {
        return Map.super.replace(key, oldValue, newValue);
    }

    @Override
    public Carro replace(String key, Carro value) {
        return Map.super.replace(key, value);
    }

    @Override
    public Carro computeIfAbsent(String key, Function<? super String, ? extends Carro> mappingFunction) {
        return Map.super.computeIfAbsent(key, mappingFunction);
    }

    @Override
    public Carro computeIfPresent(String key, BiFunction<? super String, ? super Carro, ? extends Carro> remappingFunction) {
        return Map.super.computeIfPresent(key, remappingFunction);
    }

    @Override
    public Carro compute(String key, BiFunction<? super String, ? super Carro, ? extends Carro> remappingFunction) {
        return Map.super.compute(key, remappingFunction);
    }

    @Override
    public Carro merge(String key, Carro value, BiFunction<? super Carro, ? super Carro, ? extends Carro> remappingFunction) {
        return Map.super.merge(key, value, remappingFunction);
    }
}
