package com.nttdata.app.repository;

import com.nttdata.app.documents.BootcoinsRate;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcoinsRepository extends ReactiveMongoRepository<BootcoinsRate,String> {
}
