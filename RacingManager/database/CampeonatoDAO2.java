package RacingManager.database;

import RacingManager.business.Campeonato;
import RacingManager.database.DAOconfig;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import static java.util.stream.Collectors.toList;

import static java.util.stream.Collectors.*;


public class CampeonatoDAO2 implements Map<String, Campeonato> {
    private static CampeonatoDAO2 singleton = null;

    private CampeonatoDAO2() {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS circuito (" +
                    "Nome varchar(10) NOT NULL PRIMARY KEY," +
                    "Distancia int(4) DEFAULT 0," +
                    "Curvas int(4) DEFAULT 0," +
                    "Chicane int(4) DEFAULT 0," +
                    "Voltas int(4) DEFAULT 0," +
                    "CarroID varchar(10) NOT NULL)";
            stm.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS campeonato (" +
                    "Nome varchar(10) NOT NULL)";
            stm.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS gdu (" +
                    "Tempo varchar(10) NOT NULL PRIMARY KEY," +
                    "Piloto varchar(10) DEFAULT NULL," +
                    "Carro varchar(10) NOT NULL)";
            stm.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS alunos (" +
                    "Num varchar(10) NOT NULL PRIMARY KEY," +
                    "Nome varchar(45) DEFAULT NULL," +
                    "Email varchar(45) DEFAULT NULL," +
                    "Turma varchar(10), foreign key(Turma) references turmas(id))";
            stm.executeUpdate(sql);
            sql= "CREATE TABLE IF NOT EXISTS record (" +
                    "Piloto varchar(45) NOT NULL PRIMARY KEY," +
                    "Tempo float(8) ," +
                    "Carro varchar(45) DEFAULT NULL)";
            sql = "CREATE TABLE IF NOT EXISTS carro (" +
                    "IdCarro int(10) DEFAULT 0 PRIMARY KEY," +
                    "Marca varchar(45) DEFAULT NULL," +
                    "Modelo varchar(45) DEFAULT NULL," +
                    "Cilindrada int(4) DEFAULT 0," +
                    "Potencia int(4) DEFAULT 0," +
                    "PotenciaEletrica int(4) DEFAULT 0," +
                    "SerHibrido BIT(2)," +
                    "Pac FLOAT(8))";
            sql = "CREATE TABLE IF NOT EXISTS corrida (" +
                    "IdCorrida varchar(10) NOT NULL PRIMARY KEY)";
            //  "CircuitoId varchar(10),  foreign Key(CircuitoId) references circuito(Nome)" +
            //  "MetereologiaId varchar(10), foreign Key(MetereologiaId) references metereologia(IdMet))";
            stm.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS metereologia (" +
                    "IdMet varchar(10) NOT NULL PRIMARY KEY," +
                    "Temperatura int(4)," +
                    "Precipitação int(4))";
            stm.executeUpdate(sql);
            stm.executeUpdate(sql);
          //  stm.executeUpdate("INSERT INTO circuito VALUES ( 'Mahnaz', 12, 25,13,14,'Ma5hnaz')");
           // stm.executeUpdate("INSERT INTO campeonato VALUES (12)");
           // stm.executeUpdate("INSERT INTO gdu VALUES ('Mahnaz', 'Mahnaz','Mahnaz')");
            // stm.executeUpdate("INSERT INTO record VALUES ('Mahnaz', 12.2 ,'Mahnaz')");
           // stm.executeUpdate("INSERT INTO carro VALUES (2,'Mahnaz','Mahnaz',6,8,,5,0,2)");
           // stm.executeUpdate("INSERT INTO carro VALUES (2,'Mahnaz','Mahnaz',6,8,,5,0, 12.2)");

        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
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
    public Campeonato get(Object key) {
        return null;
    }

    @Override
    public Campeonato put(String key, Campeonato value) {
        return null;
    }

    @Override
    public Campeonato remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Campeonato> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Campeonato> values() {
        return null;
    }

    @Override
    public Set<Entry<String, Campeonato>> entrySet() {
        return null;
    }
}
