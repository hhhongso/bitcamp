package bitProject.cafe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bitProject.cafe.dto.OrderDTO;
import bitProject.cafe.view.SalesDisp;

public class SalesDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "java";
	private String password = "dkdlxl";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static SalesDAO instance;

	public static SalesDAO getInstance() {
		if (instance == null) {
			synchronized (SalesDAO.class) {
				instance = new SalesDAO();
			}
		}
		return instance;
	}

	public SalesDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<OrderDTO> dispAll() { // 전체출력
		getConnection();		
		ArrayList<OrderDTO> list = new ArrayList<OrderDTO>();
		
		String sql = "SELECT * FROM CAFE_SALES";

		try {	
			pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {	
					OrderDTO order = new OrderDTO();
					String menuName = rs.getString("menuName");
					int amount = rs.getInt("amount");
					int menuPrice = rs.getInt("menuPrice");
					String orderDate = rs.getString("orderDate");

					order.setMenuName(menuName);
					order.setAmount(amount);
					order.setMenuPrice(menuPrice);
					order.setOrderDate(orderDate);
					
					list.add(order);
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			
		return list;
	}

	

}
