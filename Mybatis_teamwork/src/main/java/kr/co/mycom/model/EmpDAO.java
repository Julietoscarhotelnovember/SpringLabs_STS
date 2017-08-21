package kr.co.mycom.model;

import java.util.HashMap;
import java.util.List;

public interface EmpDAO {
	// 메서드 정의
	// CRUD 기반
	int insertEmp(EmpDTO dto);

	int updateEmp(EmpDTO dto);

	int deleteEmp(EmpDTO dto);

	List<EmpDTO> getEmpList(HashMap map);

	EmpDTO getEmp(int num);
	
	List<EmpDTO> getSearchList(HashMap map);
	
}