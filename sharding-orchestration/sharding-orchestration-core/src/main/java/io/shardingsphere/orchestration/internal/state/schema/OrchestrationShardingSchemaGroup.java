/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.orchestration.internal.state.schema;

import lombok.Getter;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Orchestration sharding schema group.
 *
 * @author zhangliang
 */
@Getter
public final class OrchestrationShardingSchemaGroup {
    
    private final Map<String, Collection<String>> schemaGroup = new HashMap<>();
    
    /**
     * Add orchestration schema.
     * 
     * @param orchestrationSchema orchestration schema
     */
    public void add(final OrchestrationShardingSchema orchestrationSchema) {
        String schemaName = orchestrationSchema.getSchemaName();
        if (!schemaGroup.containsKey(schemaName)) {
            schemaGroup.put(schemaName, new LinkedList<String>());
        }
        schemaGroup.get(schemaName).add(orchestrationSchema.getDataSourceName());
    }
}
