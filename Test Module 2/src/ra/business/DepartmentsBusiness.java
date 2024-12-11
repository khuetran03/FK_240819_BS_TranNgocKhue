package ra.business;

import ra.HR.Department;
import ra.HR.StatiticDepartment;
import ra.until.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsBusiness {
    public static List<Department> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Department> listDepartments = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_departments()}");
            ResultSet rs = callSt.executeQuery();
            listDepartments = new ArrayList<>();
            while (rs.next()) {
                Department department = new Department();
                department.setDepartmentId(rs.getInt("proc_department_id"));
                department.setDepartmentName(rs.getString("proc_department_name"));
                department.setDepartmentStatus(rs.getBoolean("proc_departent_status"));
                listDepartments.add(department);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
    }
        return listDepartments;
    }

    public static boolean createDepartment(Department department) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_deparments(?,?)}");
            callSt.setString(1, department.getDepartmentName());
            callSt.setBoolean(2, department.isDepartmentStatus());
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    public static boolean updateDepartment(Department department) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_departments(?,?)}");
            callSt.setString(1, department.getDepartmentName());
            callSt.setBoolean(2, department.isDepartmentStatus());
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    public static Department findById(int departmentId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Department department = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_department_by_id(?)}");
            callSt.setInt(1, departmentId);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                department = new Department();
                department.setDepartmentId(rs.getInt("proc_department_id"));
                department.setDepartmentName(rs.getString("proc_department_name"));
                department.setDepartmentStatus(rs.getBoolean("proc_departent_status"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return department;
    }

    public static boolean deleteDepartment(int departmentId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_departments(?,?)}");
            callSt.setInt(1, departmentId);
            callSt.executeUpdate();
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    public static List<StatiticDepartment> statiticDepartment() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<StatiticDepartment> listStatiticDepartment = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call count_departments()}");
            ResultSet rs = callSt.executeQuery();
            listStatiticDepartment = new ArrayList<>();
            while (rs.next()) {
                StatiticDepartment statiticDepartment = new StatiticDepartment();
                statiticDepartment.setDepartmentId(rs.getInt("proc_department_id"));
                statiticDepartment.setDepartmentName(rs.getString("proc_department_name"));
                statiticDepartment.setCntDepartment(rs.getInt("cnt_department"));
                listStatiticDepartment.add(statiticDepartment);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listStatiticDepartment;
    }

    public static boolean isExistDepartment(int departmentId,String departmentName) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean isExist = false;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call is_check_exist_department(?,?,?)}");
            callSt.setString(1, departmentName);
            callSt.setInt(2, departmentId);
            callSt.registerOutParameter(3, Types.BOOLEAN);
            callSt.execute();
            isExist = callSt.getBoolean(3);
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return isExist;
    }
}
