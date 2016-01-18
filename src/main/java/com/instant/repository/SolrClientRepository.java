package com.instant.repository;

import com.instant.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.*;

import java.util.Collection;

/**
 * Created by trupi on 26/12/15.
 */
public interface SolrClientRepository extends SolrCrudRepository<Client, String> {

    Page<Client> findByPopularity(Integer popularity, Pageable page);

    Page<Client> findByNameOrDescription(@Boost(2) String name, String description, Pageable page);

    @Highlight
    HighlightPage<Client> findByNameIn(Collection<String> name, Page page);

    @Query(value = "name:?0")
    @Facet(fields = { "cat" }, limit=20)
    FacetPage<Client> findByNameAndFacetOnCategory(String name, Pageable page);
}
