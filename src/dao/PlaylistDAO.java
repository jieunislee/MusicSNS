package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;

import vo.PlaylistVO;

public class PlaylistDAO {
	private static PlaylistDAO single = null;
	
	public static PlaylistDAO getInstance() {
		if(single == null)
			single = new PlaylistDAO();
		return single;
	}
	// ----------------------------------
	SqlSessionFactory factory = null;
	public PlaylistDAO() {
		// 객체 생성 시 커넥터에서 factory 전달 받음
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	public PlaylistVO selectOne(PlaylistVO vo) {
		PlaylistVO res_vo = null;
		
		SqlSession sqlSession = factory.openSession();
		// 파라미터로 CartVO를 넘겨서 select 쿼리 조건절에 사용
		res_vo = sqlSession.selectOne("playlist.playlist_one", vo);
		
		sqlSession.close();
		
		return res_vo;
	}
	public void insert(PlaylistVO vo) {
		SqlSession sqlSession = factory.openSession();
		
		// 매개변수(parameter)로 전달된 vo 객체의 내용을 추가한다.
		int res = sqlSession.insert("playlist.playlist_insert",vo);
		
		sqlSession.commit();
		sqlSession.close();
		// 수행 결과가 필요하다면 res 를 반환하여 사용 
	}
	public List<PlaylistVO> select(int memberidx) {
		List<PlaylistVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("playlist.playlist_list",memberidx);
		sqlSession.close();
		
		return list;
	}
	// 플레이리스트 삭제
	public void deleteList(int resultidx) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.delete("playlist.playlist_delete",resultidx);
		sqlSession.commit();
		sqlSession.close();	
	}
	
	//페이징
	public int myselectCount(int idx) {
		SqlSession sqlSession = factory.openSession();
		int count =(int)sqlSession.selectOne("playlist.myplaylist_count",idx);
		sqlSession.close();
		return count;
	}
	public List<PlaylistVO> myselect(HashMap<String, Integer> map) {
		List<PlaylistVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("playlist.myplaylist_list_page", map);
		sqlSession.close();
		
		return list;
	}
}
