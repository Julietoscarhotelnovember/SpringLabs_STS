package Ibatis.DAO;

import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import Ibatis.DTO.Emp;

public class EmpDao {
	//CRUD 작업 (연결설정)
	private static EmpDao instance = new EmpDao();
	private SqlMapClient sqlMap;
	private EmpDao(){
		Reader reader;
		
		try{
			reader = Resources.getResourceAsReader("Config/SqlMapConfig.xml");
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		}catch(Exception e){
			
		}
	}
	public static EmpDao getInstance(){
		return instance;
	}
	
	public void InsertEmp(Emp e) throws SQLException{
		//values(?,?,?,?) 설정
		//pstmt.setString(e.getEmpno());
		//위 작업 안해요

		sqlMap.insert("insertEmp",e);

	}
	public Emp SelectEmp(String ename) throws SQLException{
		return (Emp)sqlMap.queryForObject("selectEmp", ename);
		//한 건의 row > queryForObject
	}
}
