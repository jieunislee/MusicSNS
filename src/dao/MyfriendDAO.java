package dao;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MyfriendVO;

public class MyfriendDAO {
	private static MyfriendDAO single = null;
	
	public static MyfriendDAO getInstance() {
		if(single == null)
			single = new MyfriendDAO();
		return single;
	}
	// ----------------------------------
	SqlSessionFactory factory = null;
	public MyfriendDAO() {
		// 객체 생성 시 커넥터에서 factory 전달 받음
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	public void insert(MyfriendVO vo) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.insert("myfriend.myfriend_insert", vo);
		sqlSession.commit();
		sqlSession.close();
	}
	public MyfriendVO selectOne(MyfriendVO vo) {
		MyfriendVO res_vo = null;
		SqlSession sqlSession = factory.openSession();
		res_vo = sqlSession.selectOne("myfriend.myfriend_one", vo);
		sqlSession.close();
		return res_vo;
	}
	public List<MyfriendVO> select(String myid) {
		List<MyfriendVO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("myfriend.myfriend_list",myid);
		sqlSession.close();
		return list;
	}
	public void deleteList(MyfriendVO vo) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.delete("myfriend.myfriend_delete",vo);
		sqlSession.commit();
		sqlSession.close();	
		
	}

	
	//페이징
	public int myselectCount(String id) {
		SqlSession sqlSession = factory.openSession();
		int count =(int)sqlSession.selectOne("myfriend.myfriend_count",id);
		sqlSession.close();
		return count;
	}
	public List<MyfriendVO> myselect(HashMap<String, String> map) {
		List<MyfriendVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("myfriend.myfriend_list_page", map);
		sqlSession.close();
		
		return list;
	}
}
