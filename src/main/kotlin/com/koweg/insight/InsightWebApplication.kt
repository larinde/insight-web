package com.koweg.insight

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import graphql.Scalars

import graphql.schema.idl.RuntimeWiring

import com.netflix.graphql.dgs.DgsRuntimeWiring

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsScalar
import graphql.language.StringValue
import graphql.schema.Coercing
import graphql.schema.CoercingParseLiteralException
import graphql.schema.CoercingParseValueException
import graphql.schema.CoercingSerializeException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
//import graphql.scalars.ExtendedScalars


@SpringBootApplication
class InsightWebApplication

fun main(args: Array<String>) {
    runApplication<InsightWebApplication>(*args)
}

@DgsComponent
class BigDecimalScalarRegistration {
    @DgsRuntimeWiring
    fun addScalar(builder: RuntimeWiring.Builder): RuntimeWiring.Builder {
        return builder.scalar(Scalars.GraphQLBigDecimal)
    }
}


/*
@DgsScalar(name = "DateTime")
class DateTimeScalarRegistration : Coercing<LocalDateTime, String> {
    @Throws(CoercingSerializeException::class)
    override fun serialize(dataFetcherResult: Any): String {
        return if (dataFetcherResult is LocalDateTime) {
            dataFetcherResult.format(DateTimeFormatter.ISO_DATE_TIME)
        } else {
            throw CoercingSerializeException("Not a valid DateTime")
        }
    }

    @Throws(CoercingParseValueException::class)
    override fun parseValue(input: Any): LocalDateTime {
        return LocalDateTime.parse(input.toString(), DateTimeFormatter.ISO_DATE_TIME)
    }

    @Throws(CoercingParseLiteralException::class)
    override fun parseLiteral(input: Any): LocalDateTime {
        if (input is StringValue) {
            return LocalDateTime.parse(input.value, DateTimeFormatter.ISO_DATE_TIME)
        }
        throw CoercingParseLiteralException("Value is not a valid ISO date time")
    }
}
*/
