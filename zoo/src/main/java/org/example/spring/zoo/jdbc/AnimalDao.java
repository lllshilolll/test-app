package org.example.spring.zoo.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.example.spring.zoo.aspects.AspectAnnotation;
import org.example.spring.zoo.testing.finaltest.SizeAnimal;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class AnimalDao {

    private final DataSource dataSource;

    public AnimalDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @AspectAnnotation
    public AnimalDBPOJO findById(String id) {
        AnimalDBPOJO result = new AnimalDBPOJO();
        try (Connection connection = dataSource.getConnection()) {
            Statement selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery("select * from public.animals where id = '" + id + "'");
            while (resultSet.next()) {
                result.setId(resultSet.getString("id"));
                result.setAge(resultSet.getInt("age"));
                result.setSizeAnimal(SizeAnimal.valueOf(resultSet.getString("size_animal")));
                result.setName(resultSet.getString("name"));
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException e) {
            log.error("SQLException:", e);
        }
        return result;
    }

    public List<AnimalDBPOJO> findAll() {
        List<AnimalDBPOJO> animalDBPOJOS = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            Statement selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery("select * from public.animals");
            while (resultSet.next()) {
                AnimalDBPOJO result = new AnimalDBPOJO();

                result.setId(resultSet.getString("id"));
                result.setAge(resultSet.getInt("age"));
                result.setSizeAnimal(SizeAnimal.valueOf(resultSet.getString("size_animal")));
                result.setName(resultSet.getString("name"));
                animalDBPOJOS.add(result);
            }
        } catch (SQLException e) {
            log.error("SQLException:", e);
        }
        return animalDBPOJOS;
    }

    public void findBySizeAnimal(SizeAnimal sizeAnimal) {
        try (Connection connection = dataSource.getConnection()) {
            Statement selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery("select * from public.animals where size_animal = '" + sizeAnimal.name() + "'");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(3));
            }
        } catch (SQLException e) {
            log.error("SQLException:", e);
        }

    }

    public void createAnimal(AnimalDBPOJO animal) {
        try (Connection connection = dataSource.getConnection()) {
            Statement selectStatement = connection.createStatement();
            selectStatement.executeUpdate("INSERT INTO PUBLIC.ANIMALS" +
                    "(NAME, AGE, SIZE_ANIMAL, ID)" +
                    "VALUES('" + animal.getName() + "', " + animal.getAge() + ", '" + animal.getSizeAnimal() + "', '" + animal.getId() + "');");
        } catch (SQLException e) {
            log.error("SQLException:", e);
        }
    }
//
//    public Connection newDataSource() throws ClassNotFoundException, SQLException {
//        Class.forName("org.h2.Driver");
//        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
//
//    }
}
