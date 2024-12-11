package ra.HRManagement;

import ra.HR.Department;
import ra.HR.StatiticDepartment;
import ra.business.DepartmentsBusiness;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HRManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("******************HR-MANAGEMENT******************");
            System.out.println("1. Quản lí phòng ban");
            System.out.println("2. Quản lí nhân viên");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    inputDepartment(sc);
                    break;
                case 2:
                    inputEmployee(sc);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1 đến 3");
            }
        } while (true);
    }

    public static void inputDepartment(Scanner sc) {
        int choice;
        do {
            System.out.println("**********************DEPARTMENT-MENU********************");
            System.out.println("1. Danh sách phòng ban");
            System.out.println("2. Thêm mới phòng ban");
            System.out.println("3. Cập nhật phòng ban");
            System.out.println("4. Xóa phòng ban");
            System.out.println("5. Hiển thị phòng ban có nhiều nhân viên nhất");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn là: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    displayDepartment(sc);
                    break;
                case 2:
                    createDepartment(sc);
                    break;
                case 3:
                    updateDepartment(sc);
                    break;
                case 4:
                    deleteDepartment(sc);
                    break;
                case 5:
                    displayDepartmentList(sc);
                    break;
                case 6:
                    System.out.println("Đang thoát Department Menu...");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ, vui lòng chọn lại !");
            }
        } while (choice != 6);
    }

    public static void displayDepartment(Scanner sc) {
        List<Department> listDepartment = DepartmentsBusiness.findAll();
        listDepartment.forEach(Department::displayData);
    }

    public static void createDepartment(Scanner sc) {
        Department department = new Department();
        department.inputDepartmentName(sc);
        department.setDepartmentStatus(true);
        boolean result = DepartmentsBusiness.createDepartment(department);
        if (result) {
            System.out.println("Thêm mới thành công");
        } else {
            System.err.println("Thêm mới thất bại");
            ;
        }
    }

    public static void updateDepartment(Scanner sc) {
        System.out.println("Nhập vào mã phòng ban cần cập nhật: ");
        int departmentId = Integer.parseInt(sc.nextLine());
        Department departmentUpdate = DepartmentsBusiness.findById(departmentId);
        if (departmentUpdate != null) {
            System.out.println("Nhập vào tên cần cập nhật: ");
            boolean isExistDepartmentName = true;
            do {
                String departmentName = sc.nextLine();
                boolean isExist = DepartmentsBusiness.isExistDepartment(departmentId, departmentName);
                if (isExist) {
                    departmentUpdate.setDepartmentName(departmentName);
                    isExistDepartmentName = false;
                }
            } while (isExistDepartmentName);
            boolean result = DepartmentsBusiness.updateDepartment(departmentUpdate);
            if (result) {
                System.out.println("Cập nhật thành công");
            } else {
                System.err.println("Cập nhật thất bại");
            }
        } else {
            System.err.println("Mã loại sách không tồn tại !");
        }
    }

    public static void deleteDepartment(Scanner sc) {
        System.out.println("Nhập mã phòng ban cần xóa: ");
        int departmentId = Integer.parseInt(sc.nextLine());
        Department departmentDelete = DepartmentsBusiness.findById(departmentId);
        if (departmentDelete != null) {
            boolean result = DepartmentsBusiness.deleteDepartment(departmentId);
            if (result) {
                System.out.println("Xóa thành công");
            } else {
                System.err.println("Xóa thất bại");
            }
        }
    }

    public static void displayDepartmentList(Scanner sc) {
        List<StatiticDepartment> listStatiticDepartment = DepartmentsBusiness.statiticDepartment();
        listStatiticDepartment.forEach(statiticDepartment -> {
            System.out.printf("%d - %s - %d nhân viên\n", statiticDepartment.getDepartmentId(), statiticDepartment.getDepartmentName(), statiticDepartment.getDepartmentId());
        });
    }

    public static void inputEmployee(Scanner sc) {
        int choice;
        do {
            System.out.println("**********************EMPLOYEE-MENU********************");
            System.out.println("1. Danh sách nhân viên");
            System.out.println("2. Thêm mới phòng ban");
            System.out.println("3. Cập nhật nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Hiển thị phòng ban có nhiều nhân viên nhất");
            System.out.println("6.Tìm kiếm danh sách nhân viên theo phòng ban");
            System.out.println("7.Hiển thị top 5 nhân viên có lương cao nhất");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn là: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("Đang thoát Employee Menu...");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ, vui lòng chọn lại !");
            }
        } while (choice != 8);
    }
}
