package ra.HR;

public class StatiticDepartment {
    private int departmentId;
    private String departmentName;
    private int cntDepartment;

    public StatiticDepartment() {
    }

    public StatiticDepartment(int departmentId, String departmentName, int cntDepartment) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.cntDepartment = cntDepartment;
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

    public int getCntDepartment() {
        return cntDepartment;
    }

    public void setCntDepartment(int cntDepartment) {
        this.cntDepartment = cntDepartment;
    }
}
