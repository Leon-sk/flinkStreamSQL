/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dtstack.flink.sql.sink.kafka.table;

import com.dtstack.flink.sql.format.FormatType;
import com.dtstack.flink.sql.table.TargetTableInfo;
import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Date: 2018/12/18
 * Company: www.dtstack.com
 *
 * @author DocLi
 * @modifyer maqi
 */
public class KafkaSinkTableInfo extends TargetTableInfo {

    public static final String BOOTSTRAPSERVERS_KEY = "bootstrapServers";

    public static final String TOPIC_KEY = "topic";

    public static final String TYPE_KEY = "type";

    public static final String ENABLE_KEY_PARTITION_KEY = "enableKeyPartitions";

    public static final String PARTITION_KEY = "partitionKeys";

    private String bootstrapServers;

    public Map<String, String> kafkaParam = new HashMap<String, String>();

    private String topic;

    private String schemaString;

    private String fieldDelimiter;

    private String enableKeyPartition;

    private String partitionKeys;

    public void addKafkaParam(String key, String value) {
        kafkaParam.put(key, value);
    }

    public String getKafkaParam(String key) {
        return kafkaParam.get(key);
    }

    public Set<String> getKafkaParamKeys() {
        return kafkaParam.keySet();
    }


    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSchemaString() {
        return schemaString;
    }

    public void setSchemaString(String schemaString) {
        this.schemaString = schemaString;
    }

    public String getFieldDelimiter() {
        return fieldDelimiter;
    }

    public void setFieldDelimiter(String fieldDelimiter) {
        this.fieldDelimiter = fieldDelimiter;
    }

    @Override
    public boolean check() {
        Preconditions.checkNotNull(getType(), "kafka of type is required");
        Preconditions.checkNotNull(bootstrapServers, "kafka of bootstrapServers is required");
        Preconditions.checkNotNull(topic, "kafka of topic is required");
        return false;
    }

    public String getEnableKeyPartition() {
        return enableKeyPartition;
    }

    public void setEnableKeyPartition(String enableKeyPartition) {
        this.enableKeyPartition = enableKeyPartition;
    }

    public String getPartitionKeys() {
        return partitionKeys;
    }

    public void setPartitionKeys(String partitionKeys) {
        this.partitionKeys = partitionKeys;
    }

}