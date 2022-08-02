package com.flipkart.bean;
import com.flipkart.bean.User;
public class Student extends User {
	

	//private String studentId;
	//private String studentName;
	private String branch;
	private int semester;
	private boolean feePaymentStatus;
	private String password;
	private boolean isApproved;
	
	
	/**
	 * @param branch
	 * @param semester
	 */
	public Student(String userID, String name, String role, String password , String branch, int semester,boolean feePaymentStatus,boolean isApproved ) {
		super(userID, name, role, password);
		//this.studentId = studentId;
		//this.name =studentName;
		
		this.branch = branch;
		this.semester = semester;
		this.feePaymentStatus = feePaymentStatus;
		this.isApproved = isApproved;
	}
	public Student(){

	}
	
	
	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}
	/**
	 * @return the semester
	 */
	public int getSemester() {
		return semester;
	}
	/**
	 * @param semester the semester to set
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}
	
    /**
     * Check Payment Status
     * @return
     */
    public boolean isFeePaymentStatus() {
        return feePaymentStatus;
    }

    /**
     * Set Payment Status
     * @param feePaymentStatus
     */
    public void setFeePaymentStatus(boolean feePaymentStatus) {
        this.feePaymentStatus = feePaymentStatus;
    }
    
    
    /**
     * Check Registration Status
     * @return
     */
    public boolean isRegistered() {
        return isApproved;
    }

    /**
     * Set Registration Status
     * @param registered
     */

    public void setRegistered(boolean registered) {
        isApproved = registered;
    }
    

	
	
}
