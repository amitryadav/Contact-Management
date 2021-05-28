package com.interview.contactmgt.util;

/*@author AmitYadav
 * @date-26 may 2021
 * @created by  AmitYadav
 * @Class ContactRespoCode
 */
public enum ContactRespoCode {
	C116(116,"error while deactiveting contact"),
	C200(200,"contact added successfully"),
	C101(101,"contact edited successfully"),
	C102(102,"contact details not found"),
	C103(103,"Error while editing Contact"),
	C104(104,"contact  deactivated successfully"),
	C105(105,"Active"),
	C106(106,"Inactive"),
	C107(107,"Error while getting Contact List"),
	C108(108,"please provide valid email"),
	C109(109,"please provide valid firstName"),
	C110(110,"please provide valid phoneNumber"),
	C111(111,"please provide valid lastName"),
	C112(112,"Error while getting contact details by id"),
	C113(113,"Error while in Save Contact"),
	C114(114,"Error while in update Contact"),
	C115(115,"Error while adding Contact");

	private int code;
	private String value;

	private ContactRespoCode(int code,String value) {
		this.code = code;
		this.value = value;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
