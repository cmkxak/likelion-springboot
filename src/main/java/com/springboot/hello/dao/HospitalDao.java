package com.springboot.hello.dao;

import com.springboot.hello.domain.Hospital;
import com.springboot.hello.parser.HospitalParser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class HospitalDao {
    private final JdbcTemplate jdbcTemplate;

    public HospitalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(Hospital hospital) {
        String sql = "INSERT INTO `likelion-db`.`hospital` (`id`, `open_service_name`, `open_local_government_code`, `management_number`, `license_date`, `business_status`, `business_status_code`, `phone`, `full_address`, `road_name_address`, `hospital_name`, `business_type_name`, `healthcare_provider_count`, `patient_room_count`, `total_number_of_beds`, `total_area_size`)" +
                " VALUES (?,?,?," +
                " ?,?,?," +
                " ?,?,?," +
                " ?,?,?," +
                " ?,?,?," +
                " ?);"; // 16개
        this.jdbcTemplate.update(sql,
                hospital.getId(), hospital.getOpenServiceName(), hospital.getOpenLocalGovernmentCode(),
                hospital.getManagementNumber(), hospital.getLicenseDate(), hospital.getBusinessStatus(),
                hospital.getBusinessStatusCode(), hospital.getPhone(), hospital.getFullAddress(),
                hospital.getRoadNameAddress(), hospital.getHospitalName(), hospital.getBusinessTypeName(),
                hospital.getHealthcareProviderCount(), hospital.getPatientRoomCount(), hospital.getTotalNumberOfBeds(), hospital.getTotalAreaSize()
        );
    }

    public int getCount() {
        String sql = "select count(id) from `likelion-db`.`hospital`";
        return this.jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public void deleteAll() {
        this.jdbcTemplate.update("delete from `likelion-db`.`hospital`");
    }

    public Hospital findById(int id) {
        String sql = "select * from `likelion-db`.`hospital` where id = ?";
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    RowMapper<Hospital> rowMapper = new RowMapper<Hospital>() {
        @Override
        public Hospital mapRow(ResultSet rs, int rowNum) throws SQLException {
            Hospital hospital = new Hospital();
            hospital.setId(rs.getInt("id"));
            hospital.setOpenServiceName(rs.getString("open_service_name"));
            hospital.setOpenLocalGovernmentCode(rs.getInt("open_local_government_code"));
            hospital.setManagementNumber(rs.getString("management_number"));
            hospital.setLicenseDate(rs.getTimestamp("licenese-date").toLocalDateTime());
            hospital.setBusinessStatus(rs.getInt("business_status"));
            hospital.setBusinessStatusCode(rs.getInt("business_status_code"));
            hospital.setPhone(rs.getString("phone"));
            hospital.setFullAddress(rs.getString("full_address"));
            hospital.setRoadNameAddress(rs.getString("road_name_address"));
            hospital.setHospitalName(rs.getString("hospital_name"));
            hospital.setBusinessTypeName(rs.getString("business_type_name"));
            hospital.setHealthcareProviderCount(rs.getInt("healthcare_provider_count"));
            hospital.setPatientRoomCount(rs.getInt("patient_room_count"));
            hospital.setTotalNumberOfBeds(rs.getInt("total_number_of_beds"));
            hospital.setTotalAreaSize(rs.getFloat("total_area_size"));
            return hospital;
        }
    };
}
