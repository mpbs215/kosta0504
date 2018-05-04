package ex0503.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ex0503.dto.CustomerDTO;
import ex0503.servlet.DBUtil;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public String idCheck(String id) {
		PreparedStatement ps =null;
		Connection conn = null;
		ResultSet rs=null;
		String result="";
		try {
			conn=DBUtil.getConnection();
			ps = conn.prepareStatement("select*from customer2 where id=?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				result="중복입니다";
			}else {
				result="사용가능한 아이디입니다.";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(ps, conn, rs);
		}
		
		return result;
	}

	@Override
	public int insert(CustomerDTO customerDTO) {
		PreparedStatement ps =null;
		Connection conn = null;
		int re=0;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("insert into customer2 values(?,?,?,?,?)");
			ps.setString(1, customerDTO.getId());
			ps.setString(2, customerDTO.getName());
			ps.setInt(3, customerDTO.getAge());
			ps.setString(4, customerDTO.getPhone());
			ps.setString(5, customerDTO.getAddr());
			re = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(ps, conn);
		}
		
		return re;
	}

	@Override
	public List<CustomerDTO> selectAll() {
		PreparedStatement ps =null;
		Connection conn = null;
		ResultSet rs = null;
		List<CustomerDTO> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select*from customer2");
			rs = ps.executeQuery();
			while(rs.next()) {
				String id=rs.getString(1);
				String name=rs.getString(2);
				int age = rs.getInt(3);
				String phone = rs.getString(4);
				String addr = rs.getString(5);
				CustomerDTO dto = new CustomerDTO(id, name, age, phone, addr);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(ps, conn, rs);
		}
		return list;
	}

	@Override
	public int update(CustomerDTO customerDTO) {
		PreparedStatement ps =null;
		Connection conn = null;
		int re=0;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("update customer2 set name=?,age=?,addr=?,tel=? where id=?");
			ps.setString(1, customerDTO.getName());
			ps.setInt(2, customerDTO.getAge());
			ps.setString(3, customerDTO.getAddr());
			ps.setString(4, customerDTO.getPhone());
			ps.setString(5, customerDTO.getId());
			re=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(ps, conn);
		}
		return re;
	}

	@Override
	public int delete(String id) {
		PreparedStatement ps =null;
		Connection conn = null;
		int re=0;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("delete from customer2 where id=?");
			ps.setString(1, id);
			re = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(ps, conn);
		}
		
		
		return re;
	}

}
