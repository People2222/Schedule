package com.example.demo.repository;

import com.example.demo.entity.Application;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;

@Repository
public class ApplicationRepository implements IRestRepository<Application> {
    protected final JdbcOperations jdbcOperations;

    public ApplicationRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    /* private static String selectQuery = "SELECT \"id\", \"worker_id\",  \"academic_building_id\", \"state_number\" " +
             "FROM \"admission\" " +
             "ORDER BY \"id\"";*/
   /*String brand_of_transport,
                                String model,
                                String state_number,
                                String color,
                                String owner,
                                Integer worker_id,
                                Integer academic_building_id,
                                Timestamp temp,
                                String status*/
    private static String selectQuery = "SELECT \"id\", \"brand_of_transport\",  \"model\", " +
            "\"state_number\" , \"color\",  \"owner\", \"worker_id\",  \"academic_building_id\", \"temp\",  \"status\" " +
            "FROM \"application\" " +
            "ORDER BY \"id\"";


    private static String selectByIdQuery = "SELECT \"id\", \"brand_of_transport\",  \"model\", " +
            "\"state_number\" , \"color\",  \"owner\", \"worker_id\",  \"academic_building_id\", \"temp\",  \"status\" " +
            "FROM \"application\" " +
            "WHERE \"id\" = ?";

    private static String selectByAcademicBuildingIdQuery = "SELECT \"id\", \"brand_of_transport\",  \"model\", " +
            "\"state_number\" , \"color\",  \"owner\", \"worker_id\",  \"academic_building_id\", \"temp\",  \"status\" " +
            "FROM \"application\" " +
            "WHERE \"academic_building_id\" = ?";

    private static String selectByWorkerIdQuery = "SELECT \"id\", \"brand_of_transport\",  \"model\", " +
            "\"state_number\" , \"color\",  \"owner\", \"worker_id\",  \"academic_building_id\", \"temp\",  \"status\" " +
            "FROM \"application\" " +
            "WHERE \"worker_id\" = ?";

    private static String insertQuery = "INSERT INTO \"application\"(\"brand_of_transport\",  \"model\", " +
            "\"state_number\" , \"color\",  \"owner\", \"worker_id\",  \"academic_building_id\", \"temp\", \"status\") " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) " +
            "RETURNING \"id\", \"brand_of_transport\",  \"model\", " +
            "\"state_number\" , \"color\",  \"owner\", \"worker_id\",  \"academic_building_id\", \"temp\", \"status\" ";

    private static String updateQuery = "UPDATE \"application\" " +
            "SET \"brand_of_transport\" = ?, \"model\" = ?, \"state_number\" = ?, \"color\" = ?, " +
            "\"owner\" = ?, \"worker_id\" = ?, \"academic_building_id\" = ?, \"temp\" = ? , \"status\" = ?" +
            "WHERE \"id\" = ? " +
            "RETURNING \"id\", \"brand_of_transport\",  \"model\", " +
            "\"state_number\" , \"color\",  \"owner\", \"worker_id\",  " +
            "\"academic_building_id\", \"temp\", \"status\"  ";

    private static String deleteQuery = "DELETE FROM \"application\" " +
            "WHERE \"id\" = ? " +
            "RETURNING \"id\", \"brand_of_transport\",  \"model\", " +
            "\"state_number\" , \"color\",  \"owner\", \"worker_id\",  " +
            "\"academic_building_id\", \"temp\", \"status\"  ";

    @Override
    public Application[] select() {
        ArrayList<Application> values = new ArrayList<Application>();
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectQuery);
        while (rowSet.next()) {
            values.add(new Application(
                    rowSet.getInt(1),
                    rowSet.getString(2),
                    rowSet.getString(3),
                    rowSet.getString(4),
                    rowSet.getString(5),
                    rowSet.getString(6),
                    rowSet.getInt(7),
                    rowSet.getInt(8),
                    rowSet.getTimestamp(9),
                    rowSet.getString(10)
            ));
        }
        Application[] result = new Application[values.size()];
        result = values.toArray(result);
        return result;
    }

    @Override
    public Application select(Integer id) {
        Object[] params = new Object[]{id};
        int[] types = new int[]{Types.INTEGER};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectByIdQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Application(
                rowSet.getInt(1),
                rowSet.getString(2),
                rowSet.getString(3),
                rowSet.getString(4),
                rowSet.getString(5),
                rowSet.getString(6),
                rowSet.getInt(7),
                rowSet.getInt(8),
                rowSet.getTimestamp(9),
                rowSet.getString(10)
        );
    }

    public Application[] selectByAcademicBuildingIdQuery(Integer academic_building_id) {
        ArrayList<Application> values = new ArrayList<Application>();
        Object[] params = new Object[]{academic_building_id};
        int[] types = new int[]{Types.INTEGER};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectByAcademicBuildingIdQuery, params, types);
        while (rowSet.next()) {
            values.add(new Application(
                    rowSet.getInt(1),
                    rowSet.getString(2),
                    rowSet.getString(3),
                    rowSet.getString(4),
                    rowSet.getString(5),
                    rowSet.getString(6),
                    rowSet.getInt(7),
                    rowSet.getInt(8),
                    rowSet.getTimestamp(9),
                    rowSet.getString(10)
            ));
        }
        Application[] result = new Application[values.size()];
        result = values.toArray(result);
        return result;
    }

    public Application[] selectByWorkerIdQuery(Integer worker_id) {
        ArrayList<Application> values = new ArrayList<Application>();
        Object[] params = new Object[]{worker_id};
        int[] types = new int[]{Types.INTEGER};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectByWorkerIdQuery, params, types);
        while (rowSet.next()) {
            values.add(new Application(
                    rowSet.getInt(1),
                    rowSet.getString(2),
                    rowSet.getString(3),
                    rowSet.getString(4),
                    rowSet.getString(5),
                    rowSet.getString(6),
                    rowSet.getInt(7),
                    rowSet.getInt(8),
                    rowSet.getTimestamp(9),
                    rowSet.getString(10)
            ));
        }
        Application[] result = new Application[values.size()];
        result = values.toArray(result);
        return result;
    }

    /*private Integer id;
    private String brand_of_transport;
    private String model;
    private String state_number;
    private String color;
    private String owner;
    private Integer worker_id;
    private Integer academic_building_id;
    private Timestamp temp;
    private String status;*/
    @Override
    public Application insert(Application entity) {
        Object[] params = new Object[]{entity.getBrand_of_transport(),
                entity.getColor(), entity.getModel(), entity.getState_number(), entity.getWorker_id(), entity.getAcademic_building_id(),
                entity.getOwner(), entity.getStatus(), entity.getTemp()};
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.TIMESTAMP, Types.VARCHAR};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(insertQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Application(
                rowSet.getInt(1),
                rowSet.getString(2),
                rowSet.getString(3),
                rowSet.getString(4),
                rowSet.getString(5),
                rowSet.getString(6),
                rowSet.getInt(7),
                rowSet.getInt(8),
                rowSet.getTimestamp(9),
                rowSet.getString(10)
        );
    }

    @Override
    public Application update(Integer id, Application entity) {
        Object[] params = new Object[]{entity.getBrand_of_transport(),
                entity.getColor(), entity.getModel(), entity.getState_number(), entity.getWorker_id(), entity.getAcademic_building_id(),
                entity.getOwner(), entity.getStatus(), entity.getTemp(), id};
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER, Types.TIMESTAMP, Types.VARCHAR, Types.INTEGER};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(updateQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Application(
                rowSet.getInt(1),
                rowSet.getString(2),
                rowSet.getString(3),
                rowSet.getString(4),
                rowSet.getString(5),
                rowSet.getString(6),
                rowSet.getInt(7),
                rowSet.getInt(8),
                rowSet.getTimestamp(9),
                rowSet.getString(10)
        );
    }


    @Override
    public Application delete(Integer id) {
        Object[] params = new Object[]{id};
        int[] types = new int[]{Types.INTEGER};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(deleteQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Application(
                rowSet.getInt(1),
                rowSet.getString(2),
                rowSet.getString(3),
                rowSet.getString(4),
                rowSet.getString(5),
                rowSet.getString(6),
                rowSet.getInt(7),
                rowSet.getInt(8),
                rowSet.getTimestamp(9),
                rowSet.getString(10)
        );
    }
}