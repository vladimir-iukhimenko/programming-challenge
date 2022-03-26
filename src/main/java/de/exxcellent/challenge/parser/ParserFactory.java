package de.exxcellent.challenge.parser;

import de.exxcellent.challenge.enumerated.DataSources;
import de.exxcellent.challenge.parser.api.Parser;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Implementation of factory and strategy pattern for all Parser realisations.
 * With reflection performs initial scan in whole classpath to register all implementations of Parser
 * and then stores them for later invocation.
 * This class can be simply replaced with any of DI-framework
 */
public final class ParserFactory {

    private static Map<DataSources, ? extends List<? extends Parser>> parsers;

    private ParserFactory() {
        parsers = new Reflections("de.exxcellent.challenge").getSubTypesOf(Parser.class)
                .stream()
                .filter(it -> !Modifier.isAbstract(it.getModifiers()))
                .map(it -> {
                    try {
                        return it.getDeclaredConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.groupingBy(Parser::getDataSource));
    }

    public static Parser resolveParser(DataSources dataSource) {
        if (parsers == null) new ParserFactory();
        return Optional.ofNullable(parsers.get(dataSource)).map(it -> it.stream().findAny().get()).orElseThrow(() ->
                new RuntimeException("Sorry, but the appropriate parser for type " + dataSource.name() + " was not found!"));
    }

}
