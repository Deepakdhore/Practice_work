package com.RestApi.Automobiles.repository;

import com.RestApi.Automobiles.entities.Vehicle;
import com.RestApi.Automobiles.entities.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jdbcRepo")
public class JdbcVehicleRepository implements VehicleRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Vehicle> rowMapper = (rs, rowNum) -> {
        Vehicle v = new Vehicle();
        v.setId(rs.getLong("id"));
        v.setModelName(rs.getString("model_name"));
        v.setType(VehicleType.valueOf(rs.getString("type")));
        return v;
    };

    @Override
    public List<Vehicle> findAll() {
        return jdbcTemplate.query("SELECT * FROM vehicle", rowMapper);
    }

    @Override
    public void save(Vehicle vehicle) {
        jdbcTemplate.update("INSERT INTO vehicle (model_name, type) VALUES (?, ?)",
                vehicle.getModelName(), vehicle.getType().name());
    }

    @Override
    public List<Vehicle> getByType(VehicleType type) {
        return jdbcTemplate.query("SELECT * FROM vehicle WHERE type = ?", rowMapper, type.name());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM vehicle WHERE id = ?", id);
    }
}

