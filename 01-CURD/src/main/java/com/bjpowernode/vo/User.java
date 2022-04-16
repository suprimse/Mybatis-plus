package com.bjpowernode.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bjpowernode.enums.EnumSex;
import lombok.Data;

@Data
//设置实体类所对应的表名  或者去配置全局配置
//@TableName("t_user")
public class User {
    /**
     * @TableId
     *在实体类中uid属性上通过@TableId将其标识为主键，即可成功执行SQL语句.
     *
     *
     *value属性:
     *         若实体类中主键对应的属性为id，而表中表示主键的字段为uid，此时若只在属性id上添加注解
     *         @TableId，则抛出异常Unknown column 'id' in 'field list'，即MyBatis-Plus仍然会将id作为表的主键操作，而表中表示主键的是字段uid
     *         此时需要通过@TableId注解的value属性，指定表中的主键字段，@TableId("uid")或@TableId(value="uid")
     *type属性:
     *         用来定义主键策略.常用的主键策略：IdType.ASSIGN_ID（默认）
     *         IdType.AUTO：使用数据库的自增策略，注意，该类型请确保数据库设置了id自增，否则无效。
     */

    /**
     * @TableField
     * MyBatis-Plus在执行SQL语句时，要保证实体类中的属性名和表中的字段名一致
     * 在实体类属性上使用@TableField("username")设置属性所对应的字段名
     */
    /**
     * @TableLogic
     * 逻辑删除
     */

    @TableId
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField("is_deleted")
    @TableLogic
    private Integer isdeleted;
    private EnumSex sex;
}
