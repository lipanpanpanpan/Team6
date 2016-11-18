/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.search.aggregations.metrics.valuecount;

import org.elasticsearch.common.ParseField;
import org.elasticsearch.common.xcontent.XContentParser;
import org.elasticsearch.search.aggregations.support.AbstractValuesSourceParser.AnyValuesSourceParser;
import org.elasticsearch.search.aggregations.support.XContentParseContext;
import org.elasticsearch.search.aggregations.support.ValueType;
import org.elasticsearch.search.aggregations.support.ValuesSource;
import org.elasticsearch.search.aggregations.support.ValuesSourceAggregationBuilder;
import org.elasticsearch.search.aggregations.support.ValuesSourceType;

import java.io.IOException;
import java.util.Map;

public class ValueCountParser extends AnyValuesSourceParser {

    public ValueCountParser() {
        super(true, true);
    }

    @Override
    protected boolean token(String aggregationName, String currentFieldName, XContentParser.Token token,
                            XContentParseContext context, Map<ParseField, Object> otherOptions) throws IOException {
        return false;
    }

    @Override
    protected ValuesSourceAggregationBuilder<ValuesSource, ValueCountAggregationBuilder> createFactory(
            String aggregationName, ValuesSourceType valuesSourceType, ValueType targetValueType, Map<ParseField, Object> otherOptions) {
        return new ValueCountAggregationBuilder(aggregationName, targetValueType);
    }
}
