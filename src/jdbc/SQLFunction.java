package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLFunction {
	final static String TERM = "大三下";	

	// 登录--教师、学生
	public static boolean login(Login user) {
		Connection conn = DButil.open();
		String sql = "select * from Login where Account=? and Password=? and Flag=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getAccount());
			pstat.setString(2, user.getPassword());
			pstat.setString(3, user.getFlag());
			ResultSet rs = pstat.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return false;
	}

	// 添加学生个人信息--教师
	public static boolean addStudentInfo(Student stu) {
		Connection conn = DButil.open();
		String sql = "insert into Student values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, stu.getSNO());
			stat.setString(2, stu.getSName());
			stat.setString(3, stu.getBirthday());
			stat.setInt(4, stu.getAge());
			stat.setString(5, stu.getSex());
			stat.setString(6, stu.getIdentity());
			stat.setString(7, stu.getSchool());
			stat.setString(8, stu.getIntroduction());
			stat.setString(9, stu.getPhoto());
			stat.setString(10, stu.getAddress());
			stat.setString(11, stu.getPostnum());
			stat.setString(12, stu.getMajor());

			stat.execute();
			return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return false;
	}

	// 删除学生个人信息--教师
	public static boolean deleteStudentInfo(Student stu) {
		Connection conn = DButil.open();
		String sql = "delete from Student where SNO=?";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, stu.getSNO());

			stat.execute();
			return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return false;
	}

	// 修改学生个人信息--教师
	public static boolean updateStudentInfo(Student stu) {
		Connection conn = DButil.open();
		String sql = "update Student set SName=?,Birthday=?,Age=?,Sex=?,Identity=?,School=?,Introduction=?,Photo=?,Address=?,Postnum=?,Major=? where SNO=?";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, stu.getSName());
			stat.setString(2, stu.getBirthday());
			stat.setInt(3, stu.getAge());
			stat.setString(4, stu.getSex());
			stat.setString(5, stu.getIdentity());
			stat.setString(6, stu.getSchool());
			stat.setString(7, stu.getIntroduction());
			stat.setString(8, stu.getPhoto());
			stat.setString(9, stu.getAddress());
			stat.setString(10, stu.getPostnum());
			stat.setString(11, stu.getMajor());
			stat.setString(12, stu.getSNO());

			stat.execute();
			return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return false;
	}

	// 查询学生个人信息（按学号）--教师、学生
	public static Student queryStudentInfoBySNO(Student stu) {
		Connection conn = DButil.open();
		String sql = "select * from Student where SNO=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, stu.getSNO());

			ResultSet rs = pstat.executeQuery();
			if (rs.next()) {
				Student retStu = new Student();
				retStu.setSNO(rs.getString(1));
				retStu.setSName(rs.getString(2));
				retStu.setBirthday(rs.getString(3));
				retStu.setAge(Integer.parseInt(rs.getString(4)));
				retStu.setSex(rs.getString(5));
				retStu.setIdentity(rs.getString(6));
				retStu.setSchool(rs.getString(7));
				retStu.setIntroduction(rs.getString(8));
				retStu.setPhoto(rs.getString(9));
				retStu.setAddress(rs.getString(10));
				retStu.setPostnum(rs.getString(11));
				retStu.setMajor(rs.getString(12));
				return retStu;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return null;
	}

	// 查询学生个人信息（按姓名）--教师
	public static List<Student> queryStudentInfoBySName(Student stu) {
		Connection conn = DButil.open();
		String sql = "select * from Student where SName=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, stu.getSName());

			ResultSet rs = pstat.executeQuery();
			List<Student> list = new ArrayList<Student>();
			while (rs.next()) {
				Student retStu = new Student();
				retStu.setSNO(rs.getString(1));
				retStu.setSName(rs.getString(2));
				retStu.setBirthday(rs.getString(3));
				retStu.setAge(Integer.parseInt(rs.getString(4)));
				retStu.setSex(rs.getString(5));
				retStu.setIdentity(rs.getString(6));
				retStu.setSchool(rs.getString(7));
				retStu.setIntroduction(rs.getString(8));
				retStu.setPhoto(rs.getString(9));
				retStu.setAddress(rs.getString(10));
				retStu.setPostnum(rs.getString(11));
				retStu.setMajor(rs.getString(12));
				list.add(retStu);
			}
			return list;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return null;
	}

	// 查询学生成绩（按学号）--教师、学生
	public static List<Grade> queryGradeBySNO(Student stu) {
		Connection conn = DButil.open();
		String sql = "select * from Grade where SNO=? and Grade>=0";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, stu.getSNO());

			ResultSet rs = pstat.executeQuery();
			List<Grade> list = new ArrayList<Grade>();
			while (rs.next()) {
				Grade retGra = new Grade();
				retGra.setTerm(rs.getString(1));
				retGra.setSNO(rs.getString(2));
				retGra.setSName(rs.getString(3));
				retGra.setCNO(rs.getString(4));
				retGra.setCName(rs.getString(5));
				retGra.setGrade(Integer.parseInt(rs.getString(6)));
				list.add(retGra);
			}
			return list;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return null;
	}

	// 查询学生成绩（按姓名）--教师
	public static List<Grade> queryGradeBySName(Student stu) {
		Connection conn = DButil.open();
		String sql = "select * from Grade where SName=? and Grade>=0";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, stu.getSName());

			ResultSet rs = pstat.executeQuery();
			List<Grade> list = new ArrayList<Grade>();
			while (rs.next()) {
				Grade retGra = new Grade();
				retGra.setTerm(rs.getString(1));
				retGra.setSNO(rs.getString(2));
				retGra.setSName(rs.getString(3));
				retGra.setCNO(rs.getString(4));
				retGra.setCName(rs.getString(5));
				retGra.setGrade(Integer.parseInt(rs.getString(6)));
				list.add(retGra);
			}
			return list;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return null;
	}

	// 查询课程表--学生
	public static List<Course> queryCourse(Student stu) {
		Connection conn = DButil.open();
		String sql = "select * from Course where CNO in (select CNO from Grade where SNO=?)";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, stu.getSNO());

			ResultSet rs = pstat.executeQuery();
			List<Course> list = new ArrayList<Course>();
			while (rs.next()) {
				Course retCou = new Course();
				retCou.setCNO(rs.getString(1));
				retCou.setCName(rs.getString(2));
				retCou.setCredit(Integer.parseInt(rs.getString(3)));
				retCou.setType(rs.getString(4));
				list.add(retCou);
			}
			return list;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return null;
	}

	// 查询选修课列表
	public static List<Course> queryCourseChoice() {
		Connection conn = DButil.open();
		String sql = "select * from Course where Type=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, "选修课");

			ResultSet rs = pstat.executeQuery();
			List<Course> list = new ArrayList<Course>();
			while (rs.next()) {
				Course retCou = new Course();
				retCou.setCNO(rs.getString(1));
				retCou.setCName(rs.getString(2));
				retCou.setCredit(Integer.parseInt(rs.getString(3)));
				retCou.setType(rs.getString(4));
				list.add(retCou);
			}
			return list;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return null;
	}

	// 查询课程信息
	public static Course queryCourseInfo(Course cou) {
		Connection conn = DButil.open();
		String sql = "select * from Course where CNO=?";
		try {
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, cou.getCNO());

			ResultSet rs = pstat.executeQuery();
			if (rs.next()) {
				Course retCou = new Course();
				retCou.setCNO(rs.getString(1));
				retCou.setCName(rs.getString(2));
				retCou.setCredit(Integer.parseInt(rs.getString(3)));
				retCou.setType(rs.getString(4));
				return retCou;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return null;
	}

	// 更新课程表（学生报名选修课）--学生
	public static boolean updateGrade(Student stu, Course cou) {
		Connection conn = DButil.open();
		String sql = "insert into Grade values(?,?,?,?,?,?)";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, TERM);
			stat.setString(2, stu.getSNO());
			stat.setString(3, stu.getSName());
			stat.setString(4, cou.getCNO());
			stat.setString(5, cou.getCName());
			stat.setInt(6, -1);

			stat.execute();
			return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return false;
	}

	// 添加学生账户--教师
	public static boolean addStudentAccount(Login stulog) {
		Connection conn = DButil.open();
		String sql = "insert into Login values(?,?,?)";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, stulog.getAccount());
			stat.setString(2, stulog.getPassword());
			stat.setString(3, "Student");

			stat.execute();
			return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return false;
	}

	// 删除学生账户--教师
	public static boolean deleteStudentAccount(Login stulog) {
		Connection conn = DButil.open();
		String sql = "delete from Login where Account=? and Flag=?";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, stulog.getAccount());
			stat.setString(2, stulog.getFlag());

			stat.execute();
			return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return false;
	}

	// 修改学生账户密码--教师
	public static boolean updateStudentAccount(Login stulog) {
		Connection conn = DButil.open();
		String sql = "update Login set Password=? where Account=? and Flag=?";
		try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, stulog.getPassword());
			stat.setString(2, stulog.getAccount());
			stat.setString(3, stulog.getFlag());

			stat.execute();
			return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
		return false;
	}

}
