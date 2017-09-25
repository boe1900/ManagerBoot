package com.managerboot.service.demo.mybatis.util;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Created by huabo on 2017/9/25.
 */
public class ModuloDatabaseShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<Long> {

    @Override
    public String doEqualSharding(Collection<String> collection, ShardingValue<Long> shardingValue) {
        for(String db:collection){
            if(db.endsWith(String.valueOf(shardingValue.getValue() % 2))){
                return db;
            }
        }
        throw new IllegalArgumentException();
    }


    @Override
    public Collection<String> doInSharding(Collection<String> collection, ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(collection.size());
        for (Long value : shardingValue.getValues()) {
            for (String db : collection) {
                if (db.endsWith(String.valueOf(value % 2))) {
                    result.add(db);
                }
            }
        }
        return result;


    }


    @Override
    public Collection<String> doBetweenSharding(Collection<String> collection, ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(collection.size());
        Range<Long> range = shardingValue.getValueRange();
        for (Long i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
            for (String db : collection) {
                if (db.endsWith(String.valueOf(i % 2))) {
                    result.add(db);
                }
            }
        }
        return result;
    }
}
