package Main;

import org.apache.ibatis.session.SqlSession;

import kr.or.kosta.service.SqlMapClient;

public class SqlSessionMain {

	public static void main(String[] args) {
		SqlSession sqlsession= SqlMapClient.getSqlSession();
		System.out.println(sqlsession.toString());
		sqlsession.close();
		
		SqlSession sqlsession2= SqlMapClient.getSqlSession();
		System.out.println(sqlsession2.toString());
	}

}
