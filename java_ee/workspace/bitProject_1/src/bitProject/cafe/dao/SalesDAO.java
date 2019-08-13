package bitProject.cafe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bitProject.cafe.dto.OrderDTO;
import bitProject.cafe.view.OrderDisp;

public class SalesDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "java";
	private String password = "dkdlxl";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private OrderDisp disp;
	private static SalesDAO instance;

	public static SalesDAO getInstance() {
		if (instance == null) {
			synchronized (MemberDAO.class) {
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
	
	public int insert(OrderDTO order) {
		getConnection();
		int cnt = 0;
		
		String id = order.getId();
		String menuName = order.getMenuName();
		int amount = order.getAmount();
		int menuPrice = order.getMenuPrice();
		int totPrice = order.getAmount() * order.getMenuPrice();
		String orderDate = order.getOrderDate();
		
		String sql = "INSERT INTO CAFE_SALES VALUES(?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, menuName);
			pstmt.setInt(3, amount);
			pstmt.setInt(4, menuPrice);
			pstmt.setInt(5, totPrice);
			pstmt.setString(6, orderDate);
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}
	
	
	public ArrayList<OrderDTO> dispAll() { // 전체출력
		getConnection();		
		ArrayList<OrderDTO> list = new ArrayList<OrderDTO>();
		
		String sql = "SELECT * FROM CAFE_SALES";
		try {
			pstmt = conn.prepareStatement(sql);
			execute(sql, list);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
			
		return list;
	}
	
	public ArrayList<OrderDTO> dispById(String searchId) { // 아이디로 출력
		getConnection();		
		ArrayList<OrderDTO> list = new ArrayList<OrderDTO>();
		
		String sql = "SELECT * FROM CAFE_SALES WHERE ID = ?";
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, searchId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		execute(sql, list);
			
		return list;
	}
	
	public ArrayList<OrderDTO> dispByDate(String searchDate) { // 날짜로 출력 
		getConnection();		
		ArrayList<OrderDTO> list = new ArrayList<OrderDTO>();	
		String sql = "SELECT * FROM CAFE_SALES WHERE ORDERDATE = ?";
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setString(1, searchDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		execute(sql, list);
		System.out.println(list.size());
			
		return list;
	}
	
	public void execute(String sql, ArrayList<OrderDTO> list) {
		try {	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	
				OrderDTO order = new OrderDTO();
				String id = rs.getString("id");
				String menuName = rs.getString("menuName");
				int amount = rs.getInt("amount");
				int menuPrice = rs.getInt("menuPrice");
				String orderDate = rs.getString("orderDate");

				order.setId(id);
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
	}
}
