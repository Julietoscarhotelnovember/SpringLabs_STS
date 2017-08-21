package Ibatis;

import java.io.Reader;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IbatisMain {

	public static void main(String[] args) {
		String resource = "Ibatis/SqlMapConfig.xml";
		
		try{
			Reader reader = Resources.getResourceAsReader(resource);
			SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
			
			List list = sqlMap.queryForList("getAllEmp");
			for(int i =0 ; i < list.size() ; i++){
				System.out.println(list.get(i));
			}
		}catch(Exception e){
			
		}

	}

}
