package ra.HR;

import ra.business.DepartmentsBusiness;

import java.util.Scanner;

public class Department implements IHR {
    private int departmentId;
    private String departmentName;
    private boolean departmentStatus;

    public Department() {
    }

    public Department(int departmentId, String departmentName, boolean departmentStatus) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentStatus = departmentStatus;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public boolean isDepartmentStatus() {
        return departmentStatus;
    }

    public void setDepartmentStatus(boolean departmentStatus) {
        this.departmentStatus = departmentStatus;
    }

    @Override
    public void inputData(Scanner sc) {
        this.departmentName = inputDepartmentName(sc);
    }

    public String inputDepartmentName(Scanner sc) {
        System.out.println("Nhập vào tên phòng ban: ");
        do {
            String departmentName = sc.nextLine();
            boolean isExist = DepartmentsBusiness.isExistDepartment(0, departmentName);
            if (isExist) {
                System.err.println("Tên phòng ban bị trùng khớp");
            } else {
                return departmentName;
            }
        } while (true);
    }

    @Override
    public void displayData() {
        System.out.printf("Mã phòng ban: %d - Tên phòng ban: %s - Trạng thái phòng ban: %s\n", this.departmentId, this.departmentName, this.departmentStatus ? "Đang hoạt động" : "Ngừng hoạt động");
    }
}
