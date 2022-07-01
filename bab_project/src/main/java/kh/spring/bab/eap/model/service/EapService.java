package kh.spring.bab.eap.model.service;

import java.util.List;

import kh.spring.bab.attendance.domain.Attendance;
import kh.spring.bab.eap.domain.Eap;
import kh.spring.bab.eap.domain.Spending;

public interface EapService {
	
	/**
	 * @author : 손은진
	 * @return : 문서양식-휴가신청서일 때 insert 결과
	 * */
	public int insertHoDoc();
	
	/**
	 * @author : 손은진
	 * @return : 문서양식-지출결의서일 때 insert 결과
	 * */
	public int insertSpDoc();
	
	/**
	 * @author : 손은진
	 * @return : 문서양식 번호 조회
	 * @param : 문서양식코드
	 * */
	public Eap selectDoc(String df_code);
	
	/**
	 * @author : 손은진
	 * @return : 결재선 리스트, 참조처 리스트 DB 저장 insert 결과(휴가신청서)
	 * @param : Eap vo
	 * */
	public int insertapp(Eap eap);
	
	/**
	 * @author : 손은진
	 * @return : 전자결재 테이블 update(휴가신청서 작성 시)
	 * @param : Eap vo
	 * */
	public int updateeap(Eap eap);
	
	/**
	 * @author : 손은진
	 * @return : 휴가테이블 insert
	 * @param : Attendance vo
	 * */
	public int insertatt(Attendance att);
	
	/**
	 * @author : 손은진
	 * @return : 지출테이블 insert
	 * @param : Spending vo
	 * */
	public int insertSp(Spending sp);
	
	/**
	 * @author : 손은진
	 * @return : 전자결재테이블 update(지출결의서 작성 시)
	 * @param : Eap vo
	 * */
	public int updateEapSp(Eap eap);
	
	/**
	 * @author : 손은진
	 * @return : 결재선 리스트, 참조처 리스트 DB 저장 insert 결과(지출결의서)
	 * @param : Eap vo
	 * */
	public int insertappsp(Eap eap);
	
	/**
	 * @author : 손은진
	 * @return : 결재 대기 문서
	 * @param : emp_no(로그인한 사람의 사번)
	 * */
	public List<Eap> selectBeforeDoc(String emp_no);
	
	/**
	 * @author : 손은진
	 * @return : 양식 처음 로드 시 띄울 정보
	 * @param : emp_no(로그인한 사람의 사번)
	 * */
	public Eap empInfo(String emp_no);
	
	/**
	 * @author : 손은진
	 * @return : 문서 상세 조회(휴가신청서)
	 * @param : df_no(문서번호)
	 * */
	public Eap readHoDoc(String df_no);
	
	/**
	 * @author : 손은진
	 * @return : 첫번째 승인자 정보
	 * @param : result(상세조회 후 저장된 Eap)
	 * */
	public Eap selectFirstAp(Eap result);
	
	/**
	 * @author : 손은진
	 * @return : 두번째 승인자 정보
	 * @param : result(상세조회 후 저장된 Eap)
	 * */
	public Eap selectMidAp(Eap result);
	
	/**
	 * @author : 손은진
	 * @return : 세번째 승인자 정보
	 * @param : result(상세조회 후 저장된 Eap)
	 * */
	public Eap selectFinalAp(Eap result);
	
	/**
	 * @author : 손은진
	 * @return : 휴가신청서에 저장된 정보 가져오기
	 * @param : att vo
	 * */
	public Attendance selectHoInfo(Attendance att);
	
	/**
	 * @author : 손은진
	 * @return : 문서 상세 조회(지출결의서)
	 * @param : df_no(문서번호)
	 * */
	public Eap readSpDoc(String df_no);
	
	/**
	 * @author : 손은진
	 * @return : 지출결의서에 저장된 정보 가져오기
	 * @param : sp vo
	 * */
	public Spending selectSpInfo(Spending sp);
	
	/**
	 * @author : 손은진
	 * @return : 남은 휴가일수 확인
	 * @param : emp_no(로그인한 사람의 사번)
	 * */
	public Double readHoCnt(String emp_no);
	
	/**
	 * @author : 손은진
	 * @return : 결재 회수
	 * @param : df_no(문서번호)
	 * */
	public int cancelDoc(String df_no);
	
	/**
	 * @author : 손은진
	 * @return : 문서 수정(지출결의서)
	 * @param : sp vo
	 * */
	public int updateSpDoc(Spending sp);
	
	/**
	 * @author : 손은진
	 * @return : 문서 수정(전자결재 테이블)
	 * @param : eap vo
	 * */
	public int updateEap(Eap eap);
	
	/**
	 * @author : 손은진
	 * @return : 문서 수정(휴가신청서)
	 * @param : att vo
	 * */
	public int updateHpDoc(Attendance att);
	
	/**
	 * @author : 손은진
	 * @return : 결재 대기 문서 개수
	 * @param : emp_no(로그인한 사람의 사번)
	 * */
	public int beDocCnt(String emp_no);
	
	/**
	 * @author : 손은진
	 * @return : 결재 수신 문서
	 * @param : emp_no(로그인한 사람의 사번)
	 * */
	public List<Eap> selectReceiptDoc(String emp_no);
	
	/**
	 * @author : 손은진
	 * @return : 결재 수신 문서 개수
	 * @param : emp_no(로그인한 사람의 사번)
	 * */
	public int reDocCnt(String emp_no);
	
	/**
	 * @author : 손은진
	 * @return : 결재 승인(결재자가 1명일 때)
	 * @param : eap vo
	 * */
	public int updateOneApp(Eap eap);
	
	/**
	 * @author : 손은진
	 * @return : 결재 승인(결재자가 2명 이상일 때)
	 * @param : eap vo
	 * */
	public int updateEapApp(Eap eap);
	
	/**
	 * @author : 손은진
	 * @return : 결재 반려(결재자가 1명일 때)
	 * @param : eap vo
	 * */
	public int updateOneRej(Eap eap);
	
	/**
	 * @author : 손은진
	 * @return : 결재 반려(결재자가 2명 이상일 때)
	 * @param : eap vo
	 * */
	public int updateEapRej(Eap eap);
	
	/**
	 * @author : 손은진
	 * @return : 기안 문서함
	 * @param : emp_no(로그인한 사람의 사번)
	 * */
	public List<Eap> selectInsertDoc(String emp_no);
	
	/**
	 * @author : 손은진
	 * @return : 결재 문서함
	 * @param : emp_no(로그인한 사람의 사번)
	 * */
	public List<Eap> selectResultDoc(String emp_no);
	
	/**
	 * @author : 손은진
	 * @return : 참조 문서함
	 * @param : emp_no(로그인한 사람의 사번)
	 * */
	public List<Eap> selectReferenceDoc(String emp_no);

}
