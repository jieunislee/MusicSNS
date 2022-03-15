package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CommentsVO;



public class CommentsDAO {
	private static CommentsDAO single = null;
	
	public static CommentsDAO getInstance() {
		if(single == null)
			single = new CommentsDAO();
		return single;
	}
	// ----------------------------------
	SqlSessionFactory factory = null;
	public CommentsDAO() {
		// 객체 생성 시 커넥터에서 factory 전달 받음
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	public void insert(CommentsVO cvo) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.insert("comments.comments_insert", cvo);
		sqlSession.commit();
		sqlSession.close();
	}
	public List<CommentsVO> select() {
		List<CommentsVO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("comments.comments_list");
		sqlSession.close();
		return list;
	}
	public List<CommentsVO> select(int idx) {
		List<CommentsVO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("comments.comments_list_idx",idx);
		sqlSession.close();
		return list;
	}
	public void update(int idx) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.update("comments.comments_update", idx);
		sqlSession.commit();
		sqlSession.close();
	}
	public void deleteList(int idx) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.delete("comments.comments_delete",idx);
		sqlSession.commit();
		sqlSession.close();	
	}
	public int CommentsCount(int idx) {
		SqlSession sqlSession = factory.openSession();
		int count =(int)sqlSession.selectOne("comments.comments_count",idx);
		sqlSession.close();
		return count;
	}
	public List<CommentsVO> select(HashMap<String, Integer> map) {
		List<CommentsVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("comments.comments_list_page", map);
		sqlSession.close();
		
		return list;
	}
}
