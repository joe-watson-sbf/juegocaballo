package co.com.sofkau.juego.infrastructure;

import co.com.sofkau.juego.domain.Juego;
import co.com.sofkau.juego.infrastructure.documentos.JuegoDocumento;
import co.com.sofkau.juego.infrastructure.mapper.Mapper;
import co.com.sofkau.juego.usecase.port.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import static co.com.sofkau.juego.infrastructure.mapper.Mapper.toDocumentoJineteList;
import static co.com.sofkau.juego.infrastructure.mapper.Mapper.toJuego;

@Repository
public class MongoJuegoRepository implements JuegoRepository {


    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoJuegoRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Juego guardar(Juego juego) {

        JuegoDocumento documento = new JuegoDocumento(
                juego.id(),
                toDocumentoJineteList(juego.jinetes()),
                juego.kilometros(),
                juego.numeroCariles()
        );

        var juegoDocumento = mongoTemplate.save(documento, "juego");

        return toJuego(juegoDocumento);
    }



    @Override
    public Juego buscarPorId(String id) {
        Query query = new Query(Criteria.where("_id").is(id));

        var documento = mongoTemplate.findOne(query,
                JuegoDocumento.class, "juego");

        assert documento != null;
        return toJuego(documento);
    }

    @Override
    public Juego update(Juego juego) {
        Query query = new Query(Criteria.where("_id").is(juego.id()));
        Update update = new Update();


        update.set("juego", new JuegoDocumento(
                juego.id(),
                Mapper.toDocumentoJineteList(juego.jinetes()),
                juego.kilometros(),
                juego.numeroCariles())
        );


        var data = mongoTemplate
                .updateFirst(query,
                        update,
                        JuegoDocumento.class,
                        "game").getMatchedCount();

        return null;
    }


}
