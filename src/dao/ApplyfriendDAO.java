package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ApplyfriendVO;

public class ApplyfriendDAO {
	private static ApplyfriendDAO single = null;
	
	public static ApplyfriendDAO getInstance() {
		if(single == null)
			single = new ApplyfriendDAO();
		return single;
	}
	// ----------------------------------
	SqlSessionFactory factory = null;
	public ApplyfriendDAO() {
		// 객체 생성 시 커넥터에서 factory 전달 받음
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	public void insert(ApplyfriendVO vo) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.insert("applyfriend.applyfriend_insert", vo);
		sqlSession.commit();
		sqlSession.close();
	}
	public ApplyfriendVO selectOne(ApplyfriendVO vo) {
		ApplyfriendVO res_vo = null;
		SqlSession sqlSession = factory.openSession();
		res_vo = sqlSession.selectOne("applyfriend.applyfriend_one", vo);
		sqlSession.close();
		return res_vo;
	}
	public List<ApplyfriendVO> select(String receiveid) {
		List<ApplyfriendVO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("applyfriend.applyfriend_list",receiveid);
		sqlSession.close();
		return list;
	}
	public void deleteList(int idx) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.delete("applyfriend.applyfriend_delete",idx);
		sqlSession.commit();
		sqlSession.close();	
		
	}
	//페이징
	public int myselectCount(String id) {
		SqlSession sqlSession = factory.openSession();
		int count =(int)sqlSession.selectOne("applyfriend.applyfriend_count",id);
		sqlSession.close();
		return count;
	}
	public List<ApplyfriendVO> myselect(HashMap<String, String> map) {
		List<ApplyfriendVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("applyfriend.applyfriend_list_page", map);
		sqlSession.close();
		
		return list;
	}
}
