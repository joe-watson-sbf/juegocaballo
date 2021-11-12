package co.com.sofkau.juegocaballo.application;

import co.com.sofkau.juegocaballo.infrastructure.model.JuegoDocumento;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JuegoQueryControlador {
    private final MongoTemplate mongoTemplate;

    public JuegoQueryControlador(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping("/juego/{id}")
    public JuegoDocumento juego(@PathVariable String id){
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, JuegoDocumento.class, "game");
    }

}
