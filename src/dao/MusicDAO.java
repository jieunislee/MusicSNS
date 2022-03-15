package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import service.MyBatisConnector;
import vo.MusicVO;


public class MusicDAO {
	private static MusicDAO single = null;
	
	public static MusicDAO getInstance() {
		if(single == null)
			single = new MusicDAO();
		return single;
	}
	// ----------------------------------
	SqlSessionFactory factory = null;
	public MusicDAO() {
		// 객체 생성 시 커넥터에서 factory 전달 받음
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	public void insert( MusicVO vo ) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.insert("music.music_insert", vo);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<MusicVO> select() {
		List<MusicVO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("music.music_list");
		sqlSession.close();
		return list;
	}
	public List<MusicVO> select(String search) {
		List<MusicVO> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("music.music_search",search);
		sqlSession.close();
		return list;
	}
	public MusicVO selectOne(int idx) {
		MusicVO vo = null;
		SqlSession sqlSession = factory.openSession();
				
				// selectList 와는 다르게 하나의 객체만 반환받는 메서드
		vo = sqlSession.selectOne("music_one", idx );
		sqlSession.close();
		return vo;
	}
	public void update(int idx) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.update("music.music_update", idx);
		sqlSession.commit();
		sqlSession.close();
	}
	public void deleteList(int idx) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.delete("music.music_delete",idx);
		sqlSession.commit();
		sqlSession.close();	
	}
	
	public List<MusicVO> select(int memberidx) {
	      List<MusicVO> list = null;
	      SqlSession sqlSession = factory.openSession();
	      list = sqlSession.selectList("music.mymusic_list", memberidx);
	      sqlSession.close();
	      return list;
	}
	
	//페이징
	public int selectCount() {
		SqlSession sqlSession = factory.openSession();
		int count =(int)sqlSession.selectOne("music.music_count");
		sqlSession.close();
		return count;
	}
	public List<MusicVO> select(HashMap<String, String> map) {
		List<MusicVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("music.music_list_page", map);
		sqlSession.close();
		
		return list;
	}
	public List<MusicVO> myselect(HashMap<String, Integer> map) {
		List<MusicVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("music.mymusic_list_page", map);
		sqlSession.close();
		
		return list;
	}
	public int myselectCount(int idx) {
		SqlSession sqlSession = factory.openSession();
		int count =(int)sqlSession.selectOne("music.mymusic_count",idx);
		sqlSession.close();
		return count;
	}

}
