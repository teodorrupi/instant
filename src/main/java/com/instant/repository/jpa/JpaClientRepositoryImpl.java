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
package com.instant.repository.jpa;

import com.instant.model.Client;
import com.instant.repository.ClientRepository;
import org.springframework.cache.annotation.Cacheable;
//import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * JPA implementation of the {@link VetRepository} interface.
 *
 * @author Teodor Rupi
 */
@Repository
public class JpaClientRepositoryImpl implements ClientRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    @Cacheable(value = "vets")
    @SuppressWarnings("unchecked")
    public Collection<Client> findAll(String foo) {
        return this.em.createQuery("SELECT vet FROM Vet vet join fetch vet.specialties ORDER BY vet.lastName, vet.firstName").getResultList();
    }

    @Override
    @Cacheable(value = "vets")
    @SuppressWarnings("unchecked")
    public Collection<Client> findAllWithParams(String foo, String faa) {
        return this.em.createQuery("SELECT vet FROM Vet vet join fetch vet.specialties ORDER BY vet.lastName, vet.firstName").getResultList();
    }

}
