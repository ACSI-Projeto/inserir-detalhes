package com.example.detalhes.base;

import com.example.detalhes.domain.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME, // identifica o tipo pelo nome
    include = JsonTypeInfo.As.PROPERTY, // inclui no JSON como propriedade
    property = "tipo" // o campo que vai indicar o tipo do JSON
)
@JsonSubTypes(
    {
        @JsonSubTypes.Type(value = Multa.class, name = "multa"),
        @JsonSubTypes.Type(value = Veiculo.class, name = "veiculo"),
        @JsonSubTypes.Type(value = Cliente.class, name = "cliente"),
        @JsonSubTypes.Type(
            value = MultaEnriquecida.class,
            name = "mEnriquecida"
        ),
    }
)
public abstract class MensagemBase {}
