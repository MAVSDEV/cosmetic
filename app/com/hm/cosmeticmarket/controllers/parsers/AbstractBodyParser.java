package com.hm.cosmeticmarket.controllers.parsers;

import akka.util.ByteString;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.streams.Accumulator;
import play.mvc.BodyParser;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

import static play.libs.F.Either;

/**
 * Abstract request body parser. Retrieve data from the request to Java entity
 */
public abstract class AbstractBodyParser<T> implements BodyParser<T>{

    private Json jsonParser;
    private Executor executor;

    public AbstractBodyParser(Json jsonParser, Executor executor) {
        this.jsonParser = jsonParser;
        this.executor = executor;
    }

    @Override
    public Accumulator<ByteString, Either<Result, T>> apply(Http.RequestHeader request) {
        Accumulator<ByteString, Either<Result, JsonNode>> jsonAccumulator = jsonParser.apply(request);
        return jsonAccumulator.map(resultOrJson -> {
            if (resultOrJson.left.isPresent()) {
                return Either.Left(resultOrJson.left.get());
            } else {
                JsonNode json = resultOrJson.right.get();
                try {
                    T t = play.libs.Json.fromJson(json, getType());
                    return Either.Right(t);
                } catch (Exception e) {
                    return Either.Left(Results.badRequest(
                            "Unable to read User from json: " + e.getMessage()));
                }
            }
        }, executor);
    }

    private Class<T> getType(){
        Class<T> type = null;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            type = (Class<T>) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        }
        return type;
    }
}


