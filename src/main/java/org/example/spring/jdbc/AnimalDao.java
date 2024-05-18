package org.example.spring.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.example.spring.model.Animal;
import org.example.spring.testing.finaltest.SizeAnimal;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.UUID;

@Slf4j
@Component
public class AnimalDao {

    //    @Autowired
    private final DataSource dataSource;

    public AnimalDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void findById(String id) {
        try (Connection connection = dataSource.getConnection()) {
            Statement selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery("select * from public.animals where id = '" + id + "'");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }

    }

    public void findBySizeAnimal(SizeAnimal sizeAnimal) {
        try (Connection connection = dataSource.getConnection()) {
            Statement selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery("select * from public.animals where size_animal = '" + sizeAnimal.name() + "'");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }

    }

    public String createAnimal(Animal animal) {
        UUID uuid = UUID.randomUUID();
        try (Connection connection = dataSource.getConnection()) {
            Statement selectStatement = connection.createStatement();
            selectStatement.executeUpdate("INSERT INTO PUBLIC.ANIMALS" +
                    "(NAME, AGE, SIZE_ANIMAL, ID)" +
                    "VALUES('" + animal.getName() + "', " + animal.getAge() + ", '" + animal.getSizeAnimal() + "', '" + uuid + "');");
        } catch (SQLException e) {
            log.error("SQLException:", e);}
        return uuid.toString();

    }
//
//    public Connection newDataSource() throws ClassNotFoundException, SQLException {
//        Class.forName("org.h2.Driver");
//        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
//
//    }
}
