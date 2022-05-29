package com.example.demo.repository;

import com.example.demo.entity.Admission;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.ArrayList;

@Repository
public class AdmissionRepository implements IRestRepository<Admission>{
    protected final JdbcOperations jdbcOperations;

    public AdmissionRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    private static String selectQuery = "SELECT \"id\", \"worker_id\",  \"academic_building_id\", \"state_number\" " +
            "FROM \"admission\" " +
            "ORDER BY \"id\"";

    private static String selectByIdQuery = "SELECT \"id\", \"worker_id\",  \"academic_building_id\", \"state_number\" " +
            "FROM \"admission\" " +
            "WHERE \"id\" = ?";

    private static String selectByAcademicBuildingIdQuery = "SELECT \"id\", \"worker_id\",  \"academic_building_id\", \"state_number\" " +
            "FROM \"admission\" " +
            "WHERE \"academic_building_id\" = ?";

    private static String selectByWorkerIdQuery = "SELECT \"id\", \"worker_id\",  \"academic_building_id\", \"state_number\" " +
            "FROM \"admission\" " +
            "WHERE \"worker_id\" = ?";

    private static String insertQuery = "INSERT INTO \"admission\"( \"worker_id\",  \"academic_building_id\", \"state_number\") " +
            "VALUES (?, ?, ?) " +
            "RETURNING \"id\", \"worker_id\",  \"academic_building_id\", \"state_number\" ";

    private static String updateQuery = "UPDATE \"admission\" " +
            "SET \"worker_id\" = ?, \"academic_building_id\" = ?, \"term\" = ?" +
            "WHERE \"id\" = ? " +
            "RETURNING \"id\", \"worker_id\",  \"academic_building_id\", \"state_number\" ";

    private static String deleteQuery = "DELETE FROM \"admission\" " +
            "WHERE \"id\" = ? " +
            "RETURNING \"id\", \"worker_id\",  \"academic_building_id\", \"state_number\" ";

    @Override
    public Admission [] select() {
        ArrayList<Admission> values = new ArrayList<Admission>();
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectQuery);
        while (rowSet.next()) {
            values.add(new Admission(
                    rowSet.getInt(1),
                    rowSet.getInt(2),
                    rowSet.getInt(3),
                    rowSet.getString(4)
            ));
        }
        Admission[] result = new Admission[values.size()];
        result = values.toArray(result);
        return result;
    }

    @Override
    public Admission select(Integer id) {
        Object[] params = new Object[] { id };
        int[] types = new int[] {Types.INTEGER };
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectByIdQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Admission(
                rowSet.getInt(1),
                rowSet.getInt(2),
                rowSet.getInt(3),
                rowSet.getString(4)
        );
    }

    public Admission[] selectByAcademicBuildingIdQuery (Integer academic_building_id) {
        ArrayList<Admission> values = new ArrayList<Admission>();
        Object[] params = new Object[] { academic_building_id };
        int[] types = new int[] { Types.INTEGER };
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectByAcademicBuildingIdQuery, params, types);
        while (rowSet.next()) {
            values.add(new Admission(
                    rowSet.getInt(1),
                    rowSet.getInt(2),
                    rowSet.getInt(3),
                    rowSet.getString(4)
            ));
        }
        Admission[] result = new Admission[values.size()];
        result = values.toArray(result);
        return result;
    }

    public Admission[] selectByWorkerIdQuery (Integer worker_id) {
        ArrayList<Admission> values = new ArrayList<Admission>();
        Object[] params = new Object[] { worker_id };
        int[] types = new int[] { Types.INTEGER };
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(selectByWorkerIdQuery, params, types);
        while (rowSet.next()) {
            values.add(new Admission(
                    rowSet.getInt(1),
                    rowSet.getInt(2),
                    rowSet.getInt(3),
                    rowSet.getString(4)
            ));
        }
        Admission[] result = new Admission[values.size()];
        result = values.toArray(result);
        return result;
    }

    @Override
    public Admission insert(Admission entity) {
        Object[] params = new Object[] { entity.getWorker_id(), entity.getAcademic_building_id(),  entity.getState_number()};
        int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.VARCHAR};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(insertQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Admission(
                rowSet.getInt(1),
                rowSet.getInt(2),
                rowSet.getInt(3),
                rowSet.getString(4)
        );
    }

    @Override
    public Admission update(Integer id, Admission entity) {
        Object[] params = new Object[] { entity.getWorker_id(), entity.getAcademic_building_id(),  entity.getState_number(), id };
        int[] types = new int[] { Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.INTEGER};
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(updateQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Admission(
                rowSet.getInt(1),
                rowSet.getInt(2),
                rowSet.getInt(3),
                rowSet.getString(4)
        );
    }


    @Override
    public Admission delete(Integer id) {
        Object[] params = new Object[] { id };
        int[] types = new int[] {Types.INTEGER };
        SqlRowSet rowSet = jdbcOperations.queryForRowSet(deleteQuery, params, types);
        if (!rowSet.next()) {
            return null;
        }
        return new Admission(
                rowSet.getInt(1),
                rowSet.getInt(2),
                rowSet.getInt(3),
                rowSet.getString(4)
        );
    }


}