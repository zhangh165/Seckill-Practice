package com.zhh1011.miaosad.business.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.ibatis.features.jpa.annotation.Entity;
import org.apache.ibatis.features.jpa.annotation.Id;
import org.apache.ibatis.features.jpa.annotation.Table;

@Data
@Accessors(chain = true)
@Entity
@Table(name="t_test_entity")
public class TestEntity {
    @Id
    private int id;
}
