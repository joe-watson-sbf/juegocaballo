package co.com.sofkau.juegocaballo.infrastructure;

import co.com.sofkau.juegocaballo.domain.entity.Juego;
import co.com.sofkau.juegocaballo.infrastructure.model.JuegoDocumento;
import co.com.sofkau.juegocaballo.usecase.port.JuegoRepository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;

import static co.com.sofkau.juegocaballo.infrastructure.utils.Mapper.toDocumento;
import static co.com.sofkau.juegocaballo.infrastructure.utils.Mapper.toJuego;


@Repository
public class MongoJuegoRepository implements JuegoRepository {

    private final MongoTemplate mongoTemplate;

    public MongoJuegoRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Juego getOneById(String id) {

        Query query = new Query(Criteria.where("_id").is(id));
        var gameDocument = mongoTemplate.findOne(query,
                JuegoDocumento.class, "game");

        assert gameDocument != null;

        return toJuego(gameDocument);
    }

    @Override
    public String save(Juego juego) {
        System.out.println("A GUARDAR ---> " + toDocumento(juego));
        var juegoDocumento = mongoTemplate.save(toDocumento(juego), "game");
        return juegoDocumento.getId();
    }

    @Override
    public Juego update(Juego juego) {
        Query query = new Query(Criteria.where("_id").is(juego.id()));

        var data = mongoTemplate.updateMulti(query,
                Update.update(juego.id(), toDocumento(juego)),
                JuegoDocumento.class);

        return getOneById(juego.id());
    }


}
