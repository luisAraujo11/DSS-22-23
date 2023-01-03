/*
 *  DISCLAIMER: Este código foi criado para discussão e edição durante as aulas práticas de DSS, representando
 *  uma solução em construção. Como tal, não deverá ser visto como uma solução canónica, ou mesmo acabada.
 *  É disponibilizado para auxiliar o processo de estudo. Os alunos são encorajados a testar adequadamente o
 *  código fornecido e a procurar soluções alternativas, à medida que forem adquirindo mais conhecimentos.
 */
package RacingManager.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOconfig {

    public static final String USERNAME = "root";
    public static final String PASSWORD = "12345678";
    private static final String DATABASE = "racingmanager";
    private static final String DRIVER = "jdbc:mysql";
    public static final String URL = DRIVER+"://localhost:3306/"+DATABASE;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + DATABASE, USERNAME, PASSWORD);
    }
    public static Connection getConnectionNoDatabase() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}
