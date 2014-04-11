/*
 * Copyright (C) 2007-2014, GoodData(R) Corporation. All rights reserved.
 */
package com.gooddata.md;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 */
@JsonTypeName("metric")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Metric extends Obj {

    private final Content content;

    @JsonCreator
    public Metric(@JsonProperty("meta") Meta meta, @JsonProperty("content") Content content) {
        super(meta);
        this.content = content;
    }

    public Metric(String title, String expression, String format) {
        this(new Meta(title), new Metric.Content(expression, format));
    }

    public Content getContent() {
        return content;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Content {
        private final String expression;
        private final String format;

        @JsonCreator
        public Content(@JsonProperty("expression") String expression, @JsonProperty("format") String format) {
            this.expression = expression;
            this.format = format;
        }

        public String getExpression() {
            return expression;
        }

        public String getFormat() {
            return format;
        }
    }
}
