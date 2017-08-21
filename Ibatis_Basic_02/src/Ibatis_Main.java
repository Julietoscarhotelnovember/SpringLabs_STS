import Ibatis.DAO.EmpDao;
import Ibatis.DTO.Emp;

public class Ibatis_Main {

	public static void main(String[] args) {
		EmpDao dao = EmpDao.getInstance();
		
		//insert 
		Emp e = new Emp();
		e.setEmpno(6666);
		e.setEname("hong");
		e.setJob("NOT");
		e.setSal(10);
		
		try{
			dao.InsertEmp(e);
			Emp empdata = dao.SelectEmp("hong");
			System.out.println(empdata.toString());
		}catch(Exception ex){
			
		}

	}

}
