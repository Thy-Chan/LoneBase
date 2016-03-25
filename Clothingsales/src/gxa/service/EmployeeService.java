package gxa.service;

import gxa.dao.EntityDao;
import gxa.db.BarAndPie;
import gxa.db.Employee;
import gxa.util.ProcessSql;
import gxa.web.page.PageInfo;

import java.util.List;

public class EmployeeService {
	EntityDao dao;
	DepotforEmployee depotforEmployee;

	public EmployeeService() {
		super();
		depotforEmployee = new DepotService();
		dao = new EntityDao();

	}

	public List getAllEmployee(PageInfo pageinfo) {
		// .class��ʾ����
		return dao.getAll("select * from employee",
				"select count(*) from employee", new Employee(), pageinfo);
	}

	public Employee getEmployeeById(String id) {
		return (Employee) dao.getOBJById("select * from employee where e_id = "
				+ id, new Employee());
	}

	public String deleteById(String id) {
		String sql = "delete from employee where e_id=" + id;
		String msg;
		int rs = dao.dml(sql);
		if (rs >= 0) {
			msg = "ɾ���ɹ�����ɾ��" + rs + "����¼";

		} else {
			msg = "ɾ��ʧ��!";
		}
		return msg;
	}

	// �������
	public String add(Employee Employee) {
		String msg = "";
		int rs = dao.dml(ProcessSql.processInsert(Employee));
		if (rs >= 0) {
			msg = "��ӳɹ����������" + rs + "����¼";
		} else {
			msg = "���ʧ��";
		}
		return msg;
	}

	public String update(Employee employee) {
		String msg = "";
		int rs = dao.dml(ProcessSql.processUpdate(employee));
		if (rs > 0) {
			msg = "�޸ĳɹ������޸ļ���" + rs + "����¼";
		} else {
			msg = "�޸�ʧ��";
		}
		return msg;
	}
	

	public List getBarAndPie(Employee e) {
		String sql="select datepart(MM,[time]) as item,count(*) as no from shop "
				+ "where e_id ="+e.getE_id() + " group by datepart(MM,[time])";
		System.out.println(sql);
		return dao.getAll(
				sql,
				null, new BarAndPie(), null);
    
	}

	public List getdepot() {

		return depotforEmployee.getAllDepot();

	}

	public String updatepwd(String name, String pwd) {
		String msg = "";
		int rs = dao.dml("update [Employee] set e_pwd='"+pwd+"' where e_name='"+name+"'");
		System.out.println("update [Employee] set e_pwd='"+pwd+"' where e_name='"+name+"'");
		if (rs > 0) {
			msg = "�޸ĳɹ������޸ļ���" + rs + "����¼";
		} else {
			msg = "�޸�ʧ��";
		}
		return msg;
	}
}
