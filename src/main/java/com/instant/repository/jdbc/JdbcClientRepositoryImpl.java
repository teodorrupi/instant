/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.instant.repository.jdbc;

import com.instant.model.Client;
import com.instant.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
//import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A simple JDBC-based implementation of the {@link VetRepository} interface. Uses @Cacheable to cache the result of the
 * {@link findAll} method
 *
 * @author Teodor Rupi
 */
@Repository
public class JdbcClientRepositoryImpl implements ClientRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcClientRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Refresh the cache of Vets that the ClinicService is holding.
     *
     * @see org.springframework.samples.petclinic.model.service.ClinicService#findVets()
     */
    @Override
    public Collection<Client> findAll(String foo) throws DataAccessException {
        List<Client> clients = new ArrayList<Client>();

        clients.addAll(this.jdbcTemplate.query(
                "SELECT id, registered_name FROM clients WHERE id > " + foo + " ORDER BY registered_name",
                ParameterizedBeanPropertyRowMapper.newInstance(Client.class)));

        // Retrieve the list of all possible specialties.
//        final List<Specialty> specialties = this.jdbcTemplate.query(
//                "SELECT id, name FROM specialties",
//                ParameterizedBeanPropertyRowMapper.newInstance(Specialty.class));

        // Build each vet's list of specialties.
//        for (Client client : clients) {
//            final List<Integer> vetSpecialtiesIds = this.jdbcTemplate.query(
//                    "SELECT specialty_id FROM vet_specialties WHERE vet_id=?",
//                    new ParameterizedRowMapper<Integer>() {
//                        @Override
//                        public Integer mapRow(ResultSet rs, int row) throws SQLException {
//                            return Integer.valueOf(rs.getInt(1));
//                        }
//                    },
//                    client.getId().intValue());
//            for (int specialtyId : vetSpecialtiesIds) {
//                Specialty specialty = EntityUtils.getById(specialties, Specialty.class, specialtyId);
//                client.addSpecialty(specialty);
//            }
//        }
        return clients;
    }

    @Override
    public Collection<Client> findAllWithParams(String location, String speciality) throws DataAccessException {
        List<Client> clients = new ArrayList<Client>();

        clients.addAll(this.jdbcTemplate.query(
                "SELECT id, registered_name FROM clients WHERE location='" + location + "' ORDER BY registered_name",
                ParameterizedBeanPropertyRowMapper.newInstance(Client.class)));

        // Retrieve the list of all possible specialties.
//        final List<Specialty> specialties = this.jdbcTemplate.query(
//                "SELECT id, name FROM specialties",
//                ParameterizedBeanPropertyRowMapper.newInstance(Specialty.class));

        // Build each vet's list of specialties.
//        for (Client client : clients) {
//            final List<Integer> vetSpecialtiesIds = this.jdbcTemplate.query(
//                    "SELECT specialty_id FROM vet_specialties WHERE vet_id=?",
//                    new ParameterizedRowMapper<Integer>() {
//                        @Override
//                        public Integer mapRow(ResultSet rs, int row) throws SQLException {
//                            return Integer.valueOf(rs.getInt(1));
//                        }
//                    },
//                    client.getId().intValue());
//            for (int specialtyId : vetSpecialtiesIds) {
//                Specialty specialty = EntityUtils.getById(specialties, Specialty.class, specialtyId);
//                client.addSpecialty(specialty);
//            }
//        }
        return clients;
    }
}
