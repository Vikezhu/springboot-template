package com.vike.server.ums.dao;

import com.vike.server.ums.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate template;

    @Override
    public List<UserDetails> getUser(Boolean countOutput, Integer start, Integer limit, String key, String value,
                                     Boolean search, Boolean searchByAny, String sortfield, String sorttype) {
        Query query = new Query();
        // 查询条件处理
        if (!searchByAny) {
            if (search) {
                if (key != null && value != null) {
                    String[] keys = key.split(",");
                    String[] values = value.split(",");
                    for (int i = 0; i < keys.length; i++) {
                        Criteria criteria = Criteria.where(keys[i]).regex(values[i]);
                        query.addCriteria(criteria);
                    }
                }
            } else {
                if (key != null && value != null) {
                    String[] keys = key.split(",");
                    String[] values = value.split(",");
                    for (int i = 0; i < keys.length; i++) {
                        Criteria criteria = Criteria.where(keys[i]).is(values[i]);
                        query.addCriteria(criteria);
                    }
                }
            }
        } else {
            if (search) {
                if (key != null && value != null) {
                    String[] keys = key.split(",");
                    String[] values = value.split(",");
                    Criteria[] condition = new Criteria[keys.length];
                    for (int i = 0; i < keys.length; i++) {
                        condition[i] = Criteria.where(keys[i]).regex(values[i]);
                    }
                    Criteria criteria = new Criteria();
                    criteria.orOperator(condition);
                    query.addCriteria(criteria);
                }
            } else {
                if (key != null && value != null) {
                    String[] keys = key.split(",");
                    String[] values = value.split(",");
                    Criteria[] condition = new Criteria[keys.length];
                    for (int i = 0; i < keys.length; i++) {
                        condition[i] = Criteria.where(keys[i]).is(values[i]);
                    }
                    Criteria criteria = new Criteria();
                    criteria.orOperator(condition);
                    query.addCriteria(criteria);
                }
            }
        }
        if (sortfield != null && sorttype != null) {
            switch (sorttype) {
                case "ASC":
                    query.with(Sort.by(Sort.Order.asc(sortfield)));
                    break;
                case "DESC":
                    query.with(Sort.by(Sort.Order.desc(sortfield)));
                    break;
                default:
                    break;
            }
        }
        if (start != null && limit != null) {
            query.skip(start).limit(limit);
        }
        List<UserDetails> resultList = template.find(query, UserDetails.class);
        return resultList;
    }

    @Override
    public UserDetails getUserDetails(String userId) {
        Query query = new Query(Criteria.where("_id").is(userId));
        return template.findOne(query, UserDetails.class);
    }

    @Override
    public void addUser(UserDetails user) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String date = format.format(new Date());
        user.setUserId(date);
        template.save(user);
    }

    @Override
    public void updateUser(UserDetails user) {
        Query query = new Query(Criteria.where("_id").is(user.getUserId()));
        Update update = new Update()
                .set("name", user.getName())
                .set("age", user.getAge())
                .set("code", user.getCode())
                .set("phone", user.getPhone())
                .set("apartment", user.getApartment())
                .set("bizLine", user.getBizLine())
                .set("email", user.getEmail())
                .set("entryTime", user.getEntryTime())
                .set("status", user.getStatus());
        //更新查询返回结果集的第一条
        template.updateFirst(query, update, UserDetails.class);
    }

    @Override
    public void deleteUser(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        template.remove(query, UserDetails.class);
    }
}
