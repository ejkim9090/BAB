package kh.spring.bab.mail.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.bab.mail.domain.MailRcv;
import kh.spring.bab.mail.domain.MailSend;

@Repository
public class MailDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertSendMail(MailSend mailSend) {
		return sqlSession.insert("Mail.insertSendMail", mailSend);
	}
	
	public int insertRcvMail(MailRcv mailRcv) {
		return sqlSession.insert("Mail.insertRcvMail", mailRcv);
	}
	
	public List<MailRcv> selectRcvMail(int currentPage, int pageSize, String email){
		return sqlSession.selectList("Mail.selectRcvMail", email, new RowBounds((currentPage-1)*pageSize, pageSize));
	}
	
	public int selectRcvTotalCnt() {
		return sqlSession.selectOne("Mail.selectRcvTotalCnt");
	}
	
	public List<MailSend> selectSndMail(int currentPage, int pageSize, String email){
		return sqlSession.selectList("Mail.selectSndMail", email, new RowBounds((currentPage-1)*pageSize, pageSize));
	}
	
	public int selectSndTotalCnt() {
		return sqlSession.selectOne("selectSndTotalCnt");
	}
}
