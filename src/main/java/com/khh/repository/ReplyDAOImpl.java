package com.khh.repository;

import com.khh.domain.Reply;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hyunhokim on 2017. 4. 27..
 */
@Repository
public class ReplyDAOImpl implements ReplyDAO {

    @Autowired
    private SqlSession sqlSession;

    private static String namespace = "com.khh.mapper.ReplyMapper";

    @Override
    public List<Reply> list(int bno) throws Exception {
        return sqlSession.selectList(namespace + ".list", bno);
    }

    @Override
    public void create(Reply reply) throws Exception {
        sqlSession.insert(namespace + ".create", reply);
    }

    @Override
    public void update(Reply reply) throws Exception {
        sqlSession.update(namespace + ".update", reply);
    }

    @Override
    public void delete(int rno) throws Exception {
        sqlSession.delete(namespace + ".delete", rno);
    }

    @Override
    public void initAutoIncrement() throws Exception {
        sqlSession.update(namespace + ".initAutoIncrement");
    }

    @Override
    public void deleteAll() throws Exception {
        sqlSession.delete(namespace + ".deleteAll");
    }

    @Override
    public int count() throws Exception {
        return sqlSession.selectOne(namespace + ".count");
    }
}
