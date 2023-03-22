package com.kwon.sddevice.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kiung.kwon.db.manager.KwonDBManager;

// M : back-end개발자
public class DeviceDAO {
	private int allDeviceCount;

	public DeviceDAO() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = KwonDBManager.connect("jdbc:oracle:thin:@192.168.0.32:1521:xe", "teacher", "1");
			String sql = "select count(*) from sd_device";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allDeviceCount = rs.getInt("count(*)");
		} catch (Exception e) {
		}
		KwonDBManager.close(con, pstmt, rs);
	}

	public ArrayList<Device> getDevice(int pageNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = KwonDBManager.connect("jdbc:oracle:thin:@192.168.0.32:1521:xe", "teacher", "1");

			int devicePerPage = 5;
			int start = (pageNo - 1) * devicePerPage + 1;
			int end = pageNo * devicePerPage;

			String sql = "select * " + "from ( "
					+ "	select rownum as rn, sd_no, sd_name, sd_cate, sd_price, sd_where " + "	from ( "
					+ "		select *  " + "		from sd_device " + "		order by sd_name, sd_no " + "	) " + ") "
					+ "where rn >= ? and rn <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			ArrayList<Device> devices = new ArrayList<>();
			while (rs.next()) {
				devices.add(new Device(
						rs.getInt("sd_no"), 
						rs.getString("sd_name"), 
						rs.getString("sd_cate"),
						rs.getInt("sd_price"), 
						rs.getString("sd_where")));
			}
			return devices;
		} catch (Exception e) {
			return null;
		} finally {
			KwonDBManager.close(con, pstmt, rs);
		}

	}

	public int getPageCount() {
		double devicePerPage = 5;
		int pageCount = (int) Math.ceil(allDeviceCount / devicePerPage);
		return pageCount;
	}

	public String regDevice(Device d) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = KwonDBManager.connect("jdbc:oracle:thin:@192.168.0.32:1521:xe", "teacher", "1");

			String sql = "insert into sd_device " + "values(sd_seq.nextval, ?, ?, ?, ?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, d.getName());
			pstmt.setString(2, d.getCate());
			pstmt.setInt(3, d.getPrice());
			pstmt.setString(4, d.getWhere());

			if (pstmt.executeUpdate() == 1) {
				allDeviceCount++;
				return "성공";
			}
			return "실패";
		} catch (Exception e) {
			return "실패";
		} finally {
			KwonDBManager.close(con, pstmt, null);
		}
	}
}
